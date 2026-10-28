import java.time.LocalDate;
import java.util.ArrayList;

public class TestDoubleNegative implements LoanPolicy {

    public boolean canLoanCalled = false;

    @Override
    public boolean canLoan(Member member, Resource resource, ArrayList<Loan> loans) {
        canLoanCalled = true;
        return  false;
    }
    @Override
    public LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }
}
