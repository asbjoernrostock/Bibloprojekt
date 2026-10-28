import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDoubleNegative implements LoanPolicy {

    public boolean canLoanCalled = false;

    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        canLoanCalled = true;
        return  false;
    }
    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }
}
