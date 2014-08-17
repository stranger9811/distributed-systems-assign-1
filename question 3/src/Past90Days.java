
import java.util.ArrayList;
import java.util.List;

public class Past90Days {
	List<SingleDayCalender> myList = new ArrayList<SingleDayCalender>();
	
	public void AddOneDay(SingleDayCalender single_day) {
		if(myList.size() >= 90) {
			myList.remove(0);
		}
		myList.add(single_day);
	}
}
