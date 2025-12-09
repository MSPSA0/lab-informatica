import java.util.Scanner;

public class Conductor {
	private String _nombre;
	private int _edad;
	private int _licencia;
	private Vehículo _vehículoAsignado;
	
	public static Conductor pedirConductor(Scanner scanner) {
		String nombre;
		int edad;
		int licencia;
		Vehículo vehículoAsignado;
		
		System.out.print("Nombre: ");
		nombre = scanner.nextLine();
		
		System.out.print("Edad: ");
		edad = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Licencia: ");
		licencia = Integer.parseInt(scanner.nextLine());
		
		System.out.println("- Datos del vehículo.");
		vehículoAsignado = Vehículo.pedirVehículo(scanner);
		
		return new Conductor(nombre, edad, licencia, vehículoAsignado);
	}
	
	public Conductor(String nombre, int edad, int licencia, Vehículo vehículoAsignado) {
		setNombre(nombre);
		setEdad(edad);
		setLicencia(licencia);
		setVehículoAsignado(vehículoAsignado);
	}
	
	public String getNombre() {
		return _nombre;
	}
	
	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	public int getEdad() {
		return _edad;
	}
	
	public void setEdad(int edad) {
		if (edad < 18) {
			System.out.println("Edad del conductor no puede ser menor de 18. Se asignará 18 por defecto.");
			
			edad = 18;
		}
		
		_edad = edad;
	}
	
	public int getLicencia() {
		return _licencia;
	}
	
	public void setLicencia(int licencia) {
		_licencia = licencia;
	}
	
	public Vehículo getVehículoAsignado() {
		return _vehículoAsignado;
	}
	
	public void setVehículoAsignado(Vehículo vehículoAsignado) {
		_vehículoAsignado = vehículoAsignado;
	}
	
	public void mostrarInfo() {
		System.out.printf("Conductor:\n\tNombre: %s\n\tEdad: %d\n\tLicencia: %d\n", _nombre, _edad, _licencia);
		_vehículoAsignado.mostrarInfo();
	}
}
