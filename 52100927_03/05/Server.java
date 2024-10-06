import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Server extends LibraryImp {

    public Server(){}

    public static void main(String[] args) {


        // Create list of books

        BookShelf bookShelf = new BookShelf();

        for (int i = 0; i < 20; i++) {

            Book book = new Book(String.valueOf(i), "book_" + i, "author_" + i, 2000+i);

            bookShelf.addBook(book);
            
        }


        try {
            FileOutputStream f = new FileOutputStream("bookshelf.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(f);
            
            out.writeObject(bookShelf);
            
            out.close();
            f.close();
        } catch (Exception e) {
        }


        try {

            int index = 0;
            int port = Integer.parseInt(args[index++]);


            LibraryImp libraryImp = new LibraryImp();


            Library skeleton = (Library) UnicastRemoteObject.exportObject(libraryImp, 0);
            
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("Library", skeleton);

            System.out.println("Created bookshelf with " + bookShelf.getBooks().size() + " objects ");
            System.err.println("Server Ready");

            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
}
