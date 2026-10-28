import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanPolicyBornholm implements LoanPolicy {
    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        return true;
    }

    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        if (!(resource instanceof AudioBook)) {
            return borrowedDate.plusDays(30);
        } else {
            return borrowedDate.plusDays(14);
        }
    }
}
