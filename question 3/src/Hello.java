// Interface of server class
import java.rmi.*;
import java.rmi.server.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Hello extends UnicastRemoteObject implements HelloInterface {

   private String message;
   private Past90Days past_90_days;
   private LectureHallTimeTable lecture_hall_time_table;
   private Date date;
   private Constants constants;
   
   public Hello(String msg) throws RemoteException {
      message = msg;
      past_90_days = new Past90Days();
      date = new Date();
      lecture_hall_time_table = new LectureHallTimeTable();
      constants = new Constants();
   }
   

public String book_lecture_hall(String date_of_booking, int lecture_hall_no, int start, int end) {
	   //Date d = sdf.parse("21/12/2012");
	   Date last_date_till_booked = lecture_hall_time_table.getMyList().get(lecture_hall_time_table.getMyList().size()-1).getDate();
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		try {
			d = sdf.parse(date_of_booking);
		} catch(Exception e) {
			return "unable to parse given date";
		}
		
	   int days = (int)( (d.getTime() - last_date_till_booked.getTime()) / (1000 * 60 * 60 * 24));
	   System.out.println("days are " + days);
	   if(days > 7)
		   return "Bad Request";
	   
	   for(int i=0; i<lecture_hall_time_table.getMyList().size(); i++) {
			if(((int) ( (new Date()).getTime() -  lecture_hall_time_table.getMyList().get(i).getDate().getTime()) / (1000 * 60 * 60 * 24)) >= 1) {
				lecture_hall_time_table.remove(i);
			}
			else 
				break;
		}
	   
	   for(int i=0; i<days; i++) {
		   lecture_hall_time_table.add(new SingleDayCalender());
	   }
	   
	   return lecture_hall_time_table.bookLectureHall(lecture_hall_no, start, end, days);
	   
} 
   
public String showBookingStatus(int lecture_hall,String date_of_booking)  {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date d = null;
	try {
		d = sdf.parse(date_of_booking);
	} catch(Exception e) {
		return "unable to parse given date";
	}
	for(int i=0; i<lecture_hall_time_table.getMyList().size(); i++) {
		if(((int) ( (new Date()).getTime() -  lecture_hall_time_table.getMyList().get(i).getDate().getTime()) / (1000 * 60 * 60 * 24)) >= 1) {
			lecture_hall_time_table.remove(i);
		}
		else 
			break;
	}
	Date dt = lecture_hall_time_table.getMyList().get(lecture_hall_time_table.getMyList().size() -1 ).getDate();
	for(int i=lecture_hall_time_table.getMyList().size(); i< constants.getBookingTill() ; i++) {
		SingleDayCalender x = new SingleDayCalender();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		x.setDate(dt);
		lecture_hall_time_table.add(x);
		System.out.println("dkjlsj" + lecture_hall_time_table.getMyList().size());
	}
	
	int days = (int) ( d.getTime() -  lecture_hall_time_table.getMyList().get(0).getDate().getTime()) / (1000 * 60 * 60 * 24);

	if(days <0 || days > constants.getBookingTill() || days >= lecture_hall_time_table.getMyList().size()) {
		return "Bad Request" + String.valueOf(days);
	}
	
	SingleDayCalender x = lecture_hall_time_table.getMyList().get(days);
	return x.printDay(lecture_hall);
	
	
}
   public String sayHello2(String m) throws RemoteException {
	      // return the input message - reversed input
	      // plus our standard message
	   	
	      return new StringBuffer(m).reverse().toString() + date.getTime();
	   } 
}