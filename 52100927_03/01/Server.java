import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends HelloImp {

    public Server(){}

    public static void main(String[] args) {
        try {

            int index = 0;
            int port = Integer.parseInt(args[index++]);


            HelloImp helloImp = new HelloImp();


            Hello skeleton = (Hello) UnicastRemoteObject.exportObject(helloImp, 0);
            
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("Hello", skeleton);

            System.err.println("Server Ready");

            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
}
