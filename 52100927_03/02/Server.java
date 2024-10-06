import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends CalculatorImp {

    public Server(){}

    public static void main(String[] args) {
        try {

            int index = 0;
            int port = Integer.parseInt(args[index++]);


            CalculatorImp calculatorImp = new CalculatorImp();


            Calculator skeleton = (Calculator) UnicastRemoteObject.exportObject(calculatorImp, 0);
            
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("Calculator", skeleton);

            System.err.println("Server Ready");

            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
}
