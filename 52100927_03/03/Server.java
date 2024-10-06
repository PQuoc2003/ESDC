import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends FileHandlerImp {

    public Server(){}

    public static void main(String[] args) {
        try {

            int index = 0;
            int port = Integer.parseInt(args[index++]);


            FileHandlerImp fileHandlerImp = new FileHandlerImp();


            FileHandler skeleton = (FileHandler) UnicastRemoteObject.exportObject(fileHandlerImp, 0);
            
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("FileHandler", skeleton);

            System.err.println("Server Ready");

            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
}
