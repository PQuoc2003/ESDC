import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileHandler extends Remote {

    public void operation(File file) throws RemoteException;
}