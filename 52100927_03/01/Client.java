import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public Client(){
    }


    public static void main(String[] args) {
        try {
            
            if (args.length != 4) {
                System.err.println("usage: java Client host port input");

                System.exit(1);
            }

            int index = 0;

            String host = args[index++];
            int port = Integer.parseInt(args[index++]);
            String inputName = args[index++];
            int inputAge = Integer.parseInt(args[index++]);

            Registry registry = LocateRegistry.getRegistry(host, port);


            Hello stub = (Hello) registry.lookup("Hello");

            stub.printMgs(inputName, inputAge);

            System.err.println("Remote method invoked");

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
