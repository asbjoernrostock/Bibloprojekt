import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanPolicyBornholmTest {
    @Test
    void testAudioBookDueDateIs14Days() {
        //Arrange
        LoanPolicyBornholm policy = new LoanPolicyBornholm();
        AudioBook audioBook1 = new AudioBook("9783161484103", "Harry Potter", "J. K. Rowling", 70);

        LocalDate borrowedDate = LocalDate.of(2026, 10, 1);

        //Act
        LocalDate result = policy.calculateLocalDueDate(audioBook1, borrowedDate);

        //Assert
        assertEquals(borrowedDate.plusDays(14), result);
    }
    @Test
    void testBookDueDateIs30Days() {
        //Arrange
        LoanPolicyBornholm policy = new LoanPolicyBornholm();
        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        LocalDate borrowedDate = LocalDate.of(2026, 10, 1);

        //Act
        LocalDate result = policy.calculateLocalDueDate(book1, borrowedDate);

        //Assert
        assertEquals(borrowedDate.plusDays(30), result);
    }
}
