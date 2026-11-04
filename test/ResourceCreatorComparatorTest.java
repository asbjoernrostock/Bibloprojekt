import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceCreatorComparatorTest {

    @Test
    void testSortByCreator() {

        // Arrange
        Book book1 = new Book("1", "Book A", "Zulu", 100);

        Book book2 = new Book("2", "Book B", "Anders", 100);

        List<Resource> resources = new ArrayList<>(List.of(book1, book2));


        // Act
        resources.sort(new ResourceCreatorComparator());


        // Assert
        assertEquals(book2, resources.get(0));
    }
}
