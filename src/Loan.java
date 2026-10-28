import java.time.LocalDate;

public class Loan {

    private Resource resource;
    private Member member;
    private LocalDate borrowedDate;
    private LocalDate dueDate;

    public Loan(Resource resource, Member member, LocalDate borrowedDate) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverDue() {
        return LocalDate.now().isAfter(dueDate);
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
