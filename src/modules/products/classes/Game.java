package modules.products.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.*;

public class Game extends Product {

	String platform;
	
	
	public Game(String name, int price, int stock, double rating, Date date, String platform) {
		super(name, price, stock, rating, date);
		this.platform = platform;
	}


	public String getPlatform() {
		return platform;
	}


	public void setPlatformBOX(String platform) {
		this.platform = platform;
	}


	@Override
	public String toString() {
		return "Game [getName()=" + getName() + ", getDate()=" + getDate() + ", getPrice()=" + getPrice()
				+ ", getStock()="+ getStock() +", getRating()=" + getRating() + ", platform=" + platform + "]";
	}
	
	public String[][] getProperties(){
		
		String[] listGetters = { getName(), ""+getPrice(), ""+getStock(), ""+getRating(), getDate().getDate(), getPlatform()};
		String[] listNames = {"Name: ", "Price: ", "Stock: ", "Rating: ", "Release Date: : ", "Platform: "};
		
		String[][] result = {listGetters, listNames};
		return result;
	 }
}
