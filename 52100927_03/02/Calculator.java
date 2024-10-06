import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    public void operation(double num1, double num2, String operand) throws RemoteException;
}