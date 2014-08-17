// Hello server class
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;


public class HelloServer {
   public static void main(String argv[]) throws RemoteException {
	   Registry registry = null;
	   try {
	       registry = LocateRegistry.getRegistry(52365);//use any no. less than 55000
	       registry.list();
	       // This call will throw an exception if the registry does not already exist
	   }
	   catch (RemoteException e) { 
	       registry = LocateRegistry.createRegistry(52365);
	   }
	  

      if (System.getSecurityManager() == null)
         System.setSecurityManager(new RMISecurityManager());
      try {
          // instantiate the service with the standard
          // message & tell registry
          Naming.rebind("Hello", new Hello("Hello, world!"));
          System.out.println("Server is running...");
      } catch(Exception e) {
          System.out.println("Hello Server failed: " + e);
      } 		
   }
}