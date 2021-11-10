//import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//register
public class SorterServer {
    public static void main(String[] args) {

        try {
            // Instantiating the implementation class
            SorterImplementation service = new SorterImplementation();
            // Register remote objects and provide services to clients.
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            //bind
            registry.bind("Hello", service);
            System.out.println("Server ready");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
