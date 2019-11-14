package modules.purchases.classes;

import classes.Date;
import modules.products.classes.Product;
import modules.users.classes.User;
import modules.products.classes.*;

public class Purchase {
	private Product product;//id autoincrementable de compra
	private User partner;
	private int quantity;
	private String price; // product_price * descuento_member(5%...10%..20%)
	private int discount;
	private Date purchaseDate;
	private Date returnDate;

	public Purchase(Product product, User partner, int quantity, int discount, String price, Date purchaseDate,
			Date returnDate) {
		super();
		this.product = product;
		this.partner = partner;
		this.quantity = quantity;
		this.price = price;
		this.discount = calculateDiscount();
		this.purchaseDate = purchaseDate;
		this.returnDate = returnDate;
	}

	public int calculateDiscount() {
		
		
		return this.discount = 5;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public int getIdProduct() {
		Class<?> clazz = product.getClass(); 
		String nameProducrt = ((Film)product).getName();
	
		return 5;
	}

	public void setId_purchase(int id_purchase) {
		this.id_purchase = id_purchase;
	}

	public int getIdPartner() {
		return 11;
	}

	public User getPartner() {
		return partner;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
