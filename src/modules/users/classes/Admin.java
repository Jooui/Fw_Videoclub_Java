package modules.users.classes;

import classes.Date;

public class Admin extends User {


    public Admin(String username, String password, String name, String surnames, String dni, String city, String postalCode,
            String address, String email, Date fnac, int tlf) {
        super(username, password, name, surnames, dni,  city, postalCode, address, email, fnac, tlf);
    }
    
	public String[][] getProperties(){
			
			String[] listGetters = { getUsername(), ""+getName(), ""+getSurnames(), ""+getDni(), getFnac().getDate(), ""+getEmail(), getCity(), getPostalCode(), getAddress(), ""+getTlf()};
			String[] listNames = {"Username: ", "Name: ", "Surnames: ", "DNI: ", "Birth Date: : ", "Email: ", "City: ", "Postal Code: ", "Address: ", "Tlf: "};
			
			String[][] result = {listGetters, listNames};
			return result;
	}
}