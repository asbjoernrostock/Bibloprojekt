import java.time.LocalDate;

public class Loan {

    private Resource resources;
    private Member member;
    private LocalDate borrowedDate;

    public Loan(Book book, Member member, LocalDate borrowedDate) {
        this.book = book;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

    public boolean isOverDue() {
        LocalDate today = LocalDate.now();
        return today.isAfter(getDueDate());
    }

    @Override
    public String toString() {
        return book + "\n"
                + member + "\n"
                + "Afleveringsfrist: " + getDueDate();
    }
}
