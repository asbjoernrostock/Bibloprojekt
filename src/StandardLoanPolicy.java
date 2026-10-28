import java.time.LocalDate;
import java.util.ArrayList;

public class StandardLoanPolicy implements LoanPolicy {
    @Override
    public boolean canLoan(Member member, Resource resource, ArrayList<Loan> loans) {
        return true;
    }
    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }
}
