import java.io.Serializable;

public class Book implements Serializable {


    private String id;
    private String name;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book() {
    }

    
    public Book(String id, String name, String author, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }

    


    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", year=" + year + ", isAvailable="
                + isAvailable + "]";
    }


    public boolean isAvailable() {
        return isAvailable;
    }


    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    
    
    
}
