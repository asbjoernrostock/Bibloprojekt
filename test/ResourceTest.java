import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceTest {
    @Test
    void testNaturalSortByIdentifier() {
        // Arrange
        Book book = new Book("9783161484103", "Harry Potter", "J. K. Rowling", 400);

        Movie movie = new Movie("5701234567890", "Spider Man", "Marvel", "Ken Læder", 80);

        List<Resource> resources = new ArrayList<>(List.of(book, movie));


        // Act
        resources.sort(null);

        // Assert
        assertEquals(movie, resources.get(0));
        assertEquals(book, resources.get(1));
    }

}
