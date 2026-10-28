import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LoanPolicyAalborgTest {
    @Test
    void testCanLoanMovieWhenMemberHasLessThenThree() {
        //Arrange
        LoanPolicyAalborg policy = new LoanPolicyAalborg();
        Member member = new Member("Finn Mig", 888);
        Movie movie = new Movie("5701234567890", "Spider Man", "Marvel", "Ken Læder", 80);
        ArrayList<Loan> loans = new ArrayList<>();

        //Act
        boolean result = policy.canLoan(member, movie, loans);

        //Assert
        assertTrue(result);
    }
    @Test
    void testCannotLoanFourthMovieOrGame() {
        //Arrange
        LoanPolicyAalborg policy = new LoanPolicyAalborg();
        Member member = new Member("Finn Mig", 888);

        LocalDate borrowed = LocalDate.of(2026, 10, 1);
        LocalDate due = borrowed.plusDays(30);

        Movie movie1 = new Movie("5701234567890", "Spider Man", "Marvel", "Ken Læder", 80);
        Movie movie2 = new Movie("5701234567891", "Thor", "Marvel", "Lise Lotte", 90);
        VideoGame videoGame1 = new VideoGame("5701234567893", "World of Warcraft", "Blizzard", "PC");
        VideoGame videoGame2 = new VideoGame("5701234567894", "MineCraft", "Microsoft", "PC");

        ArrayList<Loan> loans = new ArrayList<>();

        loans.add(new Loan(movie1, member, borrowed, due));
        loans.add(new Loan(movie2, member, borrowed, due));
        loans.add(new Loan(videoGame1, member, borrowed, due));

        //Act
        boolean result = policy.canLoan(member, videoGame2, loans);

        //Assert
        assertFalse(result);
    }
}
