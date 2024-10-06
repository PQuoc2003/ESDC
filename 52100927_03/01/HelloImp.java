import java.rmi.RemoteException;

public class HelloImp implements Hello {

    @Override
    public void printMgs(String name, int age) throws RemoteException {
        System.out.println(name + " is trying to contact");
        System.out.println("Their age is " + age);

    }

}
