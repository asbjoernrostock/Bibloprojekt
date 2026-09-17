public class Book {
    private final String forfatter;
    private final String titel;
    private final String isbn;
    private final int id;

    public Book(String forfatter, String titel, String isbn, int id) {
        this.forfatter = forfatter;
        this.titel = titel;
        this.isbn = isbn;
        this.id = id;

    }

    public String toString() {
        return String.format(
                "\u001B[31mForfatter:\u001B[0m %s\n" +
                        "\u001B[31mTitel:\u001B[0m %s\n" +
                        "\u001B[31mISBN:\u001B[0m %s\n" +
                        "\u001B[31mID:\u001B[0m (%d)",
                forfatter,
                titel,
                isbn,
                id
        );
    }

    public int getId() {
        return id;
    }

}

