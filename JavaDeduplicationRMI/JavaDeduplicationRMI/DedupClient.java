import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DedupClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            DedupInterface stub = (DedupInterface) registry.lookup("DedupService");

            String test1 = "hello";
            String test2 = "world";
            String test3 = "hello"; // duplicate

            System.out.println("Sending: " + test1);
            System.out.println(stub.checkDuplicate(test1) ? "Duplicate" : "Unique");

            System.out.println("Sending: " + test2);
            System.out.println(stub.checkDuplicate(test2) ? "Duplicate" : "Unique");

            System.out.println("Sending: " + test3);
            System.out.println(stub.checkDuplicate(test3) ? "Duplicate" : "Unique");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
