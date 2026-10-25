import java.time.LocalDate;

public class Loan {

    private Resource resource;
    private Member member;
    private LocalDate borrowedDate;

    public Loan(Resource resource, Member member, LocalDate borrowedDate) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public Resource getResource() {
        return resource;
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
    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    @Override
    public String toString() {
        return resource + "\n"
                + member + "\n"
                + "Afleveringsfrist: " + getDueDate();
    }
}
