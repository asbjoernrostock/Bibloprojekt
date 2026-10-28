//public class LoanPolicyAalborg implements LoanPolicy {

//}
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanPolicyAalborg implements LoanPolicy {

    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        if (!(resource instanceof Movie) && !(resource instanceof VideoGame)) {
            return true;
        }
        int count = 0;
        for (Loan loan : loans) {
            boolean sameMember = loan.getMember().equals(member);
            boolean movieOrGame = loan.getResource() instanceof Movie ||
                                    loan.getResource() instanceof VideoGame;

            if (sameMember && movieOrGame) {
                count++;
            }
        }
        return count < 3;
    }

    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }
}
