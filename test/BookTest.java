import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    void testGetCreator() {

    //Arrange
    Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

    //Act
    String creator = book.getCreator();

    //Assert
        assertEquals("Allan B. Downey", creator);

    }
}
