import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDoublePositive implements LoanPolicy {
    public boolean canLoanCalled = false;
    public boolean calculateDueDateCalled = false;

    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        canLoanCalled = true;
        return true;
    }
    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        calculateDueDateCalled = true;
        return borrowedDate.plusDays(30);
    }
}
