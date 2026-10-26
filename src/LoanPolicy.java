import java.time.LocalDate;
import java.util.ArrayList;

public interface LoanPolicy {
    boolean canLoan(Member member, Resource resource, ArrayList<Loan> loans);
    LocalDate calculateLocalDueDate(Resource resource, LocalDate borrowedDate);
}
