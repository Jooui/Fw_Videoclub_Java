package modules.purchases.functions;

import java.util.ArrayList;

import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.purchases.classes.Singleton;
import modules.purchases.templates.*;
import modules.users.classes.Partner;

public class Purchase_CRUD {

	public static void createPurchase(String type) {
		if (type == "Purchase") {
			Purchase purchase = null;
			ArrayList<Object> properties = new ArrayList<Object>();
			properties = Forms.createPurchase();
			if (properties == null)return;
			purchase = new Purchase((Product) properties.get(0), (Partner) properties.get(1), (int) properties.get(2));
			Singleton.purchases.add(purchase);
			System.out.println(Singleton.purchases.get(0).toString());
		}
		
	}
	
	public static void searchPurchase(String type) {
		if (type == "Purchase") {
			
			ArrayList<Object> properties = new ArrayList<Object>();
			properties = search.searchPurchase();
			
			
			
			
			
		}
	}
}
