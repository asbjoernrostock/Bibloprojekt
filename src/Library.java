import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public boolean isAvailable(String identifier) {
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)); {
                return true;
            }
        }
        return false;
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
        Resource resource = getResource(identifier);

        if (member != null && resource != null) {
            if (isAvailable(identifier)) {
                Loan loan = new Loan(resource, member, LocalDate.now());
                loans.add(loan);
                return LoanResult.SUCCES;
        } else {
                return LoanResult.ALREADY_LOANED;
            }
        }
        return LoanResult.RESOURCE_NOT_FOUND;
    }

    public boolean returnResource(String identifier) {
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);

            if (loan.getResource().getIdentifier().equals(identifier)) {
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
