package modules.users.classes;

import classes.Date;
import functions.functions;

public class Partner extends User{
	private int id_partner;
	private Date joinDate;
	public Partner(String name, String surnames, String city, String postalCode, String address, String email, Date fnac,
			int tlf) {
		super(name, surnames, city, postalCode, address, email, fnac, tlf);
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

	@Override
	public String toString() {
		return "Partner [getName()=" + getName() + ", getSurnames()=" + getSurnames() + ", getEmail()=" + getEmail()
				+ ", getFnac()=" + getFnac() + ", getTlf()=" + getTlf() + ", id_partner=" + id_partner + ", joinDate=" + joinDate + "]";
	}

	public int getId() {
		return id_partner;
	}

	public void setId(int id) {
		this.id_partner = id;
	}
	
}
