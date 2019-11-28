package dashboard;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classes.*;
import functions.functions;
import modules.products.classes.Film;
import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.users.classes.Admin;
import modules.users.classes.Partner;
import modules.users.classes.User;

public class index {

	public static void main(String[] args) {
		generateData();
		String[] options = { "Register", "Login" }; // buttons name

		Integer option = JOptionPane.showOptionDialog(null, "Videoclub\n", "Videoclub", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		System.out.println(option);
		switch (option) {
		case 0:
			register();
			break;

		case 1:
			login();
			break;
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void login() {

		String[] choice = { "Log In", "Exit" };
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		String passs = ""+password.getPassword();
		int option = 0;
		Object[] message = { "Login\n\nUsername: ", username, "Password:", password, };
		option = JOptionPane.showOptionDialog(null, message, "Create Admin", 0, JOptionPane.QUESTION_MESSAGE, null,
				choice, choice[0]);

		System.out.println(new String(password.getPassword()));
		for (int i = 0; i < modules.users.classes.Singleton.users.size(); i++) {
			System.out.println("username: "+modules.users.classes.Singleton.users.get(i).getUsername());
			System.out.println("password: "+modules.users.classes.Singleton.users.get(i).getPassword());
			String passArray = new String(modules.users.classes.Singleton.users.get(i).getPassword().toString());
			String pass = new String(password.getPassword());
			System.out.println(passArray);
			System.out.println(pass);
			if (username.getText().equals(modules.users.classes.Singleton.users.get(i).getUsername()) && pass.equals(passArray)) {
				System.out.println("entra al if");
				if (functions.validateInstaceof(modules.users.classes.Singleton.users.get(i), "Admin")) {
					home.main(null);
				}else if (functions.validateInstaceof(modules.users.classes.Singleton.users.get(i), "Partner")) {
					home_partner.main(null);
				}
			}
		}
	}

	public static void register() {

	}

	public static void generateData() {
		Date dateObj = new Date("25/10/2018");
		Product product = new Film("Spiderman 2", 50, 15, 4.5, dateObj, 117, "Descripcion - Synopsis");
		Product product2 = new Film("Pelicula 2", 25, 15, 4.5, dateObj, 117, "Descripcion - Synopsis");

		Partner user = new Partner("jowi","123","Joel", "Revert Vila", functions.generateDni(null), "Ontinyent", "46870",
				"C/ Sant Josep, 6", "jrevertvila@gmail.com", dateObj, 665996125);
		Partner user2 = new Partner("partner","123","Pepe", "Username1 Username2", functions.generateDni(null), "Ontinyent", "46870",
				"C/ Sant Josep, 6", "jrevertvila@gmail.com", dateObj, 665996125);
		Admin admin = new Admin("admin", "admin", "admin", "Surname1 Surname2", functions.generateDni(null),
				"Ontinyent", "46870", "C/ Sant Josep, 6", "jrevertvila@gmail.com", dateObj, 665996125);

		for (int i = 0; i < 15; i++) {
			Purchase purchase = new Purchase(product2, user, 1);
			Purchase purchase1 = new Purchase(product, user2, 1);
			modules.purchases.classes.Singleton.purchases.add(purchase);
			modules.purchases.classes.Singleton.purchases.add(purchase1);
		}

		modules.users.classes.Singleton.users.add(admin);
		modules.products.classes.Singleton.products.add(product);
		modules.users.classes.Singleton.users.add(user);
		modules.products.classes.Singleton.products.add(product2);
		modules.users.classes.Singleton.users.add(user2);

	}

}