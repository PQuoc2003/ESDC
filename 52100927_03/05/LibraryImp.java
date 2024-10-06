import java.rmi.RemoteException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class LibraryImp implements Library {

    @Override
    public Book checkout(String id) throws RemoteException {

        BookShelf bookShelf = null;

        // load data from database
        try {
            FileInputStream f = new FileInputStream("bookshelf.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            bookShelf = (BookShelf) in.readObject();
            in.close();
            f.close();

        } catch (Exception e) {
        }

        if (bookShelf == null) {
            System.out.println("Can't load database");
            return null;
        }

        // checkout book

        Book result = bookShelf.borrowById(id);

        System.out.println("You have successfully checkout this book");

        System.out.println(result);

        // save new status to database
        try {
            FileOutputStream f = new FileOutputStream("bookshelf.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(f);

            out.writeObject(bookShelf);

            out.close();
            f.close();
        } catch (Exception e) {
        }

        return result;

    }

    @Override
    public void returnBook(String id) throws RemoteException {

        BookShelf bookShelf = null;

        // load data from database
        try {
            FileInputStream f = new FileInputStream("bookshelf.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            bookShelf = (BookShelf) in.readObject();
            in.close();
            f.close();

        } catch (Exception e) {
        }

        if (bookShelf == null) {
            System.out.println("Can't load database");
        }

        // return book

        bookShelf.returnBook(id);


        System.out.println("You have successfully return this book");

        System.out.println(bookShelf.getBookById(id));


        // save new status to database
        try {
            FileOutputStream f = new FileOutputStream("bookshelf.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(f);

            out.writeObject(bookShelf);

            out.close();
            f.close();
        } catch (Exception e) {
        }

    }

    @Override
    public void search(String query) throws RemoteException {

        BookShelf bookShelf = null;


        try {
            FileInputStream f = new FileInputStream("bookshelf.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            bookShelf = (BookShelf) in.readObject();
            in.close();
            f.close();

        } catch (Exception e) {
            System.out.println("Error when load database");
        }

        if (bookShelf == null)
            System.out.println("Can't load database");

        bookShelf.searchByQuery(query);

    }

}
