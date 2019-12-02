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
import modules.users.templates.Forms;

public class index {
	static User userLoged = null;

	public static void main(String[] args) {
		classes.dummies.generateDummies();

		Integer option = 0;
		String[] options = { "Register", "Login" }; // buttons name

		while (option != -1) {
			option = JOptionPane.showOptionDialog(null, "Videoclub\n", "Videoclub", JOptionPane.YES_NO_OPTION,
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
		System.exit(0);

	}

	@SuppressWarnings("unlikely-arg-type")
	public static void login() {

		String[] choice = { "Log In", "Back" };
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		String passs = "" + password.getPassword();
		int option = 0;
		Object[] message = { "Login\n\nUsername: ", username, "Password:", password, };
		option = JOptionPane.showOptionDialog(null, message, "Create Admin", 0, JOptionPane.QUESTION_MESSAGE, null,
				choice, choice[0]);

		System.out.println(new String(password.getPassword()));
		for (int i = 0; i < modules.users.classes.Singleton.users.size(); i++) {
			System.out.println("username: " + modules.users.classes.Singleton.users.get(i).getUsername());
			System.out.println("password: " + modules.users.classes.Singleton.users.get(i).getPassword());
			String passArray = new String(modules.users.classes.Singleton.users.get(i).getPassword().toString());
			String pass = new String(password.getPassword());
			if (username.getText().equals(modules.users.classes.Singleton.users.get(i).getUsername())
					&& pass.equals(passArray)) {
				if (functions.validateInstaceof(modules.users.classes.Singleton.users.get(i), "Admin")) {
					modules.users.classes.Singleton.userLog = modules.users.classes.Singleton.users.get(i);
					home.main(null);
				} else if (functions.validateInstaceof(modules.users.classes.Singleton.users.get(i), "Partner")) {
					modules.users.classes.Singleton.userLog = modules.users.classes.Singleton.users.get(i);
					home_partner.main(null);
				}
			}
		}
		if (modules.users.classes.Singleton.userLog == null) {

		}
	}

	public static void register() {
		ArrayList<Object> properties = new ArrayList<Object>();
		Boolean correct = false;
		User user = null;
		do {
			correct = false;
			properties = Forms.partnerForm();
			if (properties == null)
				return;
			user = new Partner((String) properties.get(0), (String) properties.get(1), (String) properties.get(2),
					(String) properties.get(3), (String) properties.get(4), (String) properties.get(5),
					(String) properties.get(6), (String) properties.get(7), (String) properties.get(8),
					(Date) properties.get(9), (int) properties.get(10));
			if (user.findUsername() == 1) {
				correct = true;
				JOptionPane.showMessageDialog(null, "This user already exists", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(correct == true);
		
		modules.users.classes.Singleton.users.add(user);
	}

	public static void generateData() {
		Date dateObj = new Date("25/10/2018");
		Product product = new Film("Spiderman 2", 50, 15, 4.5, dateObj, 117, "Descripcion - Synopsis");
		Product product2 = new Film("Pelicula 2", 25, 15, 4.5, dateObj, 117, "Descripcion - Synopsis");

		Partner user = new Partner("jowi", "123", "Joel", "Revert Vila", functions.generateDni(null), "Ontinyent",
				"46870", "C/ Sant Josep, 6", "jrevertvila@gmail.com", dateObj, 665996125);
		Partner user2 = new Partner("partner", "123", "Pepe", "Username1 Username2", functions.generateDni(null),
				"Ontinyent", "46870", "C/ Sant Josep, 6", "jrevertvila@gmail.com", dateObj, 665996125);
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