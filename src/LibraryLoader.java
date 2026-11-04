import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {

    private final Path folder;

    public LibraryLoader(Path folder) {
        this.folder = folder;
    }
    public List<Member> loadMembers()
        throws IOException {

        List<Member> members = new ArrayList<>();
        Path path = folder.resolve("members.csv");

        try (java.io.BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(",", -1);

                String memberIDText = fields[0].replace("\uFEFF", "");
                int memberId = Integer.parseInt(memberIDText);

                String name = fields[1];

                Member member = new Member(name, memberId);
                members.add(member);
            }
        }
        return members;
    }
    public List<Resource> loadBooks()
        throws IOException {

        List<Resource> books = new ArrayList<>();

        Path path = folder.resolve("books.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", -1);

                String identifier = fields[0].replace("\uFEFF", "");
                String title = fields[1].trim();
                String creator = fields[2].trim();
                int pages = Integer.parseInt(fields[3].trim());

               Book book = new Book(identifier, title, creator, pages);

               books.add(book);
            }
        }
        return books;
    }
    public List<Resource> loadMovies()
            throws IOException {

        List<Resource> movies = new ArrayList<>();

        Path path = folder.resolve("movies.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", -1);

                String identifier = fields[0].replace("\uFEFF", "");
                String title = fields[1].trim();
                String studio = fields[2].trim();
                String director = fields[3].trim();
                int duration = Integer.parseInt(fields[4].trim());

                Movie movie = new Movie(identifier, title, studio, director, duration);
                movies.add(movie);
            }
        }
        return movies;
    }
    public List<Resource> loadAudioBooks()
            throws IOException {

        List<Resource> audioBooks = new ArrayList<>();

        Path path = folder.resolve("audiobooks.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", -1);

                String identifier = fields[0].replace("\uFEFF", "");
                String title = fields[1].trim();
                String creator = fields[2].trim();
                int duration = Integer.parseInt(fields[3].trim());

                AudioBook audioBook = new AudioBook(identifier, title, creator, duration);
                audioBooks.add(audioBook);
            }
        }
        return audioBooks;
    }
    public List<Resource> loadVideoGames()
            throws IOException {

        List<Resource> videoGames = new ArrayList<>();

        Path path = folder.resolve("videogames.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", -1);

                String identifier = fields[0].replace("\uFEFF", "");
                String title = fields[1].trim();
                String creator = fields[2].trim();
                String platform = fields[3].trim();

                VideoGame videoGame = new VideoGame(identifier, title, creator, platform);
                videoGames.add(videoGame);
            }
        }
        return videoGames;
    }
    public List<Loan> loadLoans(List<Member> members, List<Resource> resources)
        throws IOException {

        List<Loan> loans = new ArrayList<>();
        Path path = folder.resolve("loans.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] fields = line.split(",", -1);

                if (fields.length < 4 || fields[0].isBlank() || fields[1].isBlank() || fields[2].isBlank()
                        || fields[3].isBlank()) {
                    continue;
                }

                int memberId = Integer.parseInt(fields[0].trim());
                String resourceIdentifier = fields[1];

                LocalDate borrowedDate = LocalDate.parse(fields[2]);
                LocalDate dueDate = LocalDate.parse(fields[3]);

                Member member = findMember(members, memberId);

                Resource resource = findResource(resources, resourceIdentifier);

                if (member != null && resource != null) {
                    Loan loan = new Loan(resource, member, borrowedDate, dueDate);
                    loans.add(loan);
                }
            }
        }
        return loans;

    }
    private Member findMember(List<Member> members, int memberId) {
        for (Member member : members) {
            if (member.medlemsNummer() == memberId) {
                return member;
            }
        }
        return null;
    }
    private Resource findResource(List<Resource> resources, String identifier) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(identifier)) {
                return resource;
            }
        }
        return null;
    }
}
