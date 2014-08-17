// Hello client class
import java.rmi.*;
import java.text.ParseException;
import java.util.Scanner;
public class HelloClient {
   public static void main(String args[]) {
      try {
          if (args.length < 0) {
             System.err.println("usage: java HelloClient string\n");
             System.exit(1);

          }
          HelloInterface hello = (HelloInterface)Naming.lookup("//localhost/Hello");
          
          while(true) {
        	  Scanner scanner = new Scanner(System.in);
        	  
        	  System.out.println("1. For booking String");
        	  System.out.println("2. To check booking");
        	  System.out.println("4. For Exit");
        	  
        	  Scanner in = new Scanner(System.in);
        	  int num = in.nextInt();
        	  if(num == 4) 
        		  break;
        	  if(num == 1) {
        		  System.out.println("date_of_booking(ex 21/12/2012) lecture_hall_no slot_start slot_end");
        		  String s = scanner.nextLine();
        		  String[] myString = s.split("\\s+");
        		  
        		  System.out.println(hello.book_lecture_hall(myString[0], Integer.parseInt(myString[1]), Integer.parseInt(myString[2]), Integer.parseInt(myString[3])));
        		  
        	  }
        	  
        	  if (num == 2) {
        		  System.out.println("lecture_hall_no date_of_booking(ex 21/12/2012)");
        		  String s = scanner.nextLine();
        		  String[] myString = s.split("\\s+");
        		  System.out.println(Integer.parseInt(myString[0]) + " " + myString[1]);
        		  System.out.println(hello.showBookingStatus(Integer.parseInt(myString[0]),myString[1]));
        	  }
        	  
        	  
          }
          
      } catch (Exception e) {
          System.out.println("Helloclient exception: " + e);
      }
   } 
}