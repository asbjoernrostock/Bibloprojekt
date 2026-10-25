import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    void testMovieConstructorAndGetters() {
        //Arrange
        Movie movie = new Movie("5701234567890", "Spider Man", "Marvel", "Ken Læder", 80);

        //Act
        String identifier = movie.getIdentifier();
        String title = movie.getTitle();
        String creator = movie.getCreator();
        String director = movie.getDirector();
        int duration = movie.getDuration();

        //Assert
        assertEquals("5701234567890", identifier);
        assertEquals("Spider Man", title);
        assertEquals("Marvel", creator);
        assertEquals("Ken Læder", director);
        assertEquals(80, duration);
    }
}
