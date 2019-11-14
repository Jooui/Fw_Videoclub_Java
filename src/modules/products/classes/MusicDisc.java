package modules.products.classes;

import classes.*;

public class MusicDisc extends Product {
	String artist;
	int duration;
	public MusicDisc(String name, int price, int stock, double rating, Date date, int duration, String artist) {
		super(name, price, stock, rating, date);
		this.artist = artist;
		this.duration = duration;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "MusicDisc [getName()=" + getName() + ", getDate()=" + getDate() + ", getPrice()=" + getPrice()
				+", getStock()="+ getStock() +", getRating()=" + getRating() + ", artist=" + artist + ", duration=" + duration + "]";
	}

}
