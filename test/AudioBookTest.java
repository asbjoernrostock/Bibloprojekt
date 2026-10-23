import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AudioBookTest {
    @Test
    void audioBookTest() {
        //Arrange
        AudioBook audioBook1 = new AudioBook("9783161484103", "Harry Potter", "J. K. Rowling", 70);
        //Act
        String creator = audioBook1.getCreator();
        //Assert
        assertEquals("J. K. Rowling", creator);
    }
    @Test
    void audioBookTestTrue() {

        //Arrange
        AudioBook audioBook1 = new AudioBook("9783161484103", "Harry Potter", "J. K. Rowling", 70);
        //Act
        int duration = audioBook1.getDuration();
        //Assert
        assertTrue(70 <= duration);
    }
}

