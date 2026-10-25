import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {
    @Test
    void testConstructorAndGetters() {
        //Arrange

        Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);
        Member member = new Member("Lone Læder", 666);
        LocalDate borrowedDate = LocalDate.of(2025, 10, 1);

        //Act
        Loan loan = new Loan(book, member, borrowedDate);

        //Assert
        assertSame(book, loan.getResource());
        assertSame(member, loan.getMember());

    }

    @Test
    void testGetDueDate() {
        //Arrange
        Book book = new Book("9783161484101", "Jeg er dværg", "Lærke L. Hansen", 250);
        Member member = new Member("Vibe Fugl", 999);
        LocalDate borrowedDate = LocalDate.of(2025, 10, 1);

        Loan loan = new Loan(book, member, borrowedDate);


        LocalDate dueDate = loan.getDueDate();

        assertEquals(borrowedDate.plusDays(14), dueDate);

    }

    @Test
    void testIsOverDueFalse() {
        // Arrange – lån for 5 dage siden
        Book book = new Book("9783161484102", "Det er fugtigt", "Svend Sved", 300);
        Member member = new Member("Finn Mig", 888);
        LocalDate borrowedDate = LocalDate.now().minusDays(5);

        Loan loan = new Loan(book, member, borrowedDate);

        //Act and Assert
        assertFalse(loan.isOverDue());

    }

    @Test
    void testIsOverDueTrue() {
        // Arrange – lån for 20 dage siden
        AudioBook audioBook = new AudioBook("9783161484103", "Harry Potter", "J. K. Rowling", 70);
        Member member = new Member("Lone Læder", 666);
        LocalDate borrowedDate = LocalDate.now().minusDays(20);


        Loan loan = new Loan(audioBook, member, borrowedDate);

        //Act and Assert
        assertTrue(loan.isOverDue());

    }

    @Test
    void testToStringContainsExpectedInfo() {
        //Arrange
        Movie movie = new Movie("5701234567890", "Spider Man", "Marvel", "Ken Læder", 80);
        Member member = new Member("Vibe Fugl", 999);
        LocalDate borrowedDate = LocalDate.of(2025, 10, 1);

        Loan loan = new Loan(movie, member, borrowedDate);

        //Act
        String result = loan.toString();

        //Assert
        assertTrue(result.contains(movie.toString()));
        assertTrue(result.contains(member.toString()));
        assertTrue(result.contains("Afleveringsfrist: " + loan.getDueDate()));

    }
    @Test
    void testBorrowedDate() {
        //Arrange
        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);
        Member member1 = new Member("Lone Læder", 666);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 25);

        Loan loan = new Loan(book1, member1, borrowedDate);

        //Act
        LocalDate result = loan.getBorrowedDate();

        //Assert
        assertEquals(borrowedDate, result);
    }

}
