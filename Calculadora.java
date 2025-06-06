import java.util.Scanner;

class Calculadora {
	final String TITLE = "###### Calculdora ######\n\n";
	final String END = "------------------------";
	
	Scanner scanner;
	int actionIndex;
	
	// La lista de acciones de la calculadora.
	// Cada acción tiene una descripción corta y su función.
	Action[] actions = {
		new Action(
			"Salir",
			
			new Function() { public void call() {
				clear();
				System.out.println(END);
			}}
		),
		new Action(
			"Calcular área y perímetro de un círculo.",
			
			new Function() { public void call() {
				double radius;
				
				System.out.println("Ingrese el radio de un círculo.");
				
				while (true) {
					radius = requestDouble(Double.NaN);
					
					if (!Double.isNaN(radius)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				double area = Math.PI * radius * radius;
				double perimeter = Math.PI * radius * 2;
				
				System.out.printf("El área es ~%.2f y el perímetro es ~%.2f.\n", area, perimeter);
			}}
		),
		new Action(
			"Calcular hipotenusa.",
			
			new Function() { public void call() {
				double c1, c2;
				
				System.out.println("Ingrese un cateto.");
				
				while (true) {
					c1 = requestDouble(Double.NaN);
					
					if (!Double.isNaN(c1)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				System.out.println("Ingrese el otro cateto.");
				
				while (true) {
					c2 = requestDouble(Double.NaN);
					
					if (!Double.isNaN(c2)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				double hipotenusa = Math.sqrt(c1 * c1 + c2 * c2);
				
				System.out.printf("La hipotenusa de los catetos %.2f y %.2f es ~%.2f\n", c1, c2, hipotenusa);
			}}
		),
		new Action(
			"Calcular potencia.",
			
			new Function() { public void call() {
				double base, exponent;
				
				System.out.println("Ingrese una base.");
				
				while (true) {
					base = requestDouble(Double.NaN);
					
					if (!Double.isNaN(base)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				System.out.println("Ingrese un exponente.");
				
				while (true) {
					exponent = requestDouble(Double.NaN);
					
					if (!Double.isNaN(exponent)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				System.out.printf("El resultado de %.2f^%.2f es ~%.2f\n", base, exponent, Math.pow(base, exponent));
			}}
		),
		new Action(
			"Calcular raiz cuadrada.",
			
			new Function() { public void call() {
				double number;
				
				System.out.println("Ingrese una número.");
				
				while (true) {
					number = requestDouble(Double.NaN);
					
					if (!Double.isNaN(number)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				if (number < 0) {
					System.out.println("La raiz cuadrada de números negativos no está implementada.");
				} else {
					System.out.printf("La raiz cuadrada de %.2f es ~%.2f\n", number, Math.sqrt(number));
				}
			}}
		),
		new Action(
			"Calcular logaritmo.",
			
			new Function() { public void call() {
				double number;
				
				System.out.println("Ingrese una número.");
				
				while (true) {
					number = requestDouble(Double.NaN);
					
					if (!Double.isNaN(number)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				if (number == 0) {
					System.out.println("Infinito");
				} else if (number < 0) {
					System.out.println("El logaritmo de números neativos no está implementado.");
				} else {
					System.out.printf("El logaritmo natural de %.2f es ~%.2f, y el logaritmo en base 10 es ~%.2f\n", number, Math.log(number), Math.log10(number));
				}
			}}
		),
		new Action(
			"Calcular interés compuesto.",
			
			new Function() { public void call() {
				double amount;
				double interest;
				int years;
				
				System.out.println("Ingrese el monto principal (sin '$').");
				
				while (true) {
					amount = requestDouble(Double.NaN);
					
					if (!Double.isNaN(amount)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				System.out.println("Ingrese el porcentaje de la tasa de interés anual (sin '%').");
				
				while (true) {
					interest = requestDouble(Double.NaN);
					
					if (!Double.isNaN(interest)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				System.out.println("Ingrese la cantidad de años.");
				
				while (true) {
					years = requestInt(-1);
					
					if (years >= 0) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				System.out.printf("El monto final es ~%.2f\n", amount + amount * interest / 100 * years);
			}}
		),
		new Action(
			"Generar número aleatorio.",
			
			new Function() { public void call() {
				double min;
				double max;
				
				System.out.println("Ingrese el límite mínimo.");
				
				while (true) {
					min = requestDouble(Double.NaN);
					
					if (!Double.isNaN(min)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				System.out.println("Ingrese el límite máximo.");
				
				while (true) {
					max = requestDouble(Double.NaN);
					
					if (!Double.isNaN(max)) {
						break;
					}
					
					System.out.println("Ingrese un número válido.");
				}
				
				if (min > max) {
					double temp = min;
					min = max;
					max = temp;
				}
				
				System.out.printf("Entero aleatorio entre 1 y 100: %d\n", 1 + (int)(Math.random() * 100));
				System.out.printf("Decimal aleatorio entre 0 y 1: %.2f\n", Math.random());
				System.out.printf("Decimal aleatorio entre %.2f y %.2f: %.2f\n", min, max, min + Math.random() * (max - min));
			}}
		),
		new Action(
			"Tirar dados.",
			
			new Function() { public void call() {
				int diceA = 1 + (int)(Math.random() * 6);
				int diceB = 1 + (int)(Math.random() * 6);
				
				// Quería usar símbolos de dado, pero la terminal solo acepta ASCII.
				System.out.printf("El primer dado dió %d\n", diceA);
				System.out.printf("El segundo dado dió %d\n", diceB);
				System.out.printf("La suma es %d\n", diceA + diceB);
			}}
		)
	};
	
	public void main() {
		scanner = new Scanner(System.in);
		mainScreen();
	}
	
	void mainScreen() {
		while (true) {
			clear();
			System.out.println("Seleccione la acción.");
			
			for (int i = 0; i < actions.length; i++) {
				Action action = actions[i];
				
				System.out.println(i + " - " + action.description);
			}
			
			System.out.println();
			
			while (true) {
				actionIndex = requestInt(-1);
				
				if (actionIndex >= 0 && actionIndex < actions.length) {
					break;
				}
				
				System.out.println("Ingrese una opción válida.");
			}
			
			if (actionIndex == 0) {
				if (actions[0] != null && actions[0].method != null) {
					actions[0].method.call();
				}
				break;
			}
			
			clear();
			doAction();
		}
	}
	
	void printTitle() {
		System.out.println(TITLE);
	}
	
	void doAction() {
		Action action = actions[actionIndex];
		if (action != null) {
			if (action.method != null) {
				action.method.call();
			} else {
				System.out.println("Esta acción aun no está implementada.");
			}
			System.out.print("\nPresione ENTER para volver al menú.");
			scanner.nextLine();
		}
	}
	
	int requestInt(int _default) {
		try {
			return requestInt();
		} catch (Throwable t) {
			return _default;
		}
	}
	
	int requestInt() throws Throwable {
		System.out.print("> ");
		int result = Integer.parseInt(scanner.nextLine());
		System.out.println();
		return result;
	}
	
	double requestDouble(double _default) {
		try {
			return requestDouble();
		} catch (Throwable t) {
			return _default;
		}
	}
	
	double requestDouble() throws Throwable {
		System.out.print("> ");
		double result = Double.parseDouble(scanner.nextLine());
		System.out.println();
		return result;
	}
	
	void clear() {
		try {
			String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
			
			printTitle();
		} catch (Exception e) {
			System.out.println("\n\n");
		}
	}
	
	class Action {
		public String description;
		public Function method;
		
		Action(String description, Function method) {
			this.description = description;
			this.method = method;
		}
	}
	
	public interface Function {
		public void call();
	}
}
