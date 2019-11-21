package modules.purchases.classes;

import classes.Date;
import modules.products.classes.Product;
import modules.users.classes.Partner;
import modules.users.classes.User;
import modules.purchases.classes.Singleton;
import modules.products.classes.*;

public class Purchase {
	private int id_purchase;// id autoincrementable de compra
	private Product product;//Product Object
	private Partner partner;//Partner Object
	private int quantity;
	private double price; // product_price * descuento_member(5%...10%..20%)
	private double discount;
	private Date purchaseDate;
	private Date returnMaxDate;

	public Purchase(Product product, Partner partner, int quantity) {
		super();
		this.id_purchase = calculatePurchaseId();
		this.product = product;
		this.partner = partner;
		this.quantity = quantity;
		this.price = calculatePrice();
		this.discount = calculateDiscount();
		this.purchaseDate = new Date();
		this.returnMaxDate = calculateReturnMaxDate();
		
		for (int i = 0; i < modules.products.classes.Singleton.products.size(); i++) {
			
			if (modules.products.classes.Singleton.products.get(i).getName() == product.getName()) {
				int defaultStock = modules.products.classes.Singleton.products.get(i).getStock();
				modules.products.classes.Singleton.products.get(i).setStock(defaultStock-quantity);
				break;
			}
			
		}
	}
	
	private double calculateDiscount() { //Dependiendo de la antiguedad del Partner, se aplicará un descuento mayor o menor. Antiguedad >= 6 meses = 5%
																					//Antiguedad >= 12 meses = 10%		Antiguedad >= 24 meses = 20%
		String discountStr = ("0."+partner.getDiscount());
		return this.discount = Double.parseDouble(discountStr);
	}
	
	private double calculatePrice() { //Multiplicar el precio del producto por el descuento. Ejemplo: 40 * 0.05
		String finalPriceStr = "";
		double finalPrice = 0.0;
		double discountApplied = ((getProduct().getPrice())*calculateDiscount());
		finalPriceStr = (""+((getProduct().getPrice()-discountApplied)*quantity));
		finalPrice = Double.parseDouble(finalPriceStr);
		return finalPrice;
	}
	
	private int calculatePurchaseId() { //Calcular el ID de compra que tendrá. Returns int.
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
	
	public double getDiscount() {
		return discount;
	}

	public String getIdProduct() {

		String nameProduct = product.getName();

		return nameProduct;
	}

	public int getIdPartner() {
		return 11;
	}

	public Partner getPartner() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
