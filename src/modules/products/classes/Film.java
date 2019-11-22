package modules.products.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.*;

public class Film extends Product {
	
	private int duration;
	private String synopsis;
	
	public Film(String name, int price, int stock, double rating, Date date, int duration, String synopsis) {
		super(name, price, stock, rating, date);
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
				+ ", getStock()="+ getStock() + ", getRating()=" + getRating() + ", duration=" + duration + ", synopsis=" + synopsis + "]";
	}

	public String[][] getProperties(){
		
		String[] listGetters = { getName(), ""+getPrice(), ""+getStock(), ""+getRating(), getDate().getDate(), ""+getDuration(), getSynopsis()};
		String[] listNames = {"Name: ", "Price: ", "Stock: ", "Rating: ", "Release Date: : ", "Duration: ", "Synopsis: "};
		
		String[][] result = {listGetters, listNames};
		return result;
	 }

}
