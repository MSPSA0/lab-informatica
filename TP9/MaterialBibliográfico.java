abstract class MaterialBibliográfico {
	protected String _título;
	protected String _autor;
	protected int _año;
	
	public MaterialBibliográfico(String título, String autor, int año) {
		_título = título;
		_autor = autor;
		_año = año;
	}
	
	public String getTítulo() {
		return _título;
	}
	
	public void setTítulo(String valor) {
		_título = valor;
	}
	
	public String getAutor() {
		return _autor;
	}
	
	public void setAutor(String valor) {
		_autor = valor;
	}
	
	public int getAño() {
		return _año;
	}
	
	public void setAño(int valor) {
		_año = valor;
	}
	
	abstract public void mostrar();
}
