import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Conductor> conductores = new ArrayList<>();
		boolean continuar = true; // Usado en el bucle.
		
		do {
			Conductor conductor;
			
			System.out.printf("- Ingrese los datos del conductor %d.\n", 1 + conductores.size());
			conductor = Conductor.pedirConductor(scanner);
			
			conductores.add(conductor);
			
			if (conductores.size() >= 3) {
				String respuesta;
				
				System.out.println("Continuar? (S/n)");
				respuesta = scanner.nextLine().trim();
				continuar = respuesta.equalsIgnoreCase("s");
			}
		} while (continuar);
		
		System.out.printf("\nLista completa de los %d conductores:\n", conductores.size());
		
		for (Conductor conductor : conductores) {
			conductor.mostrarInfo();
			System.out.println();
		}
	}
}
