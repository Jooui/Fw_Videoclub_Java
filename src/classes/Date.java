package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import functions.regexp;

public class Date {
	//private SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
	String date;
	private int day;
	private int month;
	private int year;
	private int hour;
    private int minute;
    private int second;
    public Date(String date) {
        String[] data = new String[3];

        data = date.split("[\\W]+");
        this.day = Integer.parseInt(data[0]);
        this.month = Integer.parseInt(data[1]);
        this.year = Integer.parseInt(data[2]);
        this.date = date;
    }
    
    @Override
	public String toString() {
		return date;
	}

    public Date() {
    	
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

//    	if (calendardate != null) {
//    	strdate = sdf.format(calendardate.getTime());
    	Calendar cal = new GregorianCalendar();
    	this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.month = cal.get(Calendar.MONTH+1);
        this.year = cal.get(Calendar.YEAR);
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.minute = cal.get(Calendar.MINUTE);
        this.second = cal.get(Calendar.SECOND);
        this.date = format.format(cal.getTime());
        System.out.println("DATE: "+this.date);
    }
    
    public int restarFechas() {
    	return 0;
    }

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
    
}
