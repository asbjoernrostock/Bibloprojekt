public record Book(
    String forfatter,
    String titel,
    String isbn,
    int id
) {

    @Override
    public String toString() {
        return forfatter + "\n" + titel + "\n" + "ISBN: " + isbn + "\n" + "ID: " + id;
    }

}

