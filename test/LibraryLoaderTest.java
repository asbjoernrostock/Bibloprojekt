import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryLoaderTest {

    @Test
    void testLoadMembers() throws IOException {

        // Arrange
        Path folder = Path.of("test-load-data");

        Files.createDirectories(folder);

        Files.writeString(folder.resolve("members.csv"), "666,Lone Læder"
                + System.lineSeparator() + "888,Finn Mig" + System.lineSeparator());

        LibraryLoader loader = new LibraryLoader(folder);


        // Act
        List<Member> members = loader.loadMembers();


        // Assert
        assertEquals(2, members.size());

        assertEquals(666, members.get(0).medlemsNummer());

        assertEquals("Lone Læder", members.get(0).navn());
    }
    @Test
    void testLoadBooks() throws IOException {

        // Arrange
        Path folder = Path.of("test-load-data");

        Files.createDirectories(folder);

        Files.writeString(folder.resolve("books.csv"),
                "9783161484100,Think Java,Allan B. Downey,400" + System.lineSeparator()
        );

        LibraryLoader loader = new LibraryLoader(folder);


        // Act
        List<Resource> resources = loader.loadBooks();


        // Assert
        assertEquals(1, resources.size());

        Resource resource = resources.get(0);

        assertEquals("9783161484100", resource.getIdentifier());

        assertEquals("Think Java", resource.getTitle());

        assertTrue(resource instanceof Book);

        Book book = (Book) resource;

        assertEquals(400, book.getPages());
    }
    @Test
    void testLoadLoans() throws IOException {

        // Arrange
        Path folder =
                Path.of("test-load-data");

        Files.createDirectories(folder);

        Files.writeString(folder.resolve("loans.csv"),
                "666,9783161484100,2026-11-01,2026-12-01" + System.lineSeparator());

        Member member = new Member("Lone Læder", 666);

        Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        List<Member> members = List.of(member);

        List<Resource> resources = List.of(book);

        LibraryLoader loader = new LibraryLoader(folder);


        // Act
        List<Loan> loans = loader.loadLoans(members, resources);


        // Assert
        assertEquals(1, loans.size());

        Loan loan = loans.get(0);

        assertEquals(member, loan.getMember());

        assertEquals(book, loan.getResource());
    }
}
