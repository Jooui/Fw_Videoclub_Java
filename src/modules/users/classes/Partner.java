package modules.users.classes;

import classes.Date;
import functions.functions;

public class Partner extends User{
	private int id_partner;
	private Date joinDate;
	public Partner(String username, String password, String name, String surnames, String dni, String city, String postalCode, String address, String email, Date fnac,
			int tlf) {
		super(username, password, name, surnames, dni, city, postalCode, address, email, fnac, tlf);
		this.id_partner=assignIdUser();
		this.joinDate=new Date();
	}
	
	public static int assignIdUser() {
		int id = 0;
		int lastId = 0;
		
		for (int i = 0; i < Singleton.users.size(); i++) {
			
			if (Singleton.users.get(i) instanceof Partner) {
				lastId = ((Partner)Singleton.users.get(i)).getId();
			}
		}
		
		if (lastId != 0) {
			id = (lastId + 1);
		}else {
			id = 1;
		}
		
		return id;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getDiscount() {
		String discount = "";
		if (getJoinDate().getYear()==2019)
			discount = "05";
		return discount;
	}
	



	@Override
	public String toString() {
		return "Partner [getName()=" + getName() + ", getDni()=" + getDni() + ", getSurnames()=" + getSurnames()
				+ ", getPostalCode()=" + getPostalCode() + ", getCity()=" + getCity() + ", getAddress()=" + getAddress()
				+ ", getEmail()=" + getEmail() + ", getFnac()=" + getFnac() + ", getTlf()=" + getTlf() + ", id_partner="
				+ id_partner + ", joinDate=" + joinDate + "]";
	}

	public int getId() {
		return id_partner;
	}

	public void setId(int id) {
		this.id_partner = id;
	}
	public String[][] getProperties(){
		
		String[] listGetters = { ""+getName(), ""+getSurnames(), ""+getDni(), getFnac().getDate(), ""+getEmail(), getCity(), getPostalCode(), getAddress(), ""+getTlf(), getJoinDate().getDate()};
		String[] listNames = { "Name: ", "Surnames: ", "DNI: ", "Birth Date: : ", "Email: ", "City: ", "Postal Code: ", "Address: ", "Tlf: ", "Join Date: "};
		
		String[][] result = {listGetters, listNames};
		return result;
}
	
}
