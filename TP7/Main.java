import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nombre;
		Color color;
		
		System.out.println("Ingrese el nombre de uno de los colores disponibles.");
		nombre = scanner.nextLine();
		color = Color.porNombre(nombre);
		
		System.out.print("El color es: ");
		System.out.println(color);
	}
}