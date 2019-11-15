package modules.purchases.classes;

import java.lang.reflect.InvocationTargetException;

import classes.Date;
import modules.products.classes.Product;
import modules.users.classes.Partner;
import modules.purchases.classes.Singleton;
import modules.users.classes.User;
import modules.products.classes.*;

public class Purchase {
	private int id_purchase;
	private Product product;// id autoincrementable de compra
	private User partner;
	private int quantity;
	private String price; // product_price * descuento_member(5%...10%..20%)
	private int discount;
	private Date purchaseDate;
	private Date returnMaxDate;

	public Purchase(Product product, User partner, int quantity) {
		super();
		this.id_purchase = calculatePurchaseId();
		this.product = product;
		this.partner = partner;
		this.quantity = quantity;
		this.price = calculatePrice();
		this.discount = calculateDiscount();
		this.purchaseDate = new Date();
		this.returnMaxDate = calculateReturnMaxDate();
	}

	public int calculateDiscount() { //Dependiendo de la antiguedad del Partner, se aplicará un descuento mayor o menor. Antiguedad >= 6 meses = 5%
																					//Antiguedad >= 12 meses = 10%		Antiguedad >= 24 meses = 20%
		return this.discount = 05;
	}
	
	public String calculatePrice() { //Multiplicar el precio del producto por el descuento. Ejemplo: 40 * 0.05
		String finalPrice = "";
		
		String discountValue = "0."+calculateDiscount();
		double discountInt = Double.parseDouble(discountValue);
		double discountApplied = ((getProduct().getPrice())*discountInt);
		finalPrice = (""+(getProduct().getPrice()-discountApplied));
		
		return finalPrice;
	}
	
	public int calculatePurchaseId() { //Calcular el ID de compra que tendrá. Returns int.
		int id = 0;
		int lastId = 0;
		
		for (int i = 0; i < Singleton.purchases.size(); i++) {
				lastId = Singleton.purchases.get(i).getId_purchase();
		}
		if (lastId != 0) {
			id = (lastId + 1);
		}else {
			id = 1;
		}
		return id;
	}
	
	public Date calculateReturnMaxDate() { //fecha de compra + 15 dias.
		return new Date();
	}
	
	public int getId_purchase() {
		return id_purchase;
	}

	public void setId_purchase(int id_purchase) {
		this.id_purchase = id_purchase;
	}
	
	public int getDiscount() {
		return discount;
	}

	public String getIdProduct() {

		String nameProduct = product.getName();

		return nameProduct;
	}

	public int getIdPartner() {
		return 11;
	}

	public User getPartner() {
		return partner;
	}

	public Product getProduct() {
		if (product instanceof Film) {
			return ((Film) product);
		} else if (product instanceof Game) {
			return ((Game) product);
		} else if (product instanceof MusicDisc) {
			return ((MusicDisc) product);
		}
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

	public Date getReturnMaxDate() {
		return returnMaxDate;
	}

	public void setReturnMaxDate(Date returnMaxDate) {
		this.returnMaxDate = returnMaxDate;
	}

}
