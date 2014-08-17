
import java.rmi.*;
public interface HelloInterface extends Remote {
    public String sayHello2(String msg) throws RemoteException;
    public String showBookingStatus(int lecture_hall,String date_of_booking) throws RemoteException;
    public String book_lecture_hall(String date_of_booking, int lecture_hall_no, int start, int end) throws RemoteException;
}