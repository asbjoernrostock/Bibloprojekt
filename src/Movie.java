public class Movie extends Resource {
    private String director;
    private int duration;

    //constructor
    public Movie(String ean, String title, String studio, String director, int duration) {
        super(ean, title, studio); //Sender til Resources, ean = identifier osv.
        this.director = director;
        this.duration = duration;
    }
}
