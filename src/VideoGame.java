public class VideoGame extends Resource {
    private String platform;

    //constructor
    public VideoGame(String ean, String title, String studio, String platform) {
        super(ean, title, studio); //Sender til resources, ean = identifier osv..
        this.platform = platform;
    }
    public String getPlatform() {
        return platform;
    }
}
