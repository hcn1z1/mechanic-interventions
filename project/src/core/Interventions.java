package core;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Interventions {
	
	public String nameClient;
	public int interventionId;
	public String interventionType;
	public Date intervStartingDate;
	public Date intervFinalDate;
	public int hour = 0;
	public int carId;
	Interventions(){
		
	}
	public Interventions(String nameClient,int interventionId,String interventionType,Date intervStartingDate,Date intervFinalDate,int carId){
		this.nameClient = nameClient;
		this.interventionId = interventionId;
		this.interventionType = interventionType;
		this.intervStartingDate = intervStartingDate;
		this.intervFinalDate = intervFinalDate;
		this.carId = carId;
		this.setHour();
	}
	public void printOut() {
		
		System.out.println(nameClient + " " +interventionId);
		
	}
	
	protected void setHour() {
		 Timestamp timestamp = new Timestamp(intervStartingDate.getTime());
	     Calendar calendar = Calendar.getInstance();
	     calendar.setTime(timestamp);
	     this.hour = calendar.get(Calendar.HOUR_OF_DAY);
	}
}
