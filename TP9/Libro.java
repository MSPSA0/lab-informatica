class Libro extends MaterialBibliográfico {
	int _páginas;
	
	public Libro(String título, String autor, int año, int páginas) {
		super(título, autor, año);
		_páginas = páginas;
	}
	
	public int getPáginas() {
		return _páginas;
	}
	
	public void setPáginas(int valor) {
		_páginas = valor;
	}
	
	@Override public void mostrar() {
		System.out.printf("Libro:\n\tTítulo: %s\n\tAutor: %s\n\tAño: %d\n\tPáginas: %d\n", _título, _autor, _año, _páginas);
	}
}
