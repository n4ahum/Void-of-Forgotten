import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;

public class DedupServer extends UnicastRemoteObject implements DedupInterface {
    private HashSet<String> dataSet;

    protected DedupServer() throws RemoteException {
        dataSet = new HashSet<>();
    }

    public boolean checkDuplicate(String input) throws RemoteException {
        if (dataSet.contains(input)) {
            return true; // Duplicate
        } else {
            dataSet.add(input);
            return false; // New entry
        }
    }

    public static void main(String[] args) {
        try {
            DedupServer obj = new DedupServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("DedupService", obj);
            System.out.println("Server ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
