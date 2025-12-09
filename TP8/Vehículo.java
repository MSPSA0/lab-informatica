import java.util.Scanner;

public class Vehículo {
	private String _marca;
	private String _modelo;
	private int _año;
	private int _matrícula;
	private int _kilometraje;
	
	public static Vehículo pedirVehículo(Scanner scanner) {
		String marca;
		String modelo;
		int año;
		int matrícula;
		int kilometraje;
		
		System.out.print("Marca: ");
		marca = scanner.nextLine();
		
		System.out.print("Modelo: ");
		modelo = scanner.nextLine();
		
		System.out.print("Año: ");
		año = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Matrícula: ");
		matrícula = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Kilometraje: ");
		kilometraje = Integer.parseInt(scanner.nextLine());
		
		System.out.println();
		
		return new Vehículo(marca, modelo, año, matrícula, kilometraje);
	}
	
	public Vehículo(String marca, String modelo, int año, int matrícula, int kilometraje) {
		setMarca(marca);
		setModelo(modelo);
		setAño(año);
		setMatrícula(matrícula);
		setKilometraje(kilometraje);
	}
	
	public String getMarca() {
		return _marca;
	}
	
	public void setMarca(String marca) {
		_marca = marca;
	}
	
	public String getModelo() {
		return _modelo;
	}
	
	public void setModelo(String modelo) {
		_modelo = modelo;
	}
	
	public int getAño() {
		return _año;
	}
	
	public void setAño(int año) {
		int añoActual = 2025; // <- Mala práctica, pero bueno
		
		if (año > añoActual) {
			System.out.println("El año del vehículo no puede ser mayor al año actual. Se asignará el año actual por defecto.");
			año = añoActual;
		}
		
		_año = año;
	}
	
	public int getMatrícula() {
		return _matrícula;
	}
	
	public void setMatrícula(int matrícula) {
		_matrícula = matrícula;
	}
	
	public int getKilometraje() {
		return _kilometraje;
	}
	
	public void setKilometraje(int kilometraje) {
		if (kilometraje < 0) {
			System.out.println("El kilometraje del vehículo no puede ser menor a 0. Se asignara 0 por defecto.");
			
			kilometraje = 0;
		}
		
		_kilometraje = kilometraje;
	}
	
	public void mostrarInfo() {
		System.out.printf("Vehículo:\n\tMarca: %s\n\tModelo: %s\n\tAño: %d\n\tMatrícula: %s\n\tKilometraje: %d\n", _marca, _modelo, _año, _matrícula, _kilometraje);
	}
}
