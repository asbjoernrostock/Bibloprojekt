import java.util.Comparator;

public class LoanBorrowedDateComparator implements Comparator<Loan> {
    @Override
    public int compare(Loan o1, Loan o2) {
        return o1.getBorrowedDate().compareTo(o2.getBorrowedDate());
    }
}
