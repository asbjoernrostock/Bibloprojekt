import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CollatorTest {

    @Test
    void testSwedishSorting() {

        // Arrange
        Collator swedish = Collator.getInstance(Locale.forLanguageTag("sv-SE"));


        // Act
        int result = swedish.compare("Åbenbaringen", "Ökonomi");


        // Assert
        assertTrue(result < 0);
    }
}
