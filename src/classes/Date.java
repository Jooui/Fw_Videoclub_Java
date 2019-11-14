package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import functions.regexp;

public class Date {
	//private SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
	String date;
    int day;
    int month;
    int year;

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
    	
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

//    	if (calendardate != null) {
//    	strdate = sdf.format(calendardate.getTime());
    	Calendar cal = new GregorianCalendar();
    	this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.month = cal.get(Calendar.MONTH+1);
        this.year = cal.get(Calendar.YEAR);
        this.date = format.format(cal.getTime());
        System.out.println("DATE: "+this.date);
    }
    
    public int restarFechas() {
    	return 0;
    }
}
