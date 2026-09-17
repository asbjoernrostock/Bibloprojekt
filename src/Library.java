import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void printBooks() {
        IO.println("\u001B[34mBøger:\u001B[0m");
        for (Book book : books) {
            IO.println(book);
            IO.println();

        }
    }

    public void printMembers() {
        IO.println("\u001B[34mMedlemmer:\u001B[0m");
        for (Member member : members) {
            IO.println(member);
        }
    }

    public Book getBook(int bookid) {
        for (Book book : books) {
            if (book.getId() == bookid) {
                return book;
            }
        }
        return null;
    }

    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.getMedlemsNummer() == memberId) {
                return member;
            }
        }
        return null;
    }

    public boolean loanBook(int bookId, int memberId) {
        Book book = getBook(bookId);
        Member member = getMember(memberId);

        if (book == null || member == null) {
            return false;
        }
        for (Loan loan : loans) {
            if (loan.getBook().getId() == bookId) {
                return false;
            }
        }
        Loan loan = new Loan(book, member, LocalDate.now());

        loans.add(loan);

        return true;
    }

    public boolean returnBook(int bookId) {
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);

            if (loan.getBook().getId() == bookId) {
                loans.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> foundLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getMember().getMedlemsNummer() == memberId) {
                foundLoans.add(loan);
            }
        }
        return foundLoans;
    }

}
