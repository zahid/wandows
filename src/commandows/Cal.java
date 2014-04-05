package commandows;

public class Cal {
	public static void main(String[] args) {
		
		long current = System.currentTimeMillis();
		long days = current / 1000 / 86400;
		
		int dayCounter = 0, i = 0;
		int leapCounter = 2;
		
		int leapYears = 0;
		int years = 0;
		
		while(i < days) {
			if(dayCounter == 365) {
				years++;
				leapCounter++;
				if(leapCounter % 4 == 0) {
					i++;
					leapYears++;
				}
				dayCounter = 0;
			}
			dayCounter++;
			i++;
		}
		
		/* First day of January 2014 */
		int yearStartDay = 3;
		
		int currentDay =  (int) (days - (leapYears * 366 + (365 * (years - leapYears))));
		String currentMonth = "";
		int daysInMonth = 0, monthStartDay = 0;
		
		if(leapYears % 4 == 0 && currentDay == 60) {
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

		String calendarOutput = currentMonth + "\nSu Mo Tu We Th Fr Sa\n";
		int weekLimit = monthStartDay;

		for(int j = 1; j < monthStartDay+1; j++) {
			calendarOutput += "   ";
		}
		for(int j = 1; j <= daysInMonth; j++) {
			weekLimit++;
			if(j < 10) {
				calendarOutput += "  " + j;
			} else {
				calendarOutput += " " + j;
			}
			if(weekLimit % 7 == 0) {
				weekLimit = 0;
				calendarOutput += "\n";
			}
		}
		System.out.println(calendarOutput);
	}
}