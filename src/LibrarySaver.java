import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LibrarySaver {

    private final Path folder;

    public LibrarySaver(Path folder) {
        this.folder = folder;
    }
    public void saveMembers(List<Member> members)
        throws IOException {
        Path path = folder.resolve("members.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                String line = member.medlemsNummer() + "," + member.navn();

                writer.write(line);
                writer.newLine();
            }
        }
    }
    public void saveBooks(List<Resource> resources)
        throws IOException {
        Path path = folder.resolve("books.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof Book book) {
                    String line = book.getIdentifier() + "," + book.getTitle() + "," + book.getCreator()
                            + "," + book.getPages();

                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }
    public void saveMovies(List<Resource> resources)
            throws IOException {
        Path path = folder.resolve("movies.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof Movie movie) {
                    writer.write(movie.getIdentifier() + "," + movie.getTitle() + "," + movie.getCreator()
                            + "," + movie.getDirector() + "," + movie.getDuration());

                    writer.newLine();
                }
            }
        }
    }
    public void saveAudioBooks(List<Resource> resources)
            throws IOException {
        Path path = folder.resolve("audiobooks.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof AudioBook audioBook) {
                    writer.write(audioBook.getIdentifier() + "," + audioBook.getTitle() + ","
                            + audioBook.getCreator() + "," + audioBook.getDuration());

                    writer.newLine();
                }
            }
        }
    }
    public void saveVideoGames(List<Resource> resources)
            throws IOException {
        Path path = folder.resolve("videogames.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof VideoGame videoGame) {
                    writer.write(videoGame.getIdentifier() + "," + videoGame.getTitle() + ","
                            + videoGame.getCreator() + "," + videoGame.getPlatform());

                    writer.newLine();
                }
            }
        }
    }
    public void saveLoans(List<Loan> loans)
        throws IOException {
        Path path = folder.resolve("loans.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                writer.write(loan.getMember().medlemsNummer() + "," + loan.getResource().getIdentifier()
                + "," + loan.getBorrowedDate() + "," + loan.getDueDate());

                writer.newLine();
            }
        }
    }
    public void saveLibrary(Library library)
        throws IOException {

        Files.createDirectories(folder);

        saveMembers(library.getMembers());
        saveBooks(library.getResources());
        saveMovies(library.getResources());
        saveAudioBooks(library.getResources());
        saveVideoGames(library.getResources());
        saveLoans(library.getLoans());
    }
}
