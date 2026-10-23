import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    void testGetResource(){
        //Arrange
        Resource resource = new Resource("9783161484100", "Think Java", "Allan B. Downey");

        //Act
        String result = resource.getIdentifier();

        //Assert
        assertEquals("9783161484100", result);

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
