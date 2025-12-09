class Socio {
	String _nombre;
	int _número;
	int _límiteDePréstamos;
	
	public Socio(String nombre, int número, int límiteDePréstamos) {
		_nombre = nombre;
		_número = número;
		_límiteDePréstamos = límiteDePréstamos;
	}
	
	public String getNombre() {
		return _nombre;
	}
	
	public void setNombre(String valor) {
		_nombre = valor;
	}
	
	public int getNúmero() {
		return _número;
	}
	
	public void setNúmero(int valor) {
		_número = valor;
	}
	
	public int getLímiteDePréstamos() {
		return _límiteDePréstamos;
	}
	
	public void setLímiteDePréstamos(int valor) {
		_límiteDePréstamos = valor;
	}
	
	public void mostrar() {
		System.out.printf("Socio:\n\tNombre: %s\n\tNúmero: %d\n\tLímite de prestamos: %d\n", _nombre, _número, _límiteDePréstamos);
	}
}
