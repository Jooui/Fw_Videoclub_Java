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
			properties = Forms.filmForm();
			if (properties == null)return;
			product = new Film((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (int) properties.get(5), (String) properties.get(6));

		} else if (type == "Game") { // create new Game
			properties = modules.purchases.templates.Forms.createPurchase();

			if (properties == null)return;
			product = new Game((String) properties.get(0), (int) properties.get(1), (int) properties.get(2), (double) properties.get(3), (Date) properties.get(4), (String) properties.get(5));
			
		} else if (type == "Music") { // create new MusicDisc
			properties = Forms.musicForm();
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
		String result = "Choose the "+type+" you want to delete: \n\n", choice = "", opt = "", change = "";
		Integer cont = 0, selected, contPath = 0;
		Product product = null;
		boolean correct = false;
		ArrayList<String> seters = new ArrayList<String>();
		ArrayList<String> parameters = new ArrayList<String>();
		ArrayList<String> settersMother = new ArrayList<String>();
		ArrayList<String> settersDaught = new ArrayList<String>();
		
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
		product = Singleton.products.get(getNumber);
		Class<?> clazz = product.getClass();

		while (clazz != null) {
		    Method[] methods = clazz.getDeclaredMethods();
		    for (Method method : methods) { //OBTENER EL NOMBRE DE CADA SETTER DE LA CLASE HIJA Y MADRE
		    	if(functions.isSetter(method)){ 
	                seters.add(method.getName());
	                if (contPath == 0) {
                		settersDaught.add(method.getName());
                	}else {
                		settersMother.add(method.getName());
                	}
	                for (Class<?> p : method.getParameterTypes()) { //OBTENER EL TIPO DE PARAMETRO DE CADA SETTER
	                	
	                	parameters.add(p.getName());
	                }
	                
	            }
		    }
		    clazz = clazz.getSuperclass();
		    contPath++;
		}

		String[] setters = new String[seters.size()];
		String[] buttons_Setters = new String[seters.size()];
		
		for (int x = 0; x < setters.length; x++) {
			setters[x] = seters.get(x);
			buttons_Setters[x] = functions.transalte(seters.get(x));
		}
		
		boolean selectClass = false; //INTERRUPTOR PARA NO REALIZAR LA BUSQUEDA DE UN SETTER EN UNA CLASE HIJA EN CASO DE HABERLO ENCONTRADO EN LA MADRE
		Class<?> clazzProduct = null;
		choice = functions.comboMenu(buttons_Setters, type+" Information\n\n"+product.toString()+"\n\nWhat do you want to change", "Edit "+type);
		if (choice == null)return;
		
		int choiceIndex = Arrays.asList(buttons_Setters).indexOf(choice);
		String parameterType = "";
		opt = setters[choiceIndex];
		parameterType = parameters.get(choiceIndex);
		if (! opt.matches(".*BOX"))
			change = JOptionPane.showInputDialog(null, "Write your change","",JOptionPane.QUESTION_MESSAGE);
		else
			System.out.println("ES UN COMBO BOXXXXX");
		int changeInt = 0;
		try { //calling the methods using variables names.
			Method method = null;
			for (String string : settersMother) { // OBTENER DE QUE CLASE TIENE QUE BUSCAR EL SETTER (MADRE O HIJA)
				if(string.matches(opt)){
					clazzProduct = Class.forName("classes.Product"); 
					selectClass = true; //SI SE HA ENCONTRADO EL SETTER EN LA CLASE MADRE, NO SE EJECUTARA LA BUSQUEDA EN LA CLASE HIJA
					break;
				}
			}
			
			if (selectClass == false) {
				for (String string : settersDaught) { // OBTENER DE QUE CLASE TIENE QUE BUSCAR EL SETTER (MADRE O HIJA)
					if(string.matches(opt)){
						clazzProduct = product.getClass();
						break;
					}
				}
			}
			if (parameterType == "java.lang.String") {
				

				method = clazzProduct.getDeclaredMethod(opt, String.class); //create method calling the function that we choosed.
			} else if (parameterType == "int") {
				
				changeInt = Integer.parseInt(change);
				
				method = clazzProduct.getDeclaredMethod(opt, int.class); //create method calling the function that we choosed.
				
			} else if (parameterType == "double") {
				method = clazzProduct.getDeclaredMethod(opt, double.class); //create method calling the function that we choosed.
			}
				
            try {
            	if (parameterType == "java.lang.String") {
                	method.invoke(product, change); //invoke the function

    			} else if (parameterType == "int") {
                	method.invoke(product, changeInt); //invoke the function

    			} else if (parameterType == "double") {
                	method.invoke(product, change); //invoke the function

    			}
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

       } catch (NoSuchMethodException e) {
           throw new RuntimeException(e);
       } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
		e.printStackTrace();
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










