import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option;
		
		System.out.println("Ingrese 1 para validar un nombre.");
		System.out.println("Ingrese 2 para validar una fecha.");
		
		option = Integer.parseInt(scanner.nextLine());
		
		switch (option) {
			case 1: {
				System.out.println();
				nameValidation();
				break;
			}
			
			case 2: {
				System.out.println();
				dateValidation();
				break;
			}
		}
	}
	
	// Valida un nombre completo utilizando regex.
	public static void nameValidation() {
		// Este patrón verifica que desde el inicio (^) hasta el final ($)
		// Solo pueda contener letras ([A-zÀ-ÿ]) o espacios en blanco (\s).
		Pattern pattern = Pattern.compile("^([A-zÀ-ÿ]|\\s)+$");
		
		while (true) {
			String name = JOptionPane.showInputDialog("Ingrese su nombre completo");
			
			if (name != null && pattern.matcher(name).find()) {
				System.out.println("El nombre es válido!");
				break;
			} else {
				System.out.println("El nombre contiene caracteres inválidos. Intente otra vez.");
			}
			
			System.out.println();
		}
	}
	
	// regex.
	public static void dateValidation() {
		// Este patrón se fija si hay tres grupos de números separados por '/'.
		// Los dos primeros grupos pueden tener uno o dos dígitos (\d?\d).
		// El último grupo debe tener estrictamente cuatro dígitos (\d\d\d\d).
		// El patrón permite tener espacios vacíos al inicio y al final de la cadena de texto.
		Pattern pattern = Pattern.compile("^\\s*(\\d?\\d)/(\\d?\\d)/(\\d\\d\\d\\d)\\s*$");
		int[] daysPerMonth = {
			31, // Enero
			28, // Febrero
			31, // Marzo
			30, // Abril
			31, // Mayo
			30, // Junio
			31, // Julio
			31, // Agosto
			30, // Septiembre
			31, // Octubre
			30, // Noviembre
			31, // Diciembre
		};
		
		while (true) {
			String date = JOptionPane.showInputDialog("Ingrese una fecha en el formato DD/MM/AAAA");
			
			if (date == null) {
				System.out.println("Se canceló la operación.");
				return;
			}
			
			Matcher matcher = pattern.matcher(date);
			
			if (matcher.find()) {
				int day = Integer.parseInt(matcher.group(1));
				int month = Integer.parseInt(matcher.group(2));
				int year = Integer.parseInt(matcher.group(3));
				
				System.out.printf("día: %d, mes: %d, año: %d\n", day, month, year);
				
				if (day < 1) {
					System.out.println("El día está fuera de rango.");
					continue;
				}
				
				if (month < 1 || month > 12) {
					System.out.println("El mes está fuera de rango.");
					continue;
				}
				
				// Cambia los días de febrero los años bisiestos.
				daysPerMonth[1] = isLeapYear(year) ? 29 : 28;
				
				if (day <= daysPerMonth[month - 1]) {
					System.out.println("La fecha es válida!");
					return;
				} else {
					System.out.println("El día está fuera de rango.");
					continue;
				}
			} else {
				System.out.println("La fecha no tiene el formato correcto!");
			}
		}
	}
	
	// Verifica si es año bisiesto.
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
