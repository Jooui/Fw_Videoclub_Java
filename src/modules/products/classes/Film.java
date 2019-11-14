package modules.products.classes;

import classes.*;

public class Film extends Product {
	
	int duration;
	String synopsis;
	
	public Film(String name, int price, double rating, Date date, int duration, String synopsis) {
		super(name, price, rating, date);
		this.duration = duration;
		this.synopsis = synopsis;
		
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "Film [getName()=" + getName() + ", getDate()=" + this.getDate().toString() + ", getPrice()=" + getPrice()
				+ ", getRating()=" + getRating() + ", duration=" + duration + ", synopsis=" + synopsis + "]";
	}
	

}
