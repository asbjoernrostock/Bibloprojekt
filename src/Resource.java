public class Resource {

    private String identifier;
    private String title;
    private String creator;

    //constructor
    public Resource(String identifier, String title, String creator) {
        this.identifier = identifier;
        this.title = title;
        this.creator = creator;
    }

    //Getters
    public String getIdentifier() {
        return identifier;
    }
    public String getTitle() {
        return title;
    }
    public String getCreator() {
        return creator;
    }
    @Override
    public String toString() {
        return creator + "\n" + title + "\n" + "identifier: " + identifier;
    }

}
