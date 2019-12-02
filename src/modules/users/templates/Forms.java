package modules.users.templates;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import classes.Date;
import functions.functions;
import functions.regexp;
import modules.users.classes.Admin;

public class Forms {
	
	public static ArrayList<Object> adminForm() {
		ArrayList<Object> result = new ArrayList<Object>();
		Border borderRed = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderBlack = new JTextField().getBorder();
		String[] choice = {"Create","Cancel"};
		boolean error = false;
		int option = 0;
		Date dateObj = null;
		String getUsername = "", getPassword = "", getName = "", getFnac = "", getDni = "", getSurnames = "", getCity = "", getTlf = "" ,getPostalCode = "", errorText = "", getAddress = "", getEmail = "";
		int getTlfInt = 0;
		JTextField username = new JTextField();
		JTextField password = new JTextField();
		JTextField name = new JTextField();
		JTextField surnames = new JTextField();
		JTextField dni = new JTextField();
		JTextField city = new JTextField();
		JTextField postalCode = new JTextField();
		JTextField address = new JTextField();
		JTextField tlf = new JTextField();
		JTextField email = new JTextField();
		JTextField fnac = new JTextField();
		
		Object[] message = {
		    "Create New Admin\n\nUsername: ", username,
		    "Password:", password,
		    "Name:", name,
		    "Surnames:", surnames,
		    "DNI: ", dni,
		    "City:", city,
			"Postal Code:", postalCode,
			"Address:", address,
			"Phone Number:", tlf,
			"Email:", email,
			"Birth date:", fnac,
		};
			
			do {
				errorText = "";
				error = false;
				username.setText(""); //clean the inputs.
				password.setText("");
				name.setText("");
				surnames.setText("Surrname1 Surrname2");
				dni.setText("49267906C");
				city.setText("Ontinyent");
				postalCode.setText("46870");
				address.setText("C/ Sant Josep, 6");
				tlf.setText("665996125");
				email.setText("jrevertvila@gmail.com");
				fnac.setText("11/11/2011");
				
				//call OptionDialog with last parameters that we set.
				option = JOptionPane.showOptionDialog(null, message,"Create Admin",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
					error = true;
					return null;
				}
				getUsername = username.getText();//Obtener la informaci�n de los inputs
				if (getUsername.isEmpty()) {
					username.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Username can't be empty\n");
				} else {
					username.setBorder(borderBlack);
				}
				
				getPassword = password.getText();
				if (getPassword.isEmpty()) {
					password.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Password can't be empty\n");
				} else {
					password.setBorder(borderBlack);
				}
				
				getName = name.getText();
				if (getName.isEmpty()) {
					name.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Name can't be empty\n");
				} else {
					name.setBorder(borderBlack);
				}
				
				getSurnames = surnames.getText();
				if (getSurnames.isEmpty()) {
					surnames.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Surnames can't be empty\n");
				} else {
					surnames.setBorder(borderBlack);
				}
				
				getCity = city.getText();
				if (getCity.isEmpty()) {
					city.setBorder(borderRed);
					error = true;
					errorText = errorText + ("City can't be empty\n");
				} else {
					city.setBorder(borderBlack);
				}
				
				getPostalCode = postalCode.getText();
				if (getPostalCode.isEmpty()) {
					postalCode.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Postal Code can't be empty\n");
				} else {
					postalCode.setBorder(borderBlack);
				}
				
				getAddress = address.getText();
				if (getAddress.isEmpty()) {
					address.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Address can't be empty\n");
				} else {
					address.setBorder(borderBlack);
				}
				
				getTlf = tlf.getText();
				if (regexp.validateTlfEsp(getTlf)==false) {
					tlf.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct phone spanish number\n");
				} else {
					tlf.setBorder(borderBlack);
					getTlfInt = Integer.parseInt(getTlf);
				}
				
				getDni = dni.getText();
				if (regexp.validateDNI(getDni)==false) {
					dni.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct DNI\n");
				} else {
					dni.setBorder(borderBlack);
				}

				
				getEmail = email.getText();
				if (regexp.validateEmail(getEmail)==false) {
					email.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct email\n");
				}else {
					email.setBorder(borderBlack);
				}

				getFnac = fnac.getText();
				if (regexp.validateDate(getFnac)==false) {
					fnac.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}else {
					fnac.setBorder(borderBlack);
					dateObj = new Date(getFnac);
					System.out.println(dateObj.toString());
				}
				
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getUsername, getPassword, getName, getSurnames, getDni, getCity, getPostalCode, getAddress, getEmail, dateObj, getTlfInt);
			result.addAll(list);
			
			return result;
	}
	
	public static  ArrayList<Object> partnerForm() {
		ArrayList<Object> result = new ArrayList<Object>();

		String[] choice = {"Register","Cancel"};
		boolean error = false;
		int option = 0;
		Date dateObj = null;
		String getUsername = "", getPassword = "", getName = "", getFnac = "", getSurnames = "", getDni = "" ,getCity = "", getTlf = "" ,getPostalCode = "", errorText = "", getAddress = "", getEmail = "";
		int getTlfInt = 0;
		Border borderRed = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderBlack = new JTextField().getBorder();
		JTextField username = new JTextField();
		JTextField password = new JTextField();
		JTextField name = new JTextField();
		JTextField surnames = new JTextField();
		JTextField dni = new JTextField();
		JTextField city = new JTextField();
		JTextField postalCode = new JTextField();
		JTextField address = new JTextField();
		JTextField tlf = new JTextField();
		JTextField email = new JTextField();
		JTextField fnac = new JTextField();
		
		Object[] message = {
			"Register\n\nUsername: ", username,
			"Password:", password,
			"Name:", name,
		    "Surnames:", surnames,
		    "DNI: ", dni,
		    "City:", city,
			"Postal Code:", postalCode,
			"Address:", address,
			"Phone Number:", tlf,
			"Email:", email,
			"Birth date:", fnac,
		};
			
			do {
				errorText = "";
				error = false;
				username.setText("");
				password.setText("");
				name.setText("");
				surnames.setText("Surrname1 Surrname2");
				dni.setText("49267906C");
				city.setText("Ontinyent");
				postalCode.setText("46870");
				address.setText("C/ Sant Josep, 6");
				tlf.setText("665996125");
				email.setText("jrevertvila@gmail.com");
				fnac.setText("11/11/2011");
				
				//call OptionDialog with last parameters that we set.
				option = JOptionPane.showOptionDialog(null, message,"Create Partner",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
					error = true;
					return null;
				}

				getUsername = username.getText();//Obtener la informaci�n de los inputs
				if (getUsername.isEmpty()) {
					username.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Username can't be empty\n");
				} else {
					username.setBorder(borderBlack);
				}
				
				getPassword = password.getText();
				if (getPassword.isEmpty()) {
					password.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Password can't be empty\n");
				} else {
					password.setBorder(borderBlack);
				}
				
				getName = name.getText();
				if (getName.isEmpty()) {
					name.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Name can't be empty\n");
				} else {
					name.setBorder(borderBlack);
				}
				
				getSurnames = surnames.getText();
				if (getSurnames.isEmpty()) {
					surnames.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Surnames can't be empty\n");
				} else {
					surnames.setBorder(borderBlack);
				}

				getCity = city.getText();
				if (getCity.isEmpty()) {
					city.setBorder(borderRed);
					error = true;
					errorText = errorText + ("City can't be empty\n");
				} else {
					city.setBorder(borderBlack);
				}
				getPostalCode = postalCode.getText();
				if (getPostalCode.isEmpty()) {
					postalCode.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Postal Code can't be empty\n");
				} else {
					postalCode.setBorder(borderBlack);
				}
				getAddress = address.getText();
				if (getAddress.isEmpty()) {
					address.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Address can't be empty\n");
				} else {
					address.setBorder(borderBlack);
				}
				getTlf = tlf.getText();
				if (regexp.validateTlfEsp(getTlf)==false) {
					tlf.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct phone spanish number\n");
				} else {
					tlf.setBorder(borderBlack);
					getTlfInt = Integer.parseInt(getTlf);
				}
				
				getDni = dni.getText();
				if (regexp.validateDNI(getDni)==false) {
					dni.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct DNI\n");
				} else {
					dni.setBorder(borderBlack);
				}

				getEmail = email.getText();
				if (regexp.validateEmail(getEmail)==false) {
					email.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct email\n");
				}else {
					email.setBorder(borderBlack);
				}

				getFnac = fnac.getText();
				if (regexp.validateDate(getFnac)==false) {
					fnac.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}else {
					fnac.setBorder(borderBlack);
					dateObj = new Date(getFnac);
					System.out.println(dateObj.toString());

				}
				
				
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getUsername, getPassword, getName, getSurnames, getDni, getCity, getPostalCode, getAddress, getEmail, dateObj, getTlfInt);
			result.addAll(list);
			
			
			return result;
	}
}
