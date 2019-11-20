package dashboard;

import classes.Date;
import functions.*;
import modules.products.classes.Film;
import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.users.classes.Partner;


public class home {

	public static void main(String[] args) {
		String[] options = {"Dummies","Purchases","Rents","Admin Options","Exit"}; //buttons name
		String[] elements = {"generateData","goPurchases","goRents","goAdminOpt"}; //functions name

		functions.menu(options, elements, "Videoclub Manager\n", "Videoclub"); //call the main menu
	}
	
	public static void goAdminOpt() {
		String[] options = {"Products","Users","Back"}; //buttons name
		String[] elements = {"goProducts","goUsers"}; //functions name

		functions.menu(options, elements, "Videoclub Manager\n", "Videoclub"); //call the main menu
	}
	
	public static void goPurchases() {
		String[] options = {"Buy Product","Search purchase"}; //buttons name
		String[] elements = {"createPurchase","searchPurchase"}; //functions name

		functions.secondaryMenu(options, elements, "Purchase Options\n", "PURCHASES", "Purchase", "purchases", "Purchase_CRUD"); //call the main menu
	}
	
	public static void goRents() {
		String[] options = {"Movies","Games","Music Discs","Back"}; //buttons name
		String[] elements = {"goMovies","goGames", "goMusic"}; //functions name

		functions.menu(options, elements, "Products\n", "Videoclub"); //call the main menu
	}
	
	public static void goProducts() {
		String[] options = {"Movies","Games","Music Discs","Back"}; //buttons name
		String[] elements = {"goMovies","goGames", "goMusic"}; //functions name

		functions.menu(options, elements, "Products\n", "Videoclub"); //call the main menu
	}

	public static void goUsers() {
		String[] options = {"Admins","Partners","Back"}; //buttons name
		String[] elements = {"goAdmins","goPartners"}; //functions name

		functions.menu(options, elements, "Users\n", "Videoclub"); //call the main menu
	}

	public static void goAdmins() {
		String[] options = {"Add admin", "Search admin", "Edit admin", "Delete admin"}; //buttons name
		String[] elements = {"createUser", "showUser", "editUser", "deleteUser"}; //functions name

		functions.secondaryMenu(options, elements, "Administrators Options\n", "ADMINISTRATORS", "Admin", "users", "User_CRUD"); //call the main menu
	}
	
	public static void goPartners() {
		String[] options = {"Add partner", "Search partner", "Edit partner", "Delete partner"}; //buttons name
		String[] elements = {"createUser", "showUser", "editUser", "deleteUser"}; //functions name

		functions.secondaryMenu(options, elements, "Partners Options\n", "PARTNERS", "Partner", "users", "User_CRUD"); //call the main menu
	}

	public static void goMovies() {
		String[] options = {"Add movie", "Search movie", "Edit movie", "Delete movie"}; //buttons name
		String[] elements = {"createProduct", "showProducts", "editProduct", "deleteProduct"}; //functions name

		functions.secondaryMenu(options, elements, "Movies Options\n", "MOVIES", "Film", "products", "Product_CRUD"); //call the main menu
	}
	
	public static void goGames() {
		String[] options = {"Add game", "Search game", "Edit game", "Delete game"}; //buttons name
		String[] elements = {"createProduct", "showProducts", "editProduct", "deleteProduct"}; //functions name

		functions.secondaryMenu(options, elements, "Games Options\n", "GAMES", "Game", "products", "Product_CRUD"); //call the main menu
	}
	
	public static void goMusic() {
		String[] options = {"Add music disc", "Search music disc", "Edit music disc", "Delete music disc"}; //buttons name
		String[] elements = {"createProduct", "showProducts", "editProduct", "deleteProduct"}; //functions name

		functions.secondaryMenu(options, elements, "Music Options\n", "MUSIC", "Music", "products", "Product_CRUD"); //call the main menu
	}
	
	public static void generateData() {
		Date dateObj = new Date("25/10/2018");
		Product product = new Film("Spiderman 2", 50, 15, 4.5, dateObj, 117, "Descripcion - Synopsis");
		Product product2 = new Film("Pelicula 2", 25, 15, 4.5, dateObj, 117, "Descripcion - Synopsis");

		Partner user = new Partner("Joel", "Revert Vila", "49267906C", "Ontinyent", "46870", "C/ Sant Josep, 6", "jrevertvila@gmail.com", dateObj, 665996125);
		Partner user2 = new Partner("Pepe", "Username1 Username2", "67140703T", "Ontinyent", "46870", "C/ Sant Josep, 6", "jrevertvila@gmail.com", dateObj, 665996125);

		for (int i = 0; i < 15; i++) {
			Purchase purchase = new Purchase(product2, user, 1);
			Purchase purchase1 = new Purchase(product, user2, 1);
			modules.purchases.classes.Singleton.purchases.add(purchase);
			modules.purchases.classes.Singleton.purchases.add(purchase1);
		}
		
		
		
		
		modules.products.classes.Singleton.products.add(product);
		modules.users.classes.Singleton.users.add(user);
		modules.products.classes.Singleton.products.add(product2);
		modules.users.classes.Singleton.users.add(user2);
	}
}
