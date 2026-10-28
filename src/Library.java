import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private LoanPolicy loanPolicy;

    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public Library(LoanPolicy loanPolicy) {
        this.loanPolicy = loanPolicy;
    }

    public boolean isAvailable(String identifier) {
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                return false;
            }
        }
        return true;
    }

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
        IO.println("Materialer: ");
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

    public Resource getResource(String identifier) {
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

    public LoanResult loanResource(String identifier, int memberId) {
        Member member = getMember(memberId);

        if (member == null) {
            return LoanResult.MEMBER_NOT_FOUND;
        }
        Resource resource = getResource(identifier);

        if (resource == null) {
            return LoanResult.RESOURCE_NOT_FOUND;
        }

        if (!loanPolicy.canLoan(member, resource, loans)) {
            return LoanResult.NOT_ALLOWED;
        }

        if (!isAvailable(identifier)) {
            return LoanResult.ALREADY_LOANED;
        }

        LocalDate borrowedDate = LocalDate.now();
        LocalDate dueDate = loanPolicy.calculateLocalDueDate(resource, borrowedDate);
        Loan loan = new Loan(resource, member, borrowedDate, dueDate);

        loans.add(loan);

        return LoanResult.SUCCES;
    }

    public boolean returnResource(String identifier, int memberId) {
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);

            boolean correctResource = loan.getResource().getIdentifier().equals(identifier);
            boolean correctMember = loan.getMember().medlemsNummer() == memberId;

            if (correctResource && correctMember) {
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
    //metode til at registrer nye medlemmer i Console, som også tester for om medlemsnummer findes
    public boolean registerMember(String name, int memberId) {
        Member existingMember = getMember(memberId);

        if (existingMember != null) {
            return false;
        }
        Member member = new Member(name, memberId);
        members.add(member);
        return true;
    }

}
