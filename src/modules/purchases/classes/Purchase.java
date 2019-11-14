package modules.purchases.classes;

import classes.Date;

public class Purchase {
	private int id_purchase;
	private int id_member;
	private String name_product;
	private int quantity;
	private String price; // product_price * descuento_member(5%...10%..20%)
	private String discount;
	private Date purchaseDate;
	private Date returnDate;

	public Purchase(int id_purchase, int id_member, String name_product, int quantity, String price, Date purchaseDate,
			Date returnDate) {
		super();
		this.id_purchase = id_purchase;
		this.id_member = id_member;
		this.name_product = name_product;
		this.quantity = quantity;
		this.price = price;
		this.purchaseDate = purchaseDate;
		this.returnDate = returnDate;
	}

	public int getId_purchase() {
		return id_purchase;
	}

	public void setId_purchase(int id_purchase) {
		this.id_purchase = id_purchase;
	}

	public int getId_member() {
		return id_member;
	}

	public void setId_member(int id_member) {
		this.id_member = id_member;
	}

	public String getId_product() {
		return name_product;
	}

	public void setId_product(String name_product) {
		this.name_product = name_product;
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
