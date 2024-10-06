import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();

        for (int i = 0; i < 5; i++) {
            Book book = new Book("book" + i, "Quoc", 2019);
            library.addBook(book);
        }

        System.out.println(library);


        try {

            FileOutputStream f = new FileOutputStream("library.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(library);
            o.close();
            f.close();
            
        } catch (Exception e) {
            System.out.println("error");
        }


    }
}
