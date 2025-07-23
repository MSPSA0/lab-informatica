import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option;
		
		System.out.println("Ingrese 1 para validar una contraseña.");
		System.out.println("Ingrese 2 para validar un número de teléfono.");
		
		option = Integer.parseInt(scanner.nextLine());
		
		switch (option) {
			case 1: {
				System.out.println();
				passwordValidation();
				break;
			}
			
			case 2: {
				System.out.println();
				telephoneValidation();
				break;
			}
		}
	}
	
	// Valida una contraseña utilizando su longitud y expresiones regulares (regex).
	// ¿Por qué regex? Porque me gusta regex.
	public static void passwordValidation() {
		boolean isValid = false;
		
		while (!isValid) {
			String password = JOptionPane.showInputDialog("Ingrese una contraseña");
			isValid = true;
			
			if (password.length() < 8) {
				System.out.println("La contraseña debe tener al menos 8 caracteres.");
				isValid = false;
			}
			
			if (!hasUpperCaseLetter(password)) {
				System.out.println("La contraseña debe tener al menos una mayúscula.");
				isValid = false;
			}
			
			if (!hasLowerCaseLetter(password)) {
				System.out.println("La contraseña debe tener al menos una minúscula.");
				isValid = false;
			}
			
			if (!hasNumber(password)) {
				System.out.println("La contraseña debe tener al menos un número.");
				isValid = false;
			}
			
			if (isValid) {
				System.out.println("La contraseña es válida!");
			} else {
				System.out.println("Intente otra vez.");
			}
			
			System.out.println();
		}
	}
	
	public static boolean hasUpperCaseLetter(String string) {
		Pattern pattern = Pattern.compile("[A-Z]");
		return pattern.matcher(string).find();
	}
	
	public static boolean hasLowerCaseLetter(String string) {
		Pattern pattern = Pattern.compile("[a-z]");
		return pattern.matcher(string).find();
	}
	
	public static boolean hasNumber(String string) {
		Pattern pattern = Pattern.compile("\\d");
		return pattern.matcher(string).find();
	}
	
	// Valida un número de teléfono usando su longitúd y la ayuda de regex.
	public static void telephoneValidation() {
		while (true) {
			String telephone = JOptionPane.showInputDialog("Ingrese un número de teléfono");
			
			// Quita todos los espacios vacíos.
			telephone = telephone.replaceAll("\\s", "");
			
			if (telephone.length() == 10) {
				System.out.println("El número parece válido!");
				break;
			} else {
				System.out.println("El número de teléfono es inválido. Debe tener exactamente 10 dígitos.");
			}
			
			System.out.println();
		}
	}
}
