import java.util.ArrayList;
import java.util.List;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            try {
                int choice = Integer.parseInt(IO.readln("Indtast: "));
                switch (choice) {
                    case 1 -> borrowResource();
                    case 2 -> returnResource();
                    case 3 -> showLoans();
                    case 4 -> registerMember();
                    case 5 -> showResourcesByIdentifier();
                    case 6 -> showResourcesByCreator();
                    case 7 -> showResourcesByTitle();
                    case 8 -> showLoansByDueDate();
                    case 9 -> showLoansByBorrowedDate();
                    case 0 -> running = false;
                    default -> IO.println("Ugyldigt valg");
                }
            } catch (NumberFormatException exception) {
                IO.println("Ugyldigt input - skriv et tal.");
            }
        }
    }

    public void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis låneres lån");
        IO.println("4. Registrer ny låner");
        IO.println("5. Vis materialer efter identifier");
        IO.println("6. Vis materialer efter creator");
        IO.println("7. Vis materialer efter titel");
        IO.println("8. Vis lån efter afleveringsfrist");
        IO.println("9. Vis lån efter lånedato");
        IO.println("0. Afslut");
        IO.println();
    }

    private void borrowResource() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        String identifier = IO.readln("Indtast materiale identifier: ");

        LoanResult result = library.loanResource(identifier, memberId);
            switch (result) {

                case SUCCES:
                IO.println("Lån registreret");
                break;

                case MEMBER_NOT_FOUND:
                IO.println("Medlemmet er ikke registreret");
                break;

                case RESOURCE_NOT_FOUND:
                    IO.println("Materialet er ikke registreret");
                    break;

                case ALREADY_LOANED:
                    IO.println("Materialet er allerede udlånt");
                    break;

                case NOT_ALLOWED:
                    IO.println("Lånet er ikke tilladt");
                    break;
            }

    }

    private void returnResource() {
        String identifier = IO.readln("Indtast materiale identifier: ");
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer"));

        boolean succes = library.returnResource(identifier, memberId);
            if (succes) {
                IO.println("Aflevering registreret");
            } else {
                IO.println("Der findes ikke et aktivt lån " + "for dette materiale og medlem");
            }
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        List<Loan> loans = library.findLoansByMemberId(memberId);
            if (loans.isEmpty()) {
                IO.println("Ingen udlån");
            } else {
                for (Loan loan : loans) {
                    IO.println(loan);
                    IO.println();
                }
            }
    }
    //Metoden til at registrere nye medlemmer
    private void registerMember() {
        String name = IO.readln("Indtast navn: ");
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        boolean succes = library.registerMember(name, memberId);

        if (succes) {
            IO.println("Låner registreret");
        } else {
            IO.println("Der findes allerede en låner med dette medlemsnummer");
        }
    }
    private void showResourcesByIdentifier() {
        List<Resource> resources = library.getResourcesSortedByIdentifier();

        for (Resource resource : resources) {
            IO.println(resource);
            IO.println();
        }
    }
    private void showResourcesByCreator() {
        List<Resource> resources = library.getResourcesSortedByCreator();

        for (Resource resource : resources) {
            IO.println(resource);
            IO.println();
        }
    }
    private void showResourcesByTitle() {
        List<Resource> resources = library.getResourcesSortedByTitle();

        for (Resource resource : resources) {
            IO.println(resource);
            IO.println();
        }
    }
    private void showLoansByDueDate() {
        List<Loan> loans = library.getLoansSortedByDueDate();

        for (Loan loan : loans) {
            IO.println(loan);
            IO.println();
        }
    }
    private void showLoansByBorrowedDate() {
        List<Loan> loans = library.getLoansSortedByBorrowedDate();

        for (Loan loan : loans) {
            IO.println(loan);
            IO.println();
        }
    }
}
