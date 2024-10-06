import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        try {

            if (args.length != 2) {
                System.err.println(args.length);
                System.err.println("usage: java Client host port input");

                System.exit(1);
            }

            int index = 0;

            String host = args[index++];
            int port = Integer.parseInt(args[index++]);


            Registry registry = LocateRegistry.getRegistry(host, port);

            Library stub = (Library) registry.lookup("Library");

            stub.search("author_1");
            stub.checkout("18");
            stub.returnBook("18");

            System.err.println("Remote method invoked");

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
