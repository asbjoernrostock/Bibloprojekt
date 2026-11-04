import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoanBorrowedDateComparatorTest {

    @Test
    void testSortByBorrowedDate() {

        // Arrange
        Member member = new Member("Lone Læder", 666);

        Book book = new Book("1", "Think Java", "Allan B. Downey", 400);


        Loan lateLoan = new Loan(book, member,
                        LocalDate.of(2026, 11, 20),
                        LocalDate.of(2026, 12, 20));


        Loan earlyLoan = new Loan(book, member,
                        LocalDate.of(2026, 11, 5),
                        LocalDate.of(2026, 12, 5));


        List<Loan> loans = new ArrayList<>(List.of(lateLoan, earlyLoan));


        // Act
        loans.sort(new LoanBorrowedDateComparator());


        // Assert
        assertEquals(earlyLoan, loans.get(0));
        assertEquals(lateLoan, loans.get(1));
    }
}
