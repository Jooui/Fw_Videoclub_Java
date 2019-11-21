package modules.products.functions;

import modules.products.classes.*;
import modules.products.templates.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import classes.*;

import functions.*;

public class Product_CRUD {

	public static void createProduct(String type) {//CREATE NEW PRODUCT
		Product product = null;
		ArrayList<Object> properties = new ArrayList<Object>();
		if (type == "Film") { // create new Film
			properties = Forms.filmForm(null);
			if (properties == null)return;
			product = new Film((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (int) properties.get(5), (String) properties.get(6));

		} else if (type == "Game") { // create new Game
			properties = Forms.gameForm(null);

			if (properties == null)return;
			product = new Game((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (String) properties.get(5));
			
		} else if (type == "Music") { // create new MusicDisc
			properties = Forms.musicForm(null);
			if (properties == null)return;
			product = new MusicDisc((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (int) properties.get(5), (String) properties.get(6));
		}
		Singleton.products.add(product);
	}

	public static void showProducts(String type) {
		//ArrayList<Integer> positions = new ArrayList<Integer>();
		//positions = null;
		String result = "";
		for (int i = 0; i < Singleton.products.size(); i++) {
			if (functions.validateInstaceof(Singleton.products.get(i), type) == true) {
				result = result + (Singleton.products.get(i).toString()+"\n");
			}
		}
		if (result.isEmpty())result = "There aren't any movie";
		JOptionPane.showMessageDialog(null, result);
	}
	
	public static void editProduct(String type) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		String result = "Choose the "+type+" you want to edit: \n\n";
		Integer cont = 0, selected;
		Product product1 = null;
		boolean correct = false;

		ArrayList<Object> properties = new ArrayList<Object>();
		for (int i = 0; i < Singleton.products.size(); i++) {
			if (functions.validateInstaceof(Singleton.products.get(i), type) == true) {
				cont++;
				result = result + (cont+" - "+Singleton.products.get(i).getName()+"\n");
				positions.add(i);
			}
		}
		do {
			if (cont == 0) {
				JOptionPane.showMessageDialog(null, "There aren't any movie");
				return;
			}
			selected = functions.numberPositiveVerified(result, "Edit "+type);
			if (selected == null) return;
			if (selected > cont) {
				JOptionPane.showMessageDialog(null, "Select a valid option!");
			} else {
				correct = true;
			}
		}while(correct == false);
		int getNumber = positions.get((selected-1));
		product1 = Singleton.products.get(getNumber);

		if (product1 instanceof Film) {
			properties = Forms.filmForm((Film) product1);
			if (properties == null) return;
			Film product = null;
			product = new Film((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (int) properties.get(5), (String) properties.get(6));
			Singleton.products.set(getNumber, product);
			return;
			
		}else if (product1 instanceof Game) {
			Game product = null;
			properties = Forms.gameForm((Game) product1);
			if (properties == null) return;

			product = new Game((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (String) properties.get(5));
			Singleton.products.set(getNumber, product);
			return;
			
		}else if (product1 instanceof MusicDisc) {
			MusicDisc product = null;
			properties = Forms.musicForm((MusicDisc) product1);
			if (properties == null) return;

			product = new MusicDisc((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (int) properties.get(5), (String) properties.get(6));
			Singleton.products.set(getNumber, product);
			return;
		}

	}
	
	public static void deleteProduct(String type) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		String result = "Choose the "+type+" you want to delete: \n\n";
		Integer cont = 0, selected;
		boolean correct = false;
		
		
		for (int i = 0; i < Singleton.products.size(); i++) {
			if (functions.validateInstaceof(Singleton.products.get(i), type) == true) {
				cont++;
				result = result + (cont+" - "+Singleton.products.get(i).getName()+"\n");
				positions.add(i);
			}
		}
		do {
			if (cont == 0) {
				JOptionPane.showMessageDialog(null, "There aren't any movie");
				return;
			}
			selected = functions.numberPositiveVerified(result, "Delete "+type);
			if (selected == null) return;
			if (selected > cont) {
				JOptionPane.showMessageDialog(null, "Select a valid option!");
			} else {
				correct = true;
			}
		}while(correct == false);
		int getNumber = positions.get((selected-1));
		Singleton.products.remove(getNumber);
	}
}










