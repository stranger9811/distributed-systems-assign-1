import java.util.Arrays;
import java.util.Date;


public class SingleDayCalender {
	private Constants constants = new Constants();
	private boolean[][] time_table;
	private Date date;
	public  SingleDayCalender() {
		time_table = new boolean[constants.getNumberOfLectureHall()][48];
		for(boolean[] arr : time_table){
            Arrays.fill(arr, false);
        }
		date = new Date();
	}
	
	public boolean book(int lecture_hall_no, int start,int end) {
		for(int i=start; i<end; i++) {
			if(time_table[lecture_hall_no][i])
				return false;
		}
		for(int i=start; i<end; i++) {
			time_table[lecture_hall_no][i] = true;
		}
		return true;
	}
	public void setDate(Date d) {
		date = d;
	}
	public Date getDate() {
		return date;
	}
	public String printDay(int lecture_hall) {
		String to_return = "";
		for(int i=0; i<48; i++) {
			if(i%2==0) {
				to_return = to_return + String.valueOf(i/2) +":00 "+ String.valueOf(i/2) +":30  " + String.valueOf(time_table[lecture_hall][i]) + "\n";
			}
			else {
				to_return = to_return + String.valueOf(i/2) +":30 "+ String.valueOf((i+1)/2) +":00  " + String.valueOf(time_table[lecture_hall][i]) + "\n";
			}
		}
		return to_return;
	}
}
