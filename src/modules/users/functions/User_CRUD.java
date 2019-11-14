package modules.users.functions;

import java.util.ArrayList;

import classes.*;
import modules.users.classes.*;
import modules.users.templates.Forms;

public class User_CRUD {
    //Date date = new Date();
    //User user = null;
    //defaultAdmin = new Admin("admin", "admin", "Administrator", "Surname1 Surname2", "Ontinyent", "46870", "Carrer Sant Josep, 6", "jrevertvila@gmail.com", date, 665996125);
    //Singleton.users.add(defaultAdmin);
    public static void createUser(String type) {//CREATE NEW PRODUCT
		User user = null;
		ArrayList<Object> properties = new ArrayList<Object>();
		if (type == "Admin") { // create new Film
			properties = Forms.adminForm();
			if (properties == null)return;
			user = new Admin((String) properties.get(0), (String) properties.get(1), (String) properties.get(2), (String) properties.get(3), (String) properties.get(4), (String) properties.get(5), (String) properties.get(6), (String) properties.get(7), (Date) properties.get(8), (int) properties.get(9));

		} else if (type == "Partner") { // create new Game
			properties = Forms.partnerForm();
			if (properties == null)return;
			user = new Partner((String) properties.get(0), (String) properties.get(1), (String) properties.get(2), (String) properties.get(3), (String) properties.get(4), (String) properties.get(5), (Date) properties.get(6), (int) properties.get(7));
		}
		Singleton.users.add(user);
		

		User usuario = user;
		
		System.out.println(usuario.getClass());
		System.out.println(user.toString());
	}

	public static void autoAdmin(){
		Date date = new Date();
        User user = null;
        user = new Admin("admin", "admin", "Administrator", "Surname1 Surname2", "Ontinyent", "46870", "Carrer Sant Josep, 6", "jrevertvila@gmail.com", date, 665996125);
        Singleton.users.add(user);
	}

	public static ArrayList<User> getArray(){
		return Singleton.users;
	}
}