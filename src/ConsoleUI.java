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
            int choice = Integer.parseInt(IO.readln("Indtast: "));
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg");
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

    private void borrowBook() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        int bookId = Integer.parseInt(IO.readln("Indtast bog id: "));

        boolean succes = library.loanBook(bookId, memberId);
            if (succes) {
                IO.println("Lån registreret");
            } else {
                IO.println("Der er sket en fejl");
            }

    }

    private void returnBook() {
        int bookId = Integer.parseInt(IO.readln("Indtast bog id: "));

        boolean succes = library.returnBook(bookId);
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
