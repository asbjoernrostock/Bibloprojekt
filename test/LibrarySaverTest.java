import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibrarySaverTest {
    @Test
    void testSaveMembers() throws IOException {
        //Arrange
        Path folder = Path.of("test-data");

        LibrarySaver saver = new LibrarySaver(folder);

        List<Member> members = List.of(new Member("Lone Læder", 666),
                new Member("Finn Mig", 888));

        //Act
        Files.createDirectories(folder);

        saver.saveMembers(members);

        String actual = Files.readString(folder.resolve("members.csv"));
        String expected = "666,Lone Læder" + System.lineSeparator()
                + "888,Finn Mig" + System.lineSeparator();

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    void testSaveBooks() throws IOException {
        //Arrange
        Path folder = Path.of("test-data");

        LibrarySaver saver = new LibrarySaver(folder);

        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        Book book2 = new Book("9783161484101", "Jeg er dværg", "Lærke L. Hansen", 250);

        List<Resource> resources = List.of(book1, book2);

        Files.createDirectories(folder);

        //Act
        saver.saveBooks(resources);

        String actual = Files.readString(folder.resolve("books.csv"));
        String expected = "9783161484100,Think Java,Allan B. Downey,400" + System.lineSeparator()
                + "9783161484101,Jeg er dværg,Lærke L. Hansen,250" + System.lineSeparator();

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    void testSaveLoans() throws IOException {

        // Arrange
        Path folder = Path.of("test-data");

        LibrarySaver saver = new LibrarySaver(folder);

        Member member = new Member("Lone Læder", 666);

        Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        LocalDate borrowedDate = LocalDate.of(2026, 11, 1);

        LocalDate dueDate = LocalDate.of(2026, 12, 1);

        Loan loan = new Loan(book, member, borrowedDate, dueDate);

        List<Loan> loans = List.of(loan);
        Files.createDirectories(folder);


        // Act
        saver.saveLoans(loans);

        String actual = Files.readString(folder.resolve("loans.csv"));
        String expected = "666,9783161484100,2026-11-01,2026-12-01" + System.lineSeparator();

        // Assert
        assertEquals(expected, actual);
    }
}
