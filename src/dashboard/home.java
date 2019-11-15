package dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import functions.*;
import modules.products.classes.Product;

public class home {

	public static void main(String[] args) {
		
		//modules.purchases.templates.Forms.createPurchase();
		//System.exit(0);
		
		String[] options = {"Products","Users","Exit"}; //buttons name
		String[] elements = {"goProducts","goUsers"}; //functions name

		functions.menu(options, elements, "Videoclub Manager\n", "Videoclub"); //call the main menu
	}

	public static void dashboard() {
		String[] options = {"Products","Users","Exit"}; //buttons name
		String[] elements = {"goProducts","goUsers"}; //functions name

		functions.menu(options, elements, "Videoclub Manager\n", "Videoclub"); //call the main menu
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
}
