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
        Member member1 = new Member("Lone Læder", 666);
        Member member2 = new Member("Finn Mig", 888);
        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        library.addMember(member1);
        library.addMember(member2);
        library.loanResource("9783161484100", 888);

        //Act
        LoanResult result = library.loanResource("9783161484100", 666);

        //Assert
        assertEquals(LoanResult.ALREADY_LOANED, result);
    }
}
