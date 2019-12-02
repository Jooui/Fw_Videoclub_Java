package dashboard;

import javax.swing.JOptionPane;

import classes.Date;
import functions.*;
import modules.products.classes.Film;
import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.users.classes.Partner;
import modules.users.classes.User;


public class home {

	public static void main(String[] args) {
		String[] options = {"Profile","Purchases","Rents","Admin Options","Exit"}; //buttons name
		String[] elements = {"profile","goPurchases","goRents","goAdminOpt"}; //functions name

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
		String[] elements = {"createUser", "searchUser", "editUser", "deleteUser"}; //functions name

		functions.secondaryMenu(options, elements, "Administrators Options\n", "ADMINISTRATORS", "Admin", "users", "User_CRUD"); //call the main menu
	}
	
	public static void goPartners() {
		String[] options = {"Add partner", "Search partner", "Edit partner", "Delete partner"}; //buttons name
		String[] elements = {"createUser", "searchUser", "editUser", "deleteUser"}; //functions name

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
		
	public static void profile() {
		String[] options = {"Ok", "Log out"};
		System.out.println("entra al profile");
		User userProfile = modules.users.classes.Singleton.userLog;
		System.out.println(userProfile.toString());
		System.out.println("encuentra el user loged");

		
		String partnerNameSur = (userProfile.getName() + " " + userProfile.getSurnames());
		String partnerAddress = (userProfile.getPostalCode() + ", " + userProfile.getCity() + ", "
				+ userProfile.getAddress());
		String dataPart = "<html>Name :" + partnerNameSur + "<br/>DNI: " + userProfile.getDni()
		+ "<br/>Tlf: " + userProfile.getTlf() + "<br/>Email: " + userProfile.getEmail()
		+ "<br/>Birth Date: " + userProfile.getFnac().getDayMonthYear() + "<br/>Address: "
		+ partnerAddress + "</html>";
		
		Integer option=JOptionPane.showOptionDialog(null, dataPart, "profile", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		
		if (option == 1) {
			modules.users.classes.Singleton.userLog = null;
			index.main(null);
		}		
		
	}
	
	
}
