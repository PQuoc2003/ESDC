import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        try {

            if (args.length != 5) {
                System.err.println(args.length);
                System.err.println("usage: java Client host port input");

                System.exit(1);
            }

            int index = 0;

            String host = args[index++];
            int port = Integer.parseInt(args[index++]);
            double num1 = Double.parseDouble(args[index++]);
            String operand = args[index++];
            double num2 = Double.parseDouble(args[index++]);

            Registry registry = LocateRegistry.getRegistry(host, port);

            Calculator stub = (Calculator) registry.lookup("Calculator");

            stub.operation(num1, num2, operand);

            System.err.println("Remote method invoked");

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
