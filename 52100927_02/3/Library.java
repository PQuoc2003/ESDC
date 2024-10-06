import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable{
    private List<Book> books;

    

    public Library(){
        this.books = new ArrayList<Book>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public Book getBook(int index){
        return this.books.get(index);
    }

    @Override
    public String toString() {
        return "Library [books=" + books + "]";
    }


}
