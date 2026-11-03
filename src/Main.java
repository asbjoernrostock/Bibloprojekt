import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

void main() throws IOException {

    // Mappen med bibliotekets CSV-filer
    Path folder = Path.of("C:\\Users\\asse_\\Dokumenter\\bibliotek");

    // Loader
    LibraryLoader loader = new LibraryLoader(folder);

    // Indlæs medlemmer
    List<Member> members = loader.loadMembers();

    // Indlæs alle materialer
    List<Resource> resources = new ArrayList<>();

    resources.addAll(loader.loadMovies());
    resources.addAll(loader.loadAudioBooks());
    resources.addAll(loader.loadBooks());
    resources.addAll(loader.loadVideoGames());

    // Indlæs lån
    List<Loan> loans = loader.loadLoans(members, resources);

    // låne regler
   LoanPolicy loanPolicy = new StandardLoanPolicy();
   LoanPolicy loanPolicy1 = new LoanPolicyAalborg();
   LoanPolicy loanPolicy2 = new LoanPolicyBornholm();

   //Saml biblioteket
   Library library = new Library(loanPolicy, resources, members, loans);

        //ConsoleUI
        ConsoleUI consoleUI = new ConsoleUI(library);

        consoleUI.run();

    // Gemmer ændringer ved afslutning
    LibrarySaver saver = new LibrarySaver(folder);
    saver.saveLibrary(library);
}