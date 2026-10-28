import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StandardLoanPolicyTest {

    @Test
    void testCanLoanAlwaysReturnsTrue() {
        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        Member member = new Member("Charles Manson", 333);
        Book book = new Book("32759823", "The bible", "God", 400);
        ArrayList<Loan> loans = new ArrayList<>();

        //Act
        boolean result = policy.canLoan(member, book, loans);

        //Assert
        assertTrue(result);
    }

    @Test
    void testCalculateLocalDueDateIs30Days() {

        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        Book book = new Book("32759823", "The bible", "God" ,400);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 1);

        //Act
        LocalDate dueDate = policy.calculateLocalDueDate(book, borrowedDate);

        //Assert
        assertEquals(borrowedDate.plusDays(30), dueDate);

    }


}
