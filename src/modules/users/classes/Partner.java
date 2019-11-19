package modules.users.classes;

import classes.Date;
import functions.functions;

public class Partner extends User{
	private int id_partner;
	private Date joinDate;
	public Partner(String name, String surnames, String dni, String city, String postalCode, String address, String email, Date fnac,
			int tlf) {
		super(name, surnames, dni, city, postalCode, address, email, fnac, tlf);
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
