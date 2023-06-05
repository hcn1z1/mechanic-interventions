package date;
import java.util.*;

public class Date {
	public int day;
	public int month;
	public int year;
	public int hour;
	public int minutes;
	public int seconds;
	public static Scanner scan = new Scanner(System.in);
	int [] thirtyOneDays = {1,3,5,7,8,10,12};
	int [] thirtyDays = {4,6,9,11};
	public Date() {
		//default date to make calculations 
	}
	
	public Date(int day,int month,int year) throws Exception{
		this.valideDate(day,month,year);
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(int day,int month,int year,int hour,int minutes,int seconds) throws Exception{
		this.valideDate(day,month,year,hour,minutes,seconds);
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public void ToString() {
		System.out.println(this.day+"/"+this.month+"/"+this.year);
	}
	
	int nbrOfDays(Date date) {
		int number = date.month;
		for(int i=0;i<7;i++) {
			if(thirtyOneDays[i] == number) {
				return 31;
			}
		}
		for(int i=0;i<4;i++) {
			if(thirtyDays[i] == number) {
				return 30;
			}
		}
		if(date.year%4 ==0) {
			return 29;
		}
		return 28;
	}
	int nbrOfDays(int year,int month) {
		int number = month;
		for(int i=0;i<7;i++) {
			if(thirtyOneDays[i] == number) {
				return 31;
			}
		}
		for(int i=0;i<4;i++) {
			if(thirtyDays[i] == number) {
				return 30;
			}
		}
		if(year%4 ==0) {
			return 29;
		}
		return 28;
	}
	public Date nextDays(Date date, int nextDays) {
		int nbr = nbrOfDays(date);
		while(nextDays>nbr) {
			date.year += (date.month + 1)/13;
			date.month = (date.month+1)%13 + (date.month + 1)/13;
			nextDays -= nbr;
			nbr = nbrOfDays(date);
		}
		nextDays += date.day ;
		date.month += nextDays/nbr;
		date.year += date.month/13;
		date.month = date.month%13 + (date.month + 1)/13;
		date.day = nextDays%nbr;
		return date;
	}
	public Date previousDays(Date date, int previousDays) {
		int nbr = nbrOfDays(date);
		while(previousDays>nbr) {
			month = date.month - 1;
			if(month == 0) {
				month = 13;
				date.year -= 1;
				month = 12;
			}
			date.month = month;
			previousDays -= nbr;
			nbr = nbrOfDays(date);
		}
		previousDays += date.day ;
		date.month -= previousDays/nbr;
		if(date.month == 0) {
			date.year -=1;
			date.month = 12;
		}
		date.day = previousDays%nbr;
		return date;
	}
	
	public int calculateDays(Date secondDate) {
		int days = 0;
		// suppose secondDate is bigger than this
		while(true){
			if(this.year< secondDate.year) {
				if (secondDate.year % 4 == 0) {
					days += 366;
				}
				else {
					days += 365;
				}
				secondDate.year -= 1;
			}
			else if(this.month<secondDate.month) {
				secondDate.month -= 1;
				days += nbrOfDays(secondDate.year,((secondDate.month)%13 + (secondDate.month)/13));
			}
			else if(this.month>secondDate.month){
				secondDate.month += 12;
				if ((this.year+1) % 4 == 0 && secondDate.month>2) {
					days -= 366;
				}
				else {
					days -= 365;
				}
			}
			else if(this.day<secondDate.day){
				days += secondDate.day - this.day;
				secondDate.day = this.day;
			}
			else if(this.day>secondDate.day) {
				days -= nbrOfDays(secondDate.year,(secondDate.month)%13);
				secondDate.day += nbrOfDays(secondDate);
			}
			else {
				this.ToString();
				secondDate.ToString();
				return days;
			}
		}
	}
	void valideDate(int day,int month,int year) throws Exception{
		if (!(year>=0 && month>0 && 12 >= month && nbrOfDays(year,month)>=day)) {
			throw new Exception("Invalide date ! Program exit with -1 status.");
		}
		
	}
	void valideDate(int day,int month,int year,int hours,int minutes,int seconds) throws Exception{
		if (!(year>=0 && month>0 && 12 >= month && nbrOfDays(year,month)>=day)) {
			throw new Exception("Invalide date ! Program exit with -1 status.");
		}
		if (!(hours>=0 && hours <= 23) && ! (minutes>=0 && minutes <= 59) && ! (seconds>=0 && seconds <= 59)) {
			throw new Exception("Invalide date ! Program exit with -1 status.");
		}
		
	}
	void inputDate() throws Exception{
		System.out.println("Enter day : ");
		int day_ = scan.nextInt();
		System.out.println("Enter Month : ");
		int month_ = scan.nextInt();
		System.out.println("Enter Year : "); 
		int year_ = scan.nextInt();
		this.valideDate(day_, month_, year_);
		this.day = day_;
		this.month = month_;
		this.year = year_;
	}
	
}
