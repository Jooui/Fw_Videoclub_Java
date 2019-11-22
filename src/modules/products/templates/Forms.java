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
import modules.products.classes.Film;
import modules.products.classes.Game;
import modules.products.classes.MusicDisc;

public class Forms {
	public static ArrayList<Object> filmForm(Film film) {
		
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
		
			
			do {
				errorText = "";
				error = false;
				if (film == null) {
					String[] choice = {"Create","Cancel"};
					Object[] message = {
						    "Create New Film\n\nName: ", name,
						    "Price:", price,
						    "Stock:", stock,
						    "Rating:", rating,
						    "Release date:", date,
						    "Duration:", duration,
						    "synopsis:", scrollSynpsis,
					};
					
					name.setText(""); //clean the inputs.
					price.setText("");
					stock.setText("");
					rating.setText("");
					date.setText("");
					duration.setText("");
					synopsis.setText("");	
					option = JOptionPane.showOptionDialog(null, message,"Add Film",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				}else {
					String[] choice = {"Edit","Cancel"};
					Object[] message = {
						    "Edit Film\n\nName: ", name,
						    "Price:", price,
						    "Stock:", stock,
						    "Rating:", rating,
						    "Release date:", date,
						    "Duration:", duration,
						    "synopsis:", scrollSynpsis,
					};
					
					name.setText(film.getName()); //clean the inputs.
					price.setText(""+film.getPrice());
					stock.setText(""+film.getStock());
					rating.setText(""+film.getRating());
					date.setText(""+film.getDate().getDate());
					duration.setText(""+film.getDuration());
					synopsis.setText(film.getSynopsis());
					option = JOptionPane.showOptionDialog(null, message,"Edit Film",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				}
				
				
				//call OptionDialog with last parameters that we set.
				
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
					if (dateObj.validafecha()==false) {
						error = true;
						date.setBorder(borderRed);
						errorText = errorText + ("Put a correct date. Ex: 27/10/2016\n");
					}
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
	
	public static ArrayList<Object> gameForm(Game game) {
		
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
			
		

			
			do {
				errorText = "";
				error = false;
				
				if (game == null) {
					String[] choice = {"Create","Cancel"};
					Object[] message = {
						    "Create New Game\n\nName: ", name,
						    "Price:", price,
						    "Stock:", stock,
						    "Rating:", rating,
						    "Release date:", date,
						    "Platform:", platformCombo,
					};
					
					name.setText(""); //clean the inputs.
					price.setText("");
					stock.setText("");
					rating.setText("");
					date.setText("");
					option = JOptionPane.showOptionDialog(null, message,"Add Game",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				}else {
					String[] choice = {"Edit","Cancel"};
					Object[] message = {
						    "Edit Game\n\nName: ", name,
						    "Price:", price,
						    "Stock:", stock,
						    "Rating:", rating,
						    "Release date:", date,
						    "Platform:", platformCombo,
					};
					
					name.setText(game.getName()); //clean the inputs.
					price.setText(""+game.getPrice());
					stock.setText(""+game.getStock());
					rating.setText(""+game.getRating());
					date.setText(""+game.getDate().getDate());
					platformCombo.setSelectedItem(game.getPlatform());
					option = JOptionPane.showOptionDialog(null, message,"Edit Game",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				}
				
				
				//call OptionDialog with last parameters that we set.
				//option = JOptionPane.showOptionDialog(null, message,"Add Game",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				
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
	
	public static ArrayList<Object> musicForm(MusicDisc music) {
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
			
			do {
				
				errorText = "";
				error = false;
				
				if (music == null) {
					String[] choice = {"Create","Cancel"};
					Object[] message = {
						    "Create New Music Disc\n\nName: ", name,
						    "Artist:", artist,
						    "Price:", price,
						    "Stock:", stock,
						    "Rating:", rating,
						    "Release date:", date,
						    "Duration:", duration,
					};
					
					name.setText(""); //clean the inputs.
					artist.setText("");
					price.setText("");
					stock.setText("");
					rating.setText("");
					date.setText("");
					duration.setText("");
					option = JOptionPane.showOptionDialog(null, message,"Add Music Disc",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				}else {
					String[] choice = {"Edit","Cancel"};
					Object[] message = {
							"Edit Music Disc\n\nName: ", name,
						    "Artist:", artist,
						    "Price:", price,
						    "Stock:", stock,
						    "Rating:", rating,
						    "Release date:", date,
						    "Duration:", duration,
					};
					
					name.setText(music.getName()); //clean the inputs.
					artist.setText(music.getArtist());
					price.setText(""+music.getPrice());
					stock.setText(""+music.getStock());
					rating.setText(""+music.getRating());
					date.setText(""+music.getDate().getDate());
					duration.setText(""+music.getDuration());
					option = JOptionPane.showOptionDialog(null, message,"Edit Music Disc",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				}
				
				//call OptionDialog with last parameters that we set.
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
				
				getStock = stock.getText();
				if (functions.isNumeric(getStock)==false) {
					error = true;
					stock.setBorder(borderRed);
					errorText = errorText + ("Put a correct stock. Ex: 23\n");
				} else {
					getStockInt = Integer.parseInt(getStock);
					stock.setBorder(borderBlack);
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
