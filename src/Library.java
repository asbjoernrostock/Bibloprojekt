import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void printResources() {
        IO.println("Materialer:");
        for (Resource resource : resources) {
            IO.println(resource);
            IO.println();

        }
    }

    public void printMembers() {
        IO.println("\u001B[34mMedlemmer:\u001B[0m");
        for (Member member : members) {
            IO.println(member);
        }
    }

    public Resource getResource(int identifier) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(identifier)) {
                return resource;
            }
        }
        return null;
    }

    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.medlemsNummer() == memberId) {
                return member;
            }
        }
        return null;
    }

    public boolean loanBook(int bookId, int memberId) {
        Book book = getBook(bookId);
        Member member = getMember(memberId);

        if (book == null || member == null) {
            return false;
        }
        for (Loan loan : loans) {
            if (loan.getBook().id() == bookId) {
                return false;
            }
        }
        Loan loan = new Loan(book, member, LocalDate.now());

        loans.add(loan);

        return true;
    }

    public boolean returnBook(int bookId) {
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);

            if (loan.getBook().id() == bookId) {
                loans.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> foundLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getMember().medlemsNummer() == memberId) {
                foundLoans.add(loan);
            }
        }
        return foundLoans;
    }

}
