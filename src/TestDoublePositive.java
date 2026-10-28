import java.time.LocalDate;
import java.util.ArrayList;

public class TestDoublePositive implements LoanPolicy {
    public boolean canLoanCalled = false;
    public boolean calculateDueDateCalled = false;

    @Override
    public boolean canLoan(Member member, Resource resource, ArrayList<Loan> loans) {
        canLoanCalled = true;
        return true;
    }
    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        calculateDueDateCalled = true;
        return borrowedDate.plusDays(30);
    }
}
