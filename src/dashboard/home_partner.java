package dashboard;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;

import functions.functions;

public class home_partner {
	public static void main(String[] args) {
		String[] options = {"Products","Buy","Exit"}; //buttons name
		Integer option = 0;
		do {
			option = JOptionPane.showOptionDialog(null, "Videoclub\n", "Videoclub", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			switch (option) {
			case 0:
				goProducts();
				break;

			case 1:
				goPurchases();
				break;
			}
			System.out.println(option);
		}while(option != 2 && option != -1);
		
	}
	
	public static void goProducts() {
		String[] options = {"Movies","Games","Music Discs"}; //buttons name
		String[] elements = {"createPurchase","searchPurchase"}; //functions name
		String type = "";
		Integer option = functions.secondaryButtonsMenu(options, "Products\n", "VIDEOCLUB"); //call the function where the OptionDialog will be called.
			if (option == 0) {
				type = "Movie";
			}else if (option == 1) {
				type = "Game";
			}else if (option == 2) {
				type = "MusicDisc";
			}
			
			if (option == null) return;
			
			modules.products.functions.Product_CRUD.showProducts(type);
		
		
		
		
		
		//functions.secondaryMenu(options, elements, "Purchase Options\n", "PURCHASES", type, module, crud); //call the main menu
		
//		String[] options = {"Add movie", "Search movie", "Edit movie", "Delete movie"}; //buttons name
//		String[] elements = {"createProduct", "showProducts", "editProduct", "deleteProduct"}; //functions name
//
//		functions.secondaryMenu(options, elements, "Products\n", "VIDEOCLUB", "Film", "products", "Product_CRUD"); //call the main menu
	}
	
	
	public static void goPurchases() {
		String[] options = {"Buy Product","My purchases"}; //buttons name
		String[] elements = {"createPurchase","searchPurchase"}; //functions name

		functions.secondaryMenu(options, elements, "Purchase Options\n", "PURCHASES", "Purchase", "purchases", "Purchase_CRUD"); //call the main menu
	}
}
