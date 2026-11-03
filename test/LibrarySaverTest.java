import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibrarySaverTest {
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
}
