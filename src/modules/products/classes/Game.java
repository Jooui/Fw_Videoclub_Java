package modules.products.classes;

import classes.*;

public class Game extends Product {

	String platform;
	
	
	public Game(String name, int price, double rating, Date date, String platform) {
		super(name, price, rating, date);
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
				+ ", getRating()=" + getRating() + ", platform=" + platform + "]";
	}
	
	
}
