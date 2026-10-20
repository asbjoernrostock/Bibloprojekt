import java.util.ArrayList;

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
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }

    private void borrowResource() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        int bookId = Integer.parseInt(IO.readln("Indtast materiale identifier: "));

        boolean succes = library.loanResource(identifier, memberId);
            if (succes) {
                IO.println("Lån registreret");
            } else {
                IO.println("Der er sket en fejl");
            }

    }

    private void returnResource() {
        int bookId = Integer.parseInt(IO.readln("Indtast materiale identifier: "));

        boolean succes = library.returnResource(identifier);
            if (succes) {
                IO.println("Aflevering registreret");
            } else {
                IO.println("Der er sket en fejl");
            }
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        ArrayList<Loan> loans = library.findLoansByMemberId(memberId);
            if (loans.isEmpty()) {
                IO.println("Ingen udlån");
            } else {
                for (Loan loan : loans) {
                    IO.println(loan);
                    IO.println();
                }
            }
    }

}
