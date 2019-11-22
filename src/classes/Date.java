package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import functions.regexp;

public class Date {
	// private SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
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

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

//    	if (calendardate != null) {
//    	strdate = sdf.format(calendardate.getTime());
		Calendar cal = new GregorianCalendar();
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		this.month = cal.get(Calendar.MONTH + 1);
		this.year = cal.get(Calendar.YEAR);
		this.hour = cal.get(Calendar.HOUR_OF_DAY);
		this.minute = cal.get(Calendar.MINUTE);
		this.second = cal.get(Calendar.SECOND);
		this.date = format.format(cal.getTime());
		System.out.println("DATE: " + this.date);
	}

	public boolean validafecha() {
		boolean resultado = true;
		GregorianCalendar fecha = new GregorianCalendar();
		int dias_mes[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if ((this.month < 1) || (this.month > 12)) {
			resultado = false;
		}

		if (resultado) {
			fecha.set(this.year, this.month, this.day);

			if (fecha.isLeapYear(this.year)) {
				dias_mes[2] = 29;
			}

			if ((this.day < 1) || (this.day > dias_mes[this.month])) {
				resultado = false;
			}
		}

		return resultado;
	}

	public GregorianCalendar CalendarToGregCalendar(Calendar fecha) {
		GregorianCalendar f = new GregorianCalendar();
		f.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));
		return f;
	}

	
	public int subtractDates(Date fecha) {
        int yeara, yearb, cont = 0;

        GregorianCalendar fecha1 = new GregorianCalendar(this.year,
                this.month - 1, this.day);
        GregorianCalendar fecha2 = new GregorianCalendar(fecha.year,
                fecha.month - 1, fecha.day);

        if (fecha1.get(Calendar.YEAR) >= fecha2.get(Calendar.YEAR)) {
            long tiempo = fecha1.getTimeInMillis() - fecha2.getTimeInMillis();// diferencia
            // en milisegundos
            System.out.println("f1 milis: "+fecha1.getTimeInMillis());
            System.out.println("f2 milis: "+fecha2.getTimeInMillis());
            System.out.println(tiempo);
            yeara = (int) ((tiempo) / (1000 * 60 * 60 * 24));// paso los
            // miliseguindos a días
            System.out.println(yeara);

            /*for (int i = fecha2.get(Calendar.YEAR) + 1; i <= fecha1
                    .get(Calendar.YEAR); i++) {
                if (fecha1.isLeapYear(i)) {
                    cont++;// cuento el nº de años bisiestos entre las fechas
                    i = i + 3;
                }
            }

            yearb = cont * 366;// obtengo el nº de días de años bisiestos
            yeara = yeara - yearb;// se los resto al total de días
            yeara = yeara / 365;// obtengo los años de los días restantes
            yeara = yeara + cont;// sumo los años bisiestos*/
        } else {
        	yeara = -1;
        }

        return yeara;
    }
	
	
	public int subtractSystemDate() {
		int yeara, yearb, cont = 0;

		GregorianCalendar fecha1 = new GregorianCalendar(this.year, this.month - 1, this.day);
		GregorianCalendar fecha2;

		fecha2 = CalendarToGregCalendar(Calendar.getInstance());

		long tiempo = fecha1.getTimeInMillis() - fecha2.getTimeInMillis();// diferencia
		// en milisegundos

		yeara = (int) ((tiempo) / (1000 * 60 * 60 * 24));// paso los
		// miliseguindos a días

		for (int i = fecha2.get(Calendar.YEAR) + 1; i <= fecha1.get(Calendar.YEAR); i++) {
			if (fecha1.isLeapYear(i)) {
				cont++;// cuento el nº de años bisiestos entre las fechas
				i = i + 3;
			}
		}

		yearb = cont * 366;// obtengo el nº de días de años bisiestos
		yeara = yeara - yearb;// se los resto al total de días
		yeara = yeara / 365;// obtengo los años de los días restantes
		yeara = yeara + cont;// sumo los años bisiestos

		return yeara;
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

	public String getDayMonthYear() {
		String withoutHour = getDay() + "-" + getMonth() + "-" + getYear();
		return getDay() + "-" + getMonth() + "-" + getYear();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
