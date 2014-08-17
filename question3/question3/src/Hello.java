// Interface of server class
import java.rmi.*;
import java.rmi.server.*;
public class Hello extends UnicastRemoteObject implements HelloInterface {

private String message;
   public Hello(String msg) throws RemoteException {
      message = msg;
   }
   public String sayHello(String m) throws RemoteException {
      // return the input message - reversed input
      // plus our standard message
      return new StringBuffer(m).reverse().toString() + "\n" + message;
   } 
}