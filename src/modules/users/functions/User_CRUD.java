package modules.users.functions;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.*;
import functions.functions;
import modules.users.classes.*;
import modules.users.templates.Forms;

public class User_CRUD {
	// Date date = new Date();
	// User user = null;
	// defaultAdmin = new Admin("admin", "admin", "Administrator", "Surname1
	// Surname2", "Ontinyent", "46870", "Carrer Sant Josep, 6",
	// "jrevertvila@gmail.com", date, 665996125);
	// Singleton.users.add(defaultAdmin);
	public static void createUser(String type) {// CREATE NEW PRODUCT
		User user = null;
		boolean repeated = false;
		do {
			repeated = false;
			ArrayList<Object> properties = new ArrayList<Object>();
			if (type == "Admin") { // create new Film
				properties = Forms.adminForm();
				if (properties == null)
					return;
				user = new Admin((String) properties.get(0), (String) properties.get(1), (String) properties.get(2),
						(String) properties.get(3), (String) properties.get(4), (String) properties.get(5),
						(String) properties.get(6), (String) properties.get(7), (String) properties.get(8),
						(Date) properties.get(9), (int) properties.get(10));

			} else if (type == "Partner") { // create new Game
				properties = Forms.partnerForm();
				if (properties == null)
					return;
				user = new Partner((String) properties.get(0), (String) properties.get(1), (String) properties.get(2),
						(String) properties.get(3), (String) properties.get(4), (String) properties.get(5),
						(String) properties.get(6), (Date) properties.get(7), (int) properties.get(8));
			}
			if (user.find() == 1) {
				repeated = true;
				JOptionPane.showMessageDialog(null, "This user already exists", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while (repeated == true);
		Singleton.users.add(user);

	}

	public static void searchUser(String type) {
		String result = "";
		for (int i = 0; i < Singleton.users.size(); i++) {
			if (functions.validateInstaceof(Singleton.users.get(i), type) == true) {
				result = result + (Singleton.users.get(i).toString()+"\n");
			}
		}
		if (result.isEmpty())result = "There aren't any partner";
		JOptionPane.showMessageDialog(null, result);
	}
	
	public static ArrayList<User> getArray() {
		return Singleton.users;
	}
}