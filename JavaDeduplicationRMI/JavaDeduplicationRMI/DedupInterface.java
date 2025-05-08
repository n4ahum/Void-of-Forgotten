import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DedupInterface extends Remote {
    boolean checkDuplicate(String input) throws RemoteException;
}
