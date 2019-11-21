package functions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.Integer;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.*;
import functions.translations;
import dashboard.*;

import modules.products.classes.*;
import modules.users.classes.Admin;
import modules.users.classes.Partner;

public class functions {
	
	public static String transalte(String wordForTranslate) {
		String translated = "";
		String[] translateData = translations.translationsWords();
		for (int i = 0; i < translateData.length; i+=2) {
			if (translateData[i].matches(wordForTranslate)) {
				translated = translateData[(i+1)];
			}
		}
		
		return translated;
	}
	
	
		private static final char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M',
	            'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
	            'L', 'C', 'K', 'E' };
	    public static String generateDni(String seed) {
	        if (seed != null) {
	            try {
	                Integer.parseInt(seed);
	            } catch (NumberFormatException ex) {
	                return "KO";
	            }
	        } else {
	            seed = "";
	        }
	        String numeroDNI = String.valueOf(Math.random()).concat(seed);
	        String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

	        int dniInt = Integer.valueOf(fullDNI);
	        fullDNI = fullDNI + LETRAS_NIF[dniInt % 23];
	        return fullDNI;
	}
	
	
	
	
	public static boolean validateInstaceof(Object obj,String type) {
		boolean correct = false;
		if (type == "Film") {
			if (obj instanceof Film) {
				correct = true;
			}
		}
		
		if (type == "Game") {
			if (obj instanceof Game) {
				correct = true;
			}
		}
		
		if (type == "Music") {
			if (obj instanceof MusicDisc) {
				correct = true;
			}
		}
		
		if (type == "Partner") {
			if (obj instanceof Partner) {
				correct = true;
			}
		}
		if (type == "Admin") {
			if (obj instanceof Admin) {
				correct = true;
			}
		}
		return correct;
	}
	
	//Create a window with two inputs to request two numbers in the same window. Returns a Integer array with the two numbers.
	public static Integer[] doubleNumberVerified(String text_window, String title_window, String text_number1, String text_number2) {
		
		//declare variables
		String[] choice = {"Accept","Cancel"};
		boolean isnumeric = false;
		int option = 0;
		String str1 = "", str2 = "", text = "";
		Integer[] numbers = new Integer[2];
		JTextField number1 = new JTextField();//Generar input 1 (Num1)
		JTextField number2 = new JTextField();//Generar input 2 (Num2)
		if (text_window == null) text_window = "Enter two integers"; //if: Si no se indica ningun texto de ventana, se usará el predeterminado.
		if (title_window == null) title_window = "Numbers "; //if: Si no se indica ningun titulo de ventana, se usará el predeterminado.
		if (text_number1 == null) text_number1 = "Number 1: "; //if: Texto que aparecer� junto al n�mero 1.
		if (text_number2 == null) text_number2 = "Number 2: "; //if: texto que aparecer� junto al n�mero 2.
		text = text_window+"\n\n"+text_number1;
		Object[] message = {
		    text, number1,
		    text_number2, number2
		};
			
			do {
				number1.setText(""); //clean the inputs.
				number2.setText("");
				
				//call OptionDialog with last parameters that we set.
				option = JOptionPane.showOptionDialog(null, message,title_window,0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
				if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
					isnumeric = true;
					return null;
				}
					
				str1 = number1.getText();//Obtener la informaci�n de los inputs
				str2 = number2.getText();
				
				if (functions.isNumeric(str1) && functions.isNumeric(str2)) {//compueba que los dos inputs sean numeros y convierte las variables a integer
					isnumeric = true;
					numbers[0] = Integer.parseInt(str1);//assign each number to a position in the return array
					numbers[1] = Integer.parseInt(str2);
					
					return numbers;
				} else { //error if they aren't numbers
					JOptionPane.showMessageDialog(null, "You haven't entered a number", "Error",JOptionPane.ERROR_MESSAGE);
					isnumeric = false;
				}
			} while (isnumeric == false); //while the two paramenters aren't numbers, the function will repeat. 
		
			return null;
	}
	
	public static Integer numberVerified(String text_window, String title_window) { //Create a window to request one number. Returns Integer
		
		//declare variables
		String num_try = "";
		int num = 0;
		boolean correct = false;
		do{
			try{
				if (text_window == null) text_window = "Enter an integer"; //if: Si no se indica ningun texto de ventana, se usará el predeterminado.
				if (title_window == null) title_window = "Number "; //if: Si no se indica ningun titulo de ventana, se usará el predeterminado.
				num_try=JOptionPane.showInputDialog(null, text_window,title_window,JOptionPane.QUESTION_MESSAGE);
				if(num_try==null){//Si el usuario pulsa cancelar se sale de la aplicación
					correct=true;
					return null;
				}else {
					num=Integer.parseInt(num_try); //If it isn't a number, an exception is created. Go to catch
					correct=true;
				}
			}catch(Exception e){ //error message
				JOptionPane.showMessageDialog(null, "You haven't entered an integer", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return num;
	}
	
	public static Integer[] digits(int number) { //get digits of a number. Returns array.
		int array_length = 0;
		array_length = String.valueOf(number).length(); //get how many digits have the number
		if (number < 0) array_length = (array_length-1); //if it is negative, we substract one because we don't want count the sign
		Integer[] digits = new Integer[array_length]; //create an array with number's lenght
		int num = number;
		for (int i = 0; i < digits.length; i++) { //extract the digits and put it in the return's array (digits).
			digits[i] = num%10;
			num = num/10;	
		}
		
		return digits;
	}
	
	public static Integer[] dividers(int number) { //get dividers of a number. Returns array.
		int num = number, cont = 0, cont2 = 0;
		
		for (int i = 1; i <= num; i++) { //first count how much dividers has the number for declare the array
			if (num % i == 0) {
				cont++;
			}
		}
		
		Integer[] dividers = new Integer[cont]; //create the Integer Array with the divider's lenght (cont).
		
		for (int x = 1; x <= num; x++) { //assign each divider to the return array (dividers).
			if ((num % x) == 0) {
				dividers[cont2] = x;
				cont2++;
			}
		}
		
		
		return dividers;
	}
	
	
	
	
	public static Integer numberPositiveVerified(String text_window, String title_window) { //Create a window to request one Positive number. Returns int.
		
		//declare variables.
		String num_try = "", error_title = "You haven't entered an integer";
		Integer num = 0;
		boolean correct = false;
		do{
			try{
				error_title = "You haven't entered an integer";
				if (text_window == null) text_window = "Enter a positive integer"; //if: Si no se indica ningun texto de ventana, se usará el predeterminado.
				if (title_window == null) title_window = "Number "; //if: Si no se indica ningun titulo de ventana, se usará el predeterminado.
				num_try=JOptionPane.showInputDialog(null, text_window,title_window,JOptionPane.QUESTION_MESSAGE);
				if(num_try==null){//Si el usuario pulsa cancelar se sale de la aplicación
					num = null;
					correct = true;
				}else {
					num=Integer.parseInt(num_try);
					correct=true;
					if (num <= 0) {
						error_title = "You haven't entered a positive number";
						throw new Exception(); //create exception to show the error.
					}
				}
			}catch(Exception e){//error message
				JOptionPane.showMessageDialog(null, error_title, "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return num;
	}
	
	
	public static void menu(String[] options, String[] functionsName, String text_window, String title_window) { //menu function. The exercices path must be "exercices" (or change the class on the method)
		Integer option = 0;														//options[] are the names of the different options, and exercices[] are the functions that you wanna call.
		String opt = "";
		boolean confirm = false;
		do{
		
			option = functions.buttonsMenu(options, text_window, title_window); //call the function where the OptionDialog will be called.
			if (option == null)return;
			opt = functionsName[(option)];//assign to opt the name of the function that you will call
						
			try { //calling the methods using variables names.
				Method method = home.class.getDeclaredMethod(opt); //create method calling the function that we choosed.
					
	            try {
            		method.invoke(null); //invoke the function
	            } catch (InvocationTargetException e) {
	                throw new RuntimeException(e);
	            }

	       } catch (NoSuchMethodException e) {
	           throw new RuntimeException(e);
	       } catch (IllegalAccessException e) {
	            throw new RuntimeException(e);
	       }
			
		}while(confirm == false);
	}
	public static void secondaryMenu(String[] options, String[] functionsName, String text_window, String title_window, String type, String moduleName, String className) { //menu function. The exercices path must be "exercices" (or change the class on the method)
		Integer option = 0;														//options[] are the names of the different options, and exercices[] are the functions that you wanna call.
		String opt = "";
		boolean confirm = false;
		do{
		
			option = functions.secondaryButtonsMenu(options, text_window, title_window); //call the function where the OptionDialog will be called.
			if (option == null) return;
			opt = functionsName[(option)];//assign to opt the name of the function that you will call
			
			try { //calling the methods using variables names.
				Class<?> clazz = Class.forName("modules."+moduleName+".functions."+className); 
				Method method = clazz.getDeclaredMethod(opt, String.class); //create method calling the function that we choosed.
					System.out.println("ENTRA AL SECONDARY MENU");
	            try {
	            		method.invoke(null, type); //invoke the function
	            } catch (InvocationTargetException e) {
	                throw new RuntimeException(e);
	            }

	       } catch (NoSuchMethodException e) {
	           throw new RuntimeException(e);
	       } catch (IllegalAccessException e) {
	            throw new RuntimeException(e);
	       } catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
			
		}while(confirm == false);
	}
	
	public static boolean isGetter(Method method){
        // identify get methods
        if((method.getName().startsWith("get") || method.getName().startsWith("is")) 
          && method.getParameterCount() == 0 && !method.getReturnType().equals(void.class)){
            return true;
        }
        return false;    
    }
    
    public static boolean isSetter(Method method){
        // identify set methods
        if(method.getName().startsWith("set") && method.getParameterCount() == 1 
          && method.getReturnType().equals(void.class)){
            return true;
        }
        return false;    
    }
	
	public static Integer buttonsMenu(String[] options, String window_text, String window_title){ //the buttons Menu that will appear when we call menuUpgraded.
		
		//String[] options2 = new String[options.length+1]; //create array with length +1 because we need exit button.
		
		if (window_text == null) window_text = "Main menu\n\nSelect an option";//if: Si no se indica ningun texto de ventana, se usará el predeterminado.
		if (window_title == null) window_title = "Menu";//if: Si no se indica ningun titulo de ventana, se usará el predeterminado.
		


		Integer option=JOptionPane.showOptionDialog(null, window_text, window_title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		if (option == -1) return null;;//if: close the window
		if (options[option] == "Exit") System.exit(0);//if: press exit button
		if (options[option] == "Back")return null;
		return option;
	}
	
	public static Integer secondaryButtonsMenu(String[] options, String window_text, String window_title){ //the buttons Menu that will appear when we call menuUpgraded.
		
		String[] options2 = new String[options.length+1]; //create array with length +1 because we need exit button.
		
		if (window_text == null) window_text = "Main menu\n\nSelect an option";//if: Si no se indica ningun texto de ventana, se usará el predeterminado.
		if (window_title == null) window_title = "Menu";//if: Si no se indica ningun titulo de ventana, se usará el predeterminado.
		for (int i = 0; i < options2.length; i++) { //create Exit button.
			if (i == (options2.length-1)) {
				options2[i] = "Back";
			}else {
				options2[i] = options[i];
			}
		}

		Integer option=JOptionPane.showOptionDialog(null, window_text, window_title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
		if (option == -1) return null;//if: close the window
		if (option == (options2.length-1)) return null;//if: press exit button
		return option;
	}
	
	public static boolean confirm(String exercice) { //menu for confirm if wanna repeat the exercices on menuUpgraded
		boolean continue_ = false;
		int option = 0;
		String[] options = {exercice,"Back", "Exit"};
		
		option = JOptionPane.showOptionDialog(null, "Do you wanna repeat??", exercice, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		
		if (option == 0) continue_ = true;//return 0 and repeat the exercice
		if (option == 1) continue_ = false;//return 1 and don't repeat the exercice
		if (option == 2) System.exit(0); //press Exit will finish the programm
		return continue_;

	}
	
	public static String comboMenu(String[] options, String window_text, String window_title){ //drop down menu.
		
		if (window_text == null) window_text = "Main menu\n\nSelect an option";//if: Si no se indica ningun texto de ventana, se usará el predeterminado.
		if (window_title == null) window_title = "Menu";//if: Si no se indica ningun titulo de ventana, se usará el predeterminado.
		
		Object option=JOptionPane.showInputDialog(null, window_text, window_title, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (option == null) return null;
		
		return option.toString();
	}
	
	public static boolean isNumeric(String number) { //check if the number is numeric. Returns true or false
        boolean result;
        try {
            Integer.parseInt(number); //if isn't a number, fails and go to the exception.
            result = true;
        } catch (Exception e) {
        	result = false;
        }

        return result;
    }
	public static boolean isDouble(String number) { //check if the number is numeric. Returns true or false
        boolean result;
        try {
            Double.parseDouble(number); //if isn't a number, fails and go to the exception.
            result = true;
        } catch (Exception e) {
        	result = false;
        }

        return result;
    }
	
	public static boolean isNumericChar(Character number) { //receive one number like character.
        boolean result;
        try {
        	String num = "" + number;
        	Integer.parseInt(num);
            result = true;
        } catch (Exception e) {
        	result = false;
        }

        return result;
    }
	
	public static char oneLetterVerified(String text_window, String title_window) { //Create window to request only ONE letter. Returns char
		char character = 'a';
		String letter;
		boolean correcto=true;

		do{
			try{
				if (text_window == null) text_window = "Write one letter"; //if: Si no se indica ningun texto de ventana, se usará el predeterminado.
				if (title_window == null) title_window = "Letter "; //if: Si no se indica ningun titulo de ventana, se usará el predeterminado.
				letter=JOptionPane.showInputDialog(null, text_window,title_window,JOptionPane.QUESTION_MESSAGE);
				
				if(letter==null){
					JOptionPane.showMessageDialog(null, "Exiting...","Exit...",JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
				}else {
					if (letter.length() > 1 || isNumeric(letter) == true){
						throw new Exception();
				    }
					character=letter.charAt(0);
					correcto=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You haven't entered a letter", "Error",JOptionPane.ERROR_MESSAGE);
				correcto=false;
			}
		}while(correcto==false);
		return character;
	}
	
	public static String removeLastChar(String str) { //Elimina el ultimo caracter de una cadena/string. Return String.
		str = str.substring(0, str.length() - 1);
		return str;
	}
}