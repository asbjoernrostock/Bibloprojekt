import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        return true;
    }

    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }
}
