class DVD extends MaterialBibliográfico {
	int _duraciónMinutos;
	
	public DVD(String título, String autor, int año, int duraciónMinutos) {
		super(título, autor, año);
		_duraciónMinutos = duraciónMinutos;
	}
	
	public int getDuraciónMinutos() {
		return _duraciónMinutos;
	}
	
	public void setDuraciónMinutos(int valor) {
		_duraciónMinutos = valor;
	}
	
	@Override public void mostrar() {
		System.out.printf("DVD:\n\tTítulo: %s\n\tAutor: %s\n\tAño: %d\n\tDuración: %dm\n", _título, _autor, _año, _duraciónMinutos);
	}
}
