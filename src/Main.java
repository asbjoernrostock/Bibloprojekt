void main() {

       Library library = new Library();

        //Opretter bøgerne
        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);
        Book book2 = new Book("9783161484101", "Jeg er dværg", "Lærke L. Hansen", 250);
        Book book3 = new Book("9783161484102", "Det er fugtigt", "Svend Sved", 300);

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