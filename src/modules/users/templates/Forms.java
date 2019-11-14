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

public class Forms {
	public static ArrayList<Object> filmForm() {
		String[] choice = {"Create","Cancel"};
		boolean error = false;
		ArrayList<Object> result = new ArrayList<Object>();
		Border borderRed = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderBlack = new JTextField().getBorder();

		Date dateObj = null;
		int option = 0;
		double getRatingDouble = 0.0;
		String getName = "", getPrice = "", getRating = "", getDate = "", getDuration = "", getSynopsis = "", errorText = "";
		int getPriceInt = 0, getDurationInt = 0;
		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField rating = new JTextField();
		JTextField date = new JTextField();
		JTextField duration = new JTextField();
		JTextArea synopsis = new JTextArea(6,25);
		JScrollPane scrollSynpsis = new JScrollPane(synopsis);
		
		Object[] message = {
		    "Create New Film\n\nName: ", name,
		    "Price:", price,
		    "Rating:", rating,
		    "Release date:", date,
		    "Duration:", duration,
		    "synopsis:", scrollSynpsis,
		};
			
			do {
				errorText = "";
				error = false;
				name.setText("Spiderman 2"); //clean the inputs.
				price.setText("10");
				rating.setText("4.5");
				date.setText("10/10/2010");
				duration.setText("117");
				synopsis.setText("descripcion-synopsis");
				
				//call OptionDialog with last parameters that we set.
				option = JOptionPane.showOptionDialog(null, message,"Add Film",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
					error = true;
					return null;
				}
					
				getName = name.getText();//Obtener la informaci�n de los inputs
				
				getPrice = price.getText();
				if (functions.isNumeric(getPrice)==false) {
					error = true;
					price.setBorder(borderRed);
					errorText = errorText + ("Put a correct price. Ex: 20\n");
				} else {
					getPriceInt = Integer.parseInt(getPrice);
					price.setBorder(borderBlack);
				}
				
				getRating = rating.getText();
				if (functions.isDouble(getRating)==false) {
					error = true;
					rating.setBorder(borderRed);
					errorText = errorText + ("Put a correct rating. Ex: 4.5\n");
				} else {
					getRatingDouble = Double.parseDouble(getRating);
					rating.setBorder(borderBlack);
				}
				
				getDate = date.getText();
				if (regexp.validateDate(getDate)==false) {
					error = true;
					date.setBorder(borderRed);
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}else {
					date.setBorder(borderBlack);
					dateObj = new Date(getDate);
					System.out.println(dateObj.toString());

				}
				
				getDuration = duration.getText();
				if (functions.isNumeric(getDuration)==false) {
					error = true;
					duration.setBorder(borderRed);
					errorText = errorText + ("Put a correct duration. Ex: 117\n");
				} else {
					getDurationInt = Integer.parseInt(getDuration);
					duration.setBorder(borderBlack);
					//SwingUtilities.updateComponentTreeUI( duration );


				}
				
				getSynopsis = synopsis.getText();
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getName, getPriceInt, getRatingDouble, dateObj, getDurationInt, getSynopsis);
			result.addAll(list);
			
			
			return result;
			
	}
	
	public static ArrayList<Object> gameForm() {
		
		String[] choice = {"Create","Cancel"};
		String[] typePlatforms = { "PS3", "PS4", "XBox 360", "XBox One", "Nintendo Switch", "Nintendo DS", "Nintendo WII", "PC" };
		boolean error = false;
		ArrayList<Object> result = new ArrayList<Object>();
		int option = 0;
		double getRatingDouble = 0.0;
		String getName = "", getPrice = "", getRating = "", getDate = "", getPlatform = "", errorText = "";
		int getPriceInt = 0;
		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField rating = new JTextField();
		JTextField date = new JTextField();
		JComboBox<String> platformCombo = new JComboBox<>(typePlatforms);
			
		
		Object[] message = {
		    "Create New Game\n\nName: ", name,
		    "Price:", price,
		    "Rating:", rating,
		    "Release date:", date,
		    "Platform:", platformCombo,

		};
			
			do {
				errorText = "";
				error = false;
				name.setText("Call of Duty"); //clean the inputs.
				price.setText("50");
				rating.setText("5.0");
				date.setText("10/10/2010");
				
				
				//call OptionDialog with last parameters that we set.
				option = JOptionPane.showOptionDialog(null, message,"Add Game",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				
				if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
					error = true;
					return null;
				}
				
				Object obj = platformCombo.getSelectedItem(); 
				String platform = String.valueOf(obj);
				
				getName = name.getText();//Obtener la informaci�n de los inputs
				System.out.println("creategame");
				getPrice = price.getText();
				if (functions.isNumeric(getPrice)==false) {
					error = true;
					errorText = errorText + ("Put a correct price. Ex: 20\n");
				} else {
					getPriceInt = Integer.parseInt(getPrice);
				}
				
				getRating = rating.getText();
				if (functions.isDouble(getRating)==false) {
					error = true;
					errorText = errorText + ("Put a correct rating. Ex: 4.5\n");
				} else {
					getRatingDouble = Double.parseDouble(getRating);
				}
				
				getDate = date.getText();
				if (regexp.validateDate(getDate)==false) {
					error = true;
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}
				
				getPlatform = platform;
				if (getPlatform == null) {
					error = true;
					errorText = errorText + ("Select one platform");
				}
				
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getName, getPriceInt, getRatingDouble, getDate, getPlatform);
			result.addAll(list);
			
			
			return result;
			
	}
	
	public static ArrayList<Object> musicForm() {
		String[] choice = {"Create","Cancel"};
		boolean error = false;
		ArrayList<Object> result = new ArrayList<Object>();
		int option = 0;
		double getRatingDouble = 0.0;
		String getName = "", getPrice = "", getRating = "", getDate = "", getDuration = "", getArtist = "", errorText = "";
		int getPriceInt = 0, getDurationInt = 0;
		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField rating = new JTextField();
		JTextField date = new JTextField();
		JTextField duration = new JTextField();
		JTextField artist = new JTextField();
		
		Object[] message = {
		    "Create New Music Disc\n\nName: ", name,
		    "Artist:", artist,
		    "Price:", price,
		    "Rating:", rating,
		    "Release date:", date,
		    "Duration:", duration,
		};
			
			do {
				errorText = "";
				error = false;
				name.setText("Estopa (Album)"); //clean the inputs.
				price.setText("8");
				rating.setText("4.7");
				date.setText("5/11/2013");
				duration.setText("47");
				artist.setText("Estopa");
				
				//call OptionDialog with last parameters that we set.
				option = JOptionPane.showOptionDialog(null, message,"Add Music Disc",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
					error = true;
					return null;
				}
					
				getName = name.getText();//Obtener la informaci�n de los inputs
				
				getPrice = price.getText();
				if (functions.isNumeric(getPrice)==false) {
					error = true;
					errorText = errorText + ("Put a correct price. Ex: 20\n");
				} else {
					getPriceInt = Integer.parseInt(getPrice);
				}
				
				getRating = rating.getText();
				if (functions.isDouble(getRating)==false) {
					error = true;
					errorText = errorText + ("Put a correct rating. Ex: 4.5\n");
				} else {
					getRatingDouble = Double.parseDouble(getRating);
				}
				
				getDate = date.getText();
				if (regexp.validateDate(getDate)==false) {
					error = true;
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}
				
				getDuration = duration.getText();
				if (functions.isNumeric(getDuration)==false) {
					error = true;
					errorText = errorText + ("Put a correct duration. Ex: 117\n");
				} else {
					getDurationInt = Integer.parseInt(getDuration);
				}
				
				getArtist = artist.getText();
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getName, getPriceInt, getRatingDouble, getDate, getDurationInt, getArtist);
			result.addAll(list);
			
			
			return result;
			
	}

	public static ArrayList<Object> adminForm() {
		ArrayList<Object> result = new ArrayList<Object>();

		String[] choice = {"Create","Cancel"};
		boolean error = false;
		int option = 0;
		Date dateObj = null;
		String getUsername = "", getPassword = "", getName = "", getFnac = "", getSurnames = "", getCity = "", getTlf = "" ,getPostalCode = "", errorText = "", getAddress = "", getEmail = "";
		int getTlfInt = 0;
		JTextField username = new JTextField();
		JTextField password = new JTextField();
		JTextField name = new JTextField();
		JTextField surnames = new JTextField();
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
				
				getPassword = password.getText();

				getName = name.getText();

				getSurnames = surnames.getText();

				getCity = city.getText();
				
				getPostalCode = postalCode.getText();

				getAddress = address.getText();

				getTlf = tlf.getText();
				if (regexp.validateTlfEsp(getTlf)==false) {
					error = true;
					errorText = errorText + ("Put a correct phone spanish number");
				} else {
					getTlfInt = Integer.parseInt(getTlf);
				}

				getEmail = email.getText();
				if (regexp.validateEmail(getEmail)==false) {
					error = true;
					errorText = errorText + ("Put a correct email\n");
				}

				getFnac = fnac.getText();
				if (regexp.validateDate(getFnac)==false) {
					error = true;
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}else {
					dateObj = new Date(getFnac);
					System.out.println(dateObj.toString());

				}
				
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getUsername, getPassword, getName, getSurnames, getCity, getPostalCode, getAddress, getEmail, dateObj, getTlfInt);
			result.addAll(list);
			
			
			return result;
	}
}
