import java.security.cert.PKIXRevocationChecker.Option;

public class Main {
	enum Options {
		CALC,
		TEST
	}
	
	// Que asco de código
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("El programa necesita un argumento.");
			System.out.println("Pruebe con uno de los siguientes:");
			
			for (Options op : Options.values()) {
				System.out.printf(" - %s\n", op.toString().toLowerCase());
			}
			
			System.exit(1);
		}
		
		String optionArg = args[0].trim();
		
		if (optionArg.length() < 4) {
			System.err.println("El argumento es muy corto. Cuatro caracteres mínimo.");
			System.exit(1);
		}
		
		optionArg = optionArg.substring(0, 4).toUpperCase();
		
		Options option;
		
		try {
			option = Options.valueOf(optionArg);
		} catch (Throwable e) {
			String closestOption = null;
			int closestDistance = 0;
			
			for (Options op : Options.values()) {
				String string = op.toString();
				int distance = stringDistance(string, optionArg);
				
				if (closestOption == null || distance < closestDistance) {
					closestOption = string;
					closestDistance = distance;
				}
			}
			
			System.out.println("Argumento desconocido.");
			
			if (closestOption != null && closestDistance < 3) {
				System.out.printf("¿Querías decir '%s'?\n", closestOption.toLowerCase());
			}
			
			return;
		}
		
		switch (option) {
			case CALC: {
				Calculadora calculadora = new Calculadora();
				calculadora.main();
				break;
			}

			case TEST: {
				Test test = new Test();
				try {
					test.main();
				} catch (Throwable exception) {
					System.err.println(exception.getMessage());
				}
				break;
			}

			default: {
				System.out.println("Sin implementación.");
				break;
			}
		}
	}
	
	static int stringDistance(String a, String b) {
		int distance = a.length() - b.length();
		int minLength = Math.min(a.length(), b.length());
		
		for (int i = 0; i < minLength; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				distance++;
			}
		}
		
		return distance;
	}
}
