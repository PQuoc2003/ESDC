import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Library extends Remote {

    public void search(String query) throws RemoteException;

    public Book checkout(String id) throws RemoteException;

    public void returnBook(String id) throws RemoteException;

}