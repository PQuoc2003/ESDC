import java.util.ArrayList;
import java.io.Serializable;

public class BookShelf implements Serializable {

    private ArrayList<Book> books;

    public BookShelf() {
        this.books = new ArrayList<Book>();
    }

    public BookShelf(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Book getBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id))
                return book;
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Book borrowById(String id) {
        for (Book book : this.books) {
            if (book.getId().equals(id)) {

                book.setAvailable(false);
                return book;
            }
        }
        return null;
    }

    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {

                book.setAvailable(true);
                return;
            }
        }
        System.out.println("Library doesn't have this book");
        ;
    }

    public void searchByQuery(String query) {

        ArrayList<Book> result = new ArrayList<Book>();

        for (Book book : this.books) {
            String reference = book.getAuthor() + book.getName() + book.getYear();
            if (reference.contains(query) && book.isAvailable()) {
                result.add(book);
            }
        }

        int length = result.size();

        if (length > 10) {
            System.out.println("Display top 10 results: \n");
            length = 10;
        } else {
            System.out.println("Found " + length + " results: \n");
        }

        for (int i = 0; i < length; i++) {
            System.out.println(result.get(i));
        }

    }

}
