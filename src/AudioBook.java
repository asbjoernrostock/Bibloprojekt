public class AudioBook extends Resource {
    private int duration;

    //constructor
    public AudioBook(String isbn, String title, String author, int duration) {
        super(isbn, title, author); //sender til Resource, isbn = identifier osv..
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }
}
