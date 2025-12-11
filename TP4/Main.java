import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String palabra1;
		String palabra2;
		
		System.out.println("Ingrese la primera palabra");
		palabra1 = scanner.nextLine().trim();
		
		System.out.println("Ingrese la segunda palabra");
		palabra2 = scanner.nextLine().trim();
		
		if (sonIguales(palabra1, palabra2)) {
			System.out.println("Son la misma palabra.");
		} else {
			System.out.println("Son distintas palabras.");
		}
	}
	
	public static boolean sonIguales(String cadena1, String cadena2) {
		if (cadena1.length() != cadena2.length()) {
			return false;
		}
		
		// Itéra por cada letra de ambas cadenas y compara una por una.
		for (int i = 0; i < cadena1.length(); i++) {
			if (cadena1.charAt(i) != cadena2.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
}
