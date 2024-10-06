import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        try {

            if (args.length != 3) {
                System.err.println(args.length);
                System.err.println("usage: java Client host port input");

                System.exit(1);
            }

            int index = 0;

            String host = args[index++];
            int port = Integer.parseInt(args[index++]);

            String filePath = args[index++];

            Registry registry = LocateRegistry.getRegistry(host, port);

            FileHandler stub = (FileHandler) registry.lookup("FileHandler");

            File file = new File(filePath);

            stub.operation(file);

            System.err.println("Remote method invoked");

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
