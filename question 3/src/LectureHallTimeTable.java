import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class LectureHallTimeTable {
	private List<SingleDayCalender> myList = new ArrayList<SingleDayCalender>();
	private Constants constants = new Constants();
	Date dt = new Date();
	public  LectureHallTimeTable() {
		for(int i=0; i<constants.getBookingTill(); i++) {
			SingleDayCalender x = new SingleDayCalender();
			x.setDate(dt);
			myList.add(new SingleDayCalender());
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
		}
	}
	public void remove(int index) {
		if(index >=0 && index < myList.size()) {
			myList.remove(index);
		}
	}
	public void add(SingleDayCalender x)  {
		Date dt = myList.get(myList.size() -1).getDate();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		x.setDate(dt);
		myList.add(x);
	}
	
	public List<SingleDayCalender> getMyList() {
		return myList;
	}
	public String bookLectureHall(int lecture_hall,int start,int end,int index) {
		if(myList.get(index).book(lecture_hall, start, end)) {
			return "booked successfully";
		}
		else {
			return "booking unsuccessfull";
		}
		
	}
	
}
