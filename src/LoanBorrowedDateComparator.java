import java.util.Comparator;

public class LoanBorrowedDateComparator implements Comparator<Loan> {

    @Override
    public int compare(Loan loan1, Loan loan2) {
        return loan1.getBorrowedDate().compareTo(loan2.getBorrowedDate());
    }
}
