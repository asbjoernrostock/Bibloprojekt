import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VideoGameTest {

    @Test
    void testVideoGameConstructorAndGetters() {
        //Arrange
        VideoGame videoGame1 = new VideoGame("5701234567891", "World of Warcraft", "Blizzard", "PC");

        //Act
        String identifier = videoGame1.getIdentifier();
        String title = videoGame1.getTitle();
        String creator = videoGame1.getCreator();
        String platform = videoGame1.getPlatform();

        //Assert
        assertEquals("5701234567891", identifier);
        assertEquals("World of Warcraft", title);
        assertEquals("Blizzard", creator);
        assertEquals("PC", platform);

    }
}
