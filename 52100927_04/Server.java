
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server extends HotelImp{


    public Server(){};

    public static void main(String[] args){

        try{

            int index = 0;
            int port = Integer.parseInt(args[index++]);

            HotelImp hotelImp = new HotelImp();

            Hotel skeleton = (Hotel) UnicastRemoteObject.exportObject(hotelImp, 0);

            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("Hotel", skeleton);

            System.err.println("Server ready");


        } catch (Exception e){
            System.err.println(e.toString());
        }



    }


}