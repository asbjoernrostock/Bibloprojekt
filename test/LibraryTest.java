import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        Library library = new Library();
        Member member = new Member("Finn Mig", 888);
        library.addMember(member);

        //Act
        Member result = library.getMember(888);

        //Assert
        assertEquals(member,result);
    }

    @Test
    void testGetUnknownMemberReturnsNull() {
        //Arrange
        Library library = new Library();

        //Act
        Member result = library.getMember(999);

        //Assert
        assertNull(result);
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
        library.addResource(book1);

        library.loanResource("9783161484100", 888);

        //Act
        LoanResult result = library.loanResource("9783161484100", 666);

        //Assert
        assertEquals(LoanResult.ALREADY_LOANED, result);
    }
    @Test
    void testLoanWithUnknownResource() {
        //Arrange
        Library library = new Library();
        Member member = new Member("Lone Læder", 666);
        library.addMember(member);

        //Act
        LoanResult result = library.loanResource("FINDES-IKKE", 666);

        //Assert
        assertEquals(LoanResult.RESOURCE_NOT_FOUND, result);
    }
    @Test
    void testLoanWithUnknownMember() {
        //Arrange
        Library library = new Library();
        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        library.addResource(book1);

        //Act
        LoanResult result = library.loanResource("9783161484100", 999);

        //Assert
        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
    }
    @Test
    void testResourceCanBeLoanedAgainAfterReturn() {
        //Arrange
        Library library = new Library();
        Member member = new Member("Lone Læder", 666);
        Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        library.addMember(member);
        library.addResource(book);

        library.loanResource("9783161484100", 666);
        library.returnResource("9783161484100", 666);

        //Act
        LoanResult result = library.loanResource("9783161484100", 666);

        //Assert
        assertEquals(LoanResult.SUCCES, result);
    }
    @Test
    void testReturnActiveLoan() {
        //Arrange
        Library library = new Library();
        Member member = new Member("Lone Læder", 666);
        Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        library.addMember(member);
        library.addResource(book);
        library.loanResource("9783161484100", 666);

        //Act
        boolean result = library.returnResource("9783161484100", 666);

        //Assert
        assertTrue(result);
    }
    @Test
    void testReturnWithWrongMemberFails() {
        //Arrange
        Library library = new Library();
        Member member1 = new Member("Lone Læder", 666);
        Member member2 = new Member("Finn Mig", 888);
        Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        library.addMember(member1);
        library.addMember(member2);
        library.addResource(book);

        library.loanResource("9783161484100", 666);

        //Act
        boolean result = library.returnResource("9783161484100", 888);

        //Assert
        assertFalse(result);
    }
    @Test
    void testFailedReturnDoesNotChangeLibrary() {
        //Arrange
        Library library = new Library();
        Member member1 = new Member("Lone Læder", 666);
        Member member2 = new Member("Finn Mig", 888);
        Book book = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);

        library.addMember(member1);
        library.addMember(member2);
        library.addResource(book);

        library.loanResource("9783161484100", 666);

        //Act
        library.returnResource("9783161484100", 888);
        ArrayList<Loan> loans = library.findLoansByMemberId(666);

        //Assert
        assertFalse(loans.isEmpty());

    }
}
