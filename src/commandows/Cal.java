package commandows;

public class Cal {
	
	private long current;
	private long days;
	private int leapYears;
	private int years;
	private String calendarOutput;
	
	/* First day of January 2014 */
	private static int yearStartDay = 3;
	
	public Cal() {
		this.current = System.currentTimeMillis();
		this.days = this.current / 86400000;
		calculateYears();
		calculateStartDayAndMonth();
		printCalendar();
	}
	
	public void calculateStartDayAndMonth() {
		int currentDay =  (int) (this.days - (this.leapYears * 366 + (365 * (this.years - this.leapYears))));
		String currentMonth = "";
		int daysInMonth = 0, monthStartDay = 0;
		
		if(this.leapYears % 4 == 0 && currentDay == 60) {
			currentMonth = "February";
			daysInMonth = 29;
			currentDay -= 60;
			monthStartDay = (yearStartDay + 31) % 7;
		} else if (currentDay <= 31) {
			currentMonth = "January";
			daysInMonth = 31;
			monthStartDay = (yearStartDay) % 7;
		} else if (currentDay > 31 && currentDay <= 59) {
			currentMonth = "February";
			currentDay -= 31;
			daysInMonth = 28;
			monthStartDay = (yearStartDay + 31) % 7;
		} else if (currentDay > 60 && currentDay <= 90) {
			currentMonth = "March";
			daysInMonth = 31;
			currentDay -= 59;
			monthStartDay = (yearStartDay + 59) % 7;
		} else if (currentDay > 91 && currentDay <= 120) {
			currentMonth = "April";
			daysInMonth = 30;
			currentDay -= 90;
			monthStartDay = (yearStartDay + 90) % 7;
		} else if (currentDay > 121 && currentDay <= 151) {
			currentMonth = "May";
			daysInMonth = 31;
			currentDay -= 151;
			monthStartDay = (yearStartDay + 120) % 7;
		} else if (currentDay > 152 && currentDay <= 181) {
			currentMonth = "June";
			daysInMonth = 30;
			currentDay -= 181;
			monthStartDay = (yearStartDay + 151) % 7;
		} else if (currentDay > 182 && currentDay <= 212) {
			currentMonth = "July";
			daysInMonth = 31;
			currentDay -= 212;
			monthStartDay = (yearStartDay + 181) % 7;
		} else if (currentDay > 213 && currentDay <= 243) {
			currentMonth = "August";
			daysInMonth = 31;
			currentDay -= 243;
			monthStartDay = (yearStartDay + 212) % 7;
		} else if (currentDay > 244 && currentDay <= 273) {
			currentMonth = "September";
		  	daysInMonth = 30;
		  	currentDay -= 273;
		  	monthStartDay = (yearStartDay + 243) % 7;
		} else if (currentDay > 274 && currentDay <= 304) {
			currentMonth = "October";
		  	daysInMonth = 31;
		  	currentDay -= 304;
		  	monthStartDay = (yearStartDay + 273) % 7;
		} else if (currentDay > 305 && currentDay <= 334) {
			currentMonth = "November";
		  	daysInMonth = 30;
		  	currentDay -= 334;
		  	monthStartDay = (yearStartDay + 304) % 7;
		} else if (currentDay > 345 && currentDay <= 365) {
			currentMonth = "December";
			daysInMonth = 31;
			currentDay -= 365;
			monthStartDay = (yearStartDay + 344) % 7;
		}
		buildCalendar(monthStartDay, daysInMonth, currentMonth);
	}
	
	public void calculateYears() {
		int dayCounter = 0, i = 0;
		int leapCounter = 2;
		
		this.leapYears = 0;
		this.years = 0;
		
		while(i < this.days) {
			if(dayCounter == 365) {
				this.years++;
				leapCounter++;
				if(leapCounter % 4 == 0) {
					i++;
					this.leapYears++;
				}
				dayCounter = 0;
			}
			dayCounter++;
			i++;
		}
	}
	
	public void buildCalendar(int monthStartDay, int daysInMonth, String currentMonth) {
		this.calendarOutput = currentMonth + "\nSu Mo Tu We Th Fr Sa\n";
		int weekLimit = monthStartDay;

		for(int j = 1; j < monthStartDay+1; j++) {
			this.calendarOutput += "   ";
		}
		for(int j = 1; j <= daysInMonth; j++) {
			weekLimit++;
			if(j < 10) {
				this.calendarOutput += "  " + j;
			} else {
				this.calendarOutput += " " + j;
			}
			if(weekLimit % 7 == 0) {
				weekLimit = 0;
				this.calendarOutput += "\n";
			}
		}
	}
	
	public void printCalendar() {
		System.out.println(this.calendarOutput);
	}
}