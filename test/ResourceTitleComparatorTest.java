import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceTitleComparatorTest {

    @Test
    void testSortByTitle() {

        // Arrange
        Book book1 = new Book("1", "Zulu", "Forfatter A", 100);

        Book book2 = new Book("2", "Anders", "Forfatter B", 100);

        List<Resource> resources = new ArrayList<>(List.of(book1, book2));


        // Act
        resources.sort(new ResourceTitleComparator());


        // Assert
        assertEquals(book2, resources.get(0));
        assertEquals(book1, resources.get(1));
    }
}
