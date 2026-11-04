import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    void testNaturalSortByMemberId() {
        // Arrange
        Member member1 = new Member("Lone", 888);

        Member member2 = new Member("Finn", 666);

        List<Member> members = new ArrayList<>(List.of(member1, member2));


        // Act
        members.sort(null);

        // Assert
        assertEquals(member2, members.get(0));

        assertEquals(member1, members.get(1));
    }
}
