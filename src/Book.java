public class Book extends Resource {

    private int pages;

    //constructor
    public Book(String isbn, String title, String author, int pages) {
        super(isbn, title, author); //sender til Resources (isbn = identifier osv.
        this.pages = pages; //da pages kun findes i bog klassen
    }
    //Getter
    public int getPages() {
        return pages;
    }
}

