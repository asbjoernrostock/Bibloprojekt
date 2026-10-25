import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    void testMemberName() {
        //Arrange
        Member member = new Member("Finn Mig", 888);

        //Act
        String result = member.navn();

        //Assert
        assertEquals("Finn Mig", result);
    }
    @Test
    void testMemberId() {
        //Arrange
        Member member = new Member("Finn Mig", 888);

        //Act
        int result = member.medlemsNummer();

        //Assert
        assertEquals(888, result);
    }
}
