package modules.products.classes;

import classes.*;

public abstract class Product {
	//attributes
	private String name;
	private int price;
	private int stock;
	private double rating;
	private Date date;
	
	//Constructor
	public Product(String name, int price, int stock, double rating, Date date) {
		super();
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.date = date;
		this.stock = stock;
	}
	
	//getters and setters

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", date=" + date + ", price=" + price + ", rating=" + rating + "]";
	}
	
}
