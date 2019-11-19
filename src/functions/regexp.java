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
	
	
	//VALIDAR DNI
	public static boolean validateDNI(String dni) {
		 
        
        String letraMayuscula = ""; //Guardaremos la letra introducida en formato may�scula
             
        // Aqu� excluimos cadenas distintas a 9 caracteres que debe tener un dni y tambi�n si el �ltimo caracter no es una letra
        if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false ) {
            return false;
        }
 
         
        // Al superar la primera restricci�n, la letra la pasamos a may�scula
        letraMayuscula = (dni.substring(8)).toUpperCase();
 
        // Por �ltimo validamos que s�lo tengo 8 d�gitos entre los 8 primeros caracteres y que la letra introducida es igual a la de la ecuaci�n
        // Llamamos a los m�todos privados de la clase soloNumeros() y letraDNI()
        if(soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
            return true;
        }
        else {
            return false;
        }
    }
 
        private static boolean soloNumeros(String dni) {
 
            int i, j = 0;
            String numero = ""; // Es el n�mero que se comprueba uno a uno por si hay alguna letra entre los 8 primeros d�gitos
            String miDNI = ""; // Guardamos en una cadena los n�meros para despu�s calcular la letra
            String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
 
            for(i = 0; i < dni.length() - 1; i++) {
                numero = dni.substring(i, i+1);
 
                for(j = 0; j < unoNueve.length; j++) {
                    if(numero.equals(unoNueve[j])) {
                        miDNI += unoNueve[j];
                    }
                }
            }
 
            if(miDNI.length() != 8) {
                return false;
            }
            else {
                return true;
            }
        }
 
        private static String letraDNI(String dni) {
        // El m�todo es privado porque lo voy a usar internamente en esta clase, no se necesita fuera de ella
 
        // pasar miNumero a integer
        int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
 
        resto = miDNI % 23;
 
        miLetra = asignacionLetra[resto];
 
        return miLetra;
    }
}
