import java.io.Serializable;

public class Book implements Serializable{

    private String title;
    private String author;
    private int publication_year;



    
    public Book(String title, String author, int publication_year) {
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
    }


    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPublication_year() {
        return publication_year;
    }
    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }


    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publication_year=" + publication_year + "]";
    }


    

    



}