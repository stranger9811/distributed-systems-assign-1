
import java.rmi.*;
public interface HelloInterface extends Remote {
    public String sayHello(String msg) throws RemoteException;
}