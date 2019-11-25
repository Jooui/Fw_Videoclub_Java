package modules.users.classes;

import classes.Date;

public class Admin extends User {
	private String username;
	private String password;

    public Admin(String username, String password, String name, String surnames, String dni, String city, String postalCode,
            String address, String email, Date fnac, int tlf) {
        super(name, surnames, dni,  city, postalCode, address, email, fnac, tlf);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
	public String[][] getProperties(){
			
			String[] listGetters = { getUsername(), ""+getName(), ""+getSurnames(), ""+getDni(), getFnac().getDate(), ""+getEmail(), getCity(), getPostalCode(), getAddress(), ""+getTlf()};
			String[] listNames = {"Username: ", "Name: ", "Surnames: ", "DNI: ", "Birth Date: : ", "Email: ", "City: ", "Postal Code: ", "Address: ", "Tlf: "};
			
			String[][] result = {listGetters, listNames};
			return result;
	}
}