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
    void testMemberNotFound(){ //Fixed "MEMBER_NOT_FOUND"
        //Arrange
        Library library = new Library();
        Member member = new Member("Finn Mig", 888);
        library.addMember(member);
        //Act
        LoanResult result = library.loanResource("97783161484100",999);
        //Assert
        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
    }
    @Test
    void testRegisterMemberSuccess() {
        // Arrange
        Library library = new Library();

        // Act
        boolean result = library.registerMember("Finn Mig", 888);

        // Assert
        assertTrue(result);
        assertNotNull(library.getMember(888));
    }
    @Test
    void testRegisterMemberAlreadyExists() {
        // Arrange
        Library library = new Library();
        library.registerMember("Finn Mig", 888);

        // Act
        boolean result = library.registerMember("Lone Læder", 888);

        // Assert
        assertFalse(result);
        assertEquals(1, library.getMembers().size());
    }
}
