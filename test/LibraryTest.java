import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    void testGetResource(){
        //Arrange
        Library library = new Library();
        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);
        library.addResource(book1);

        //Act
        Resource result = library.getResource("9783161484100");

        //Assert
        assertEquals(book1, result);

    }
    @Test
    void testGetMember(){

        //Arrange
        Member member = new Member("Finn Mig", 888);
        //Act
        int result = member.medlemsNummer();
        //Assert
        assertEquals(888,result);
    }

    @Test
    void testLoanResourceAlreadyLoaned(){

        //Arrange
        Library library = new Library();
        int memberId = 666;
        String identifier = "9783161484100";

        //Act
        library.loanResource("9783161484100", 888);
        LoanResult result = library.loanResource(identifier, memberId);

        //Assert
        assertEquals(LoanResult.ALREADY_LOANED, result);
    }
}
