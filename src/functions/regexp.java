package functions;

public class regexp {
	public static boolean validateDate(String fecha){
		if (fecha == null) return false;
		return fecha.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
	}	
	
	public static boolean validateTlfEsp(String tlf){
		if (tlf == null) return false;
		return tlf.matches("^(\\+34|0034|34)?[6789]\\d{8}$");
	}	

	public static boolean validateEmail(String email){
		if (email == null) return false;
		return email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
	}	

	/*public static boolean validateEuro(String fecha){
		if (fecha == null) return false;
		return fecha.matches("/((?:[0-9]*[.,])?[0-9]+)\p{Sc}/u");
		^([0-2][0-9]|(3)[0-1])(\/|\-|\|)(((0)[0-9])|((1)[0-2]))(\/|\-|\|)\d{4}$
	}	*/
}
