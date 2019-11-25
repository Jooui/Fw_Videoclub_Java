package tests;

import classes.Date;
import modules.users.classes.Admin;
import modules.users.classes.Singleton;

public class maintest {

	public static void main(String[] args) {
		
		Admin admin = new Admin("admin","admin","name","surnames",functions.functions.generateDni(null),"ontinyent","46870","calle","jrevertvila@gmail.com",new Date("10/03/2001"),665996125);
		System.out.println(admin.toString());
		Singleton.users.add(admin);
		System.out.println(Singleton.users.get(0));
	}

}
