void main() {

       Library library = new Library();

        //Opretter bøgerne
        Book book1 = new Book("9783161484100", "Think Java", "Allan B. Downey", 400);
        Book book2 = new Book("9783161484101", "Jeg er dværg", "Lærke L. Hansen", 250);
        Book book3 = new Book("9783161484102", "Det er fugtigt", "Svend Sved", 300);

        //opretter audiobooks
        AudioBook audioBook1 = new AudioBook("9783161484103", "Harry Potter", "J. K. Rowling", 70);

        //opretter Film
        Movie movie1 = new Movie("5701234567890", "Spider Man", "Marvel", "Ken Læder", 80);

        //opretter Spil
        VideoGame videoGame1 = new VideoGame("5701234567891", "World of Warcraft", "Blizzard", "PC");

        //Opretter medlemmerne
        Member member1 = new Member("Lone Læder", 666);
        Member member2 = new Member("Vibe Fugl", 999);
        Member member3 = new Member("Finn Mig", 888);

        //Tilføjer members til array
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        //Tilføjer bøgerne til array
        library.addResource(book1);
        library.addResource(book2);
        library.addResource(book3);
 library.addResource(audioBook1);
 library.addResource(videoGame1);
 library.addResource(movie1);

        //ConsoleUI
        ConsoleUI consoleUI = new ConsoleUI(library);

        consoleUI.run();
}