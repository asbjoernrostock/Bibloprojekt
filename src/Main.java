void main() {

       Library library = new Library();

        //Opretter bøgerne
        Book book1 = new Book(
                "Allan B. Downey",
                "Think Java",
                "989796",
                1
        );
        Book book2 = new Book(
                "Lærke L. Hansen",
                "Jeg er en dværg",
                "666999",
                2
        );
        Book book3 = new Book(
                "Svend Sved",
                "Det er fugtigt",
                "999666",
                3
        );

        //Opretter medlemmerne
        Member member1 = new Member("Lone Læder", 666);
        Member member2 = new Member("Vibe Fugl", 999);
        Member member3 = new Member("Finn Mig", 888);

        //Tilføjer members til array
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        //Tilføjer bøgerne til array
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        //ConsoleUI
        ConsoleUI consoleUI = new ConsoleUI(library);

        consoleUI.run();
}