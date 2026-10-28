import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface LoanPolicy {
    boolean canLoan(Member member, Resource resource, List<Loan> loans);
    LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate);
}
