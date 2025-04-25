import javafx.application.Application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//public class DatabaseManager {
//    private List<Book> books = new ArrayList<>();
//    private List<Member> members = new ArrayList<>();
//    private List<Loan> loans = new ArrayList<>();
//
//    public void addBook(Book book) {
//        books.add(book);
//    }
//
//    public void addMember(Member member) {
//        members.add(member);
//    }
//
//    public void loanBook(Book book, Member member) {
//        loans.add(new Loan(book, member, LocalDate.now(), null));
//    }
//
//    public List<Book> searchBooks(String query) {
//        return books.stream()
//                .filter(b -> b.getTitle().contains(query) || b.getAuthor().contains(query))
//                .collect(Collectors.toList());
//    }
//
//    public List<Loan> getLoans() {
//        return loans;
//    }
//
//    // New method to get members
//    public List<Member> getMembers() {
//        return members;
//    }
//}

public class DatabaseManager {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public DatabaseManager() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public List<Book> searchBooks(String query) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

}
