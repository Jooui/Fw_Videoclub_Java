package modules.users.classes;

import classes.Date;

public abstract class User {
	// Attributes
	private String name;
	private String surnames;
	private String dni;
	private String city;
	private String postalCode;
	private String address;
	private String email;
	private Date fnac;
	private int tlf;
	private int age;
	private String username;
	private String password;

	public User(String username, String password, String name, String surnames, String dni, String city, String postalCode, String address, String email, Date fnac,
			int tlf) {
		super();
		this.setUsername(username);
		this.setPassword(password);
		this.name = name;
		this.surnames = surnames;
		this.dni = dni;
		this.city = city;
		this.postalCode = postalCode;
		this.address = address;
		this.email = email;
		this.fnac = fnac;
		this.tlf = tlf;
		this.age = calculateAge();
	}

	public int findUsername() {
		int result = -1;
		String ussername = this.username;
		String usernameObt = "";
		for (int i = 0; i < Singleton.users.size(); i++) {
			usernameObt = Singleton.users.get(i).getUsername();
			if (ussername.equals(usernameObt)) {
				result = 1;
			}
		}
		return result;
	}
	
	public int findDni() {
		int result = -1;
		String ddni = this.dni;
		String dniObtained = "";
		for (int i = 0; i < Singleton.users.size(); i++) {
			dniObtained = Singleton.users.get(i).getDni();
			if (ddni.equals(dniObtained)) {
				result = 1;
			}
		}
		return result;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int calculateAge() {
		int age = 0;
		//age = fnac.restarFechas();
		return age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFnac() {
		return fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

}
