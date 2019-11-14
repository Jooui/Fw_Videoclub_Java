package modules.products.templates;

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
		String getName = "", getStock = "", getPrice = "", getRating = "", getDate = "", getDuration = "", getSynopsis = "", errorText = "";
		int getPriceInt = 0, getDurationInt = 0, getStockInt = 0;
		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField stock = new JTextField();
		JTextField rating = new JTextField();
		JTextField date = new JTextField();
		JTextField duration = new JTextField();
		JTextArea synopsis = new JTextArea(6,25);
		JScrollPane scrollSynpsis = new JScrollPane(synopsis);
		
		Object[] message = {
		    "Create New Film\n\nName: ", name,
		    "Price:", price,
		    "Stock:", stock,
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
				stock.setText("23");
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
					
				getName = name.getText();
				if (getName.isEmpty()) {
					name.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Name can't be empty\n");
				} else {
					name.setBorder(borderBlack);
				}
				
				getPrice = price.getText();
				if (functions.isNumeric(getPrice)==false) {
					error = true;
					price.setBorder(borderRed);
					errorText = errorText + ("Put a correct price. Ex: 20\n");
				} else {
					getPriceInt = Integer.parseInt(getPrice);
					price.setBorder(borderBlack);
				}
				
				getStock = stock.getText();
				if (functions.isNumeric(getStock)==false) {
					error = true;
					stock.setBorder(borderRed);
					errorText = errorText + ("Put a correct stock. Ex: 23\n");
				} else {
					getStockInt = Integer.parseInt(getStock);
					stock.setBorder(borderBlack);
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
				}
				
				getSynopsis = synopsis.getText();
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getName, getPriceInt, getStockInt, getRatingDouble, dateObj, getDurationInt, getSynopsis);
			result.addAll(list);
			
			
			return result;
			
	}
	
	public static ArrayList<Object> gameForm() {
		
		String[] choice = {"Create","Cancel"};
		String[] typePlatforms = { "PS3", "PS4", "XBox 360", "XBox One", "Nintendo Switch", "Nintendo DS", "Nintendo WII", "PC" };
		boolean error = false;
		ArrayList<Object> result = new ArrayList<Object>();
		Date dateObj = null;
		int option = 0;
		double getRatingDouble = 0.0;
		String getName = "", getPrice = "", getStock = "", getRating = "", getDate = "", getPlatform = "", errorText = "";
		int getPriceInt = 0, getStockInt = 0;
		Border borderRed = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderBlack = new JTextField().getBorder();

		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField stock = new JTextField();
		JTextField rating = new JTextField();
		JTextField date = new JTextField();
		JComboBox<String> platformCombo = new JComboBox<>(typePlatforms);
			
		
		Object[] message = {
		    "Create New Game\n\nName: ", name,
		    "Price:", price,
		    "Stock:", stock,
		    "Rating:", rating,
		    "Release date:", date,
		    "Platform:", platformCombo,

		};
			
			do {
				errorText = "";
				error = false;
				name.setText("Call of Duty"); //clean the inputs.
				price.setText("50");
				stock.setText("13");
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
				
				getName = name.getText();
				if (getName.isEmpty()) {
					name.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Name can't be empty\n");
				} else {
					name.setBorder(borderBlack);
				}
				
				System.out.println("creategame");
				getPrice = price.getText();
				if (functions.isNumeric(getPrice)==false) {
					price.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct price. Ex: 20\n");
				} else {
					price.setBorder(borderBlack);
					getPriceInt = Integer.parseInt(getPrice);
				}
				
				getStock = stock.getText();
				if (functions.isNumeric(getStock)==false) {
					error = true;
					stock.setBorder(borderRed);
					errorText = errorText + ("Put a correct stock. Ex: 23\n");
				} else {
					getStockInt = Integer.parseInt(getStock);
					stock.setBorder(borderBlack);
				}
				
				getRating = rating.getText();
				if (functions.isDouble(getRating)==false) {
					error = true;
					rating.setBorder(borderRed);
					errorText = errorText + ("Put a correct rating. Ex: 4.5\n");
				} else {
					rating.setBorder(borderBlack);
					getRatingDouble = Double.parseDouble(getRating);
				}
				
				getDate = date.getText();
				if (regexp.validateDate(getDate)==false) {
					error = true;
					date.setBorder(borderRed);
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}else {
					date.setBorder(borderBlack);
					dateObj = new Date(getDate);
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
			List<Object> list = Arrays.asList( getName, getPriceInt, getStockInt, getRatingDouble, dateObj, getPlatform);
			result.addAll(list);
			
			
			return result;
			
	}
	
	public static ArrayList<Object> musicForm() {
		String[] choice = {"Create","Cancel"};
		boolean error = false;
		ArrayList<Object> result = new ArrayList<Object>();
		int option = 0;
		double getRatingDouble = 0.0;
		String getName = "", getPrice = "", getStock = "", getRating = "", getDate = "", getDuration = "", getArtist = "", errorText = "";
		int getPriceInt = 0, getDurationInt = 0, getStockInt = 0;
		Border borderRed = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderBlack = new JTextField().getBorder();

		Date dateObj = null;
		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField stock = new JTextField();
		JTextField rating = new JTextField();
		JTextField date = new JTextField();
		JTextField duration = new JTextField();
		JTextField artist = new JTextField();
		
		Object[] message = {
		    "Create New Music Disc\n\nName: ", name,
		    "Artist:", artist,
		    "Price:", price,
		    "Stock:", stock,
		    "Rating:", rating,
		    "Release date:", date,
		    "Duration:", duration,
		};
			
			do {
				errorText = "";
				error = false;
				name.setText("Estopa (Album)"); //clean the inputs.
				price.setText("8");
				stock.setText("44");
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
				if (getName.isEmpty()) {
					name.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Name can't be empty\n");
				} else {
					name.setBorder(borderBlack);
				}
				
				getPrice = price.getText();
				if (functions.isNumeric(getPrice)==false) {
					price.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct price. Ex: 20\n");
				} else {
					price.setBorder(borderBlack);
					getPriceInt = Integer.parseInt(getPrice);
				}
				
				getRating = rating.getText();
				if (functions.isDouble(getRating)==false) {
					rating.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct rating. Ex: 4.5\n");
				} else {
					rating.setBorder(borderBlack);
					getRatingDouble = Double.parseDouble(getRating);
				}
				
				getDate = date.getText();
				if (regexp.validateDate(getDate)==false) {
					error = true;
					date.setBorder(borderRed);
					errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
				}else {
					date.setBorder(borderBlack);
					dateObj = new Date(getDate);
				}
				
				getDuration = duration.getText();
				if (functions.isNumeric(getDuration)==false) {
					duration.setBorder(borderRed);
					error = true;
					errorText = errorText + ("Put a correct duration. Ex: 117\n");
				} else {
					duration.setBorder(borderBlack);
					getDurationInt = Integer.parseInt(getDuration);
				}
				
				getArtist = artist.getText();
				if (error == true) {
					JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(error == true);
			List<Object> list = Arrays.asList( getName, getPriceInt, getStockInt, getRatingDouble, dateObj, getDurationInt, getArtist);
			result.addAll(list);
					
			return result;
			
	}
}
