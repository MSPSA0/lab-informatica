public class Color {
	public static final Color ROJO = new Color(1, 0, 0);
	public static final Color VERDE = new Color(0, 1, 0);
	public static final Color AZUL = new Color(0, 0, 1);
	public static final Color AMARILLO = new Color(1, 1, 0);
	public static final Color CIAN = new Color(0, 1, 1);
	public static final Color MAGENTA = new Color(1, 0, 1);
	public static final Color NEGRO = new Color(0, 0, 0);
	public static final Color BLANCO = new Color(1, 1, 1);
	
	public final float r;
	public final float g;
	public final float b;
	
	public static Color porNombre(String nombre) {
		nombre = nombre.trim().toLowerCase();
		
		switch (nombre) {
			case "rojo":
				return Color.ROJO;
			
			case "verde":
				return Color.VERDE;
			
			case "azul":
				return Color.AZUL;
			
			case "amarillo":
				return Color.AMARILLO;
			
			case "cian":
				return Color.CIAN;
			
			case "magenta":
				return Color.MAGENTA;
		}
		
		return Color.NEGRO;
	}
	
	public Color(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return String.format("(r: %.2f, g: %.2f, b: %.2f)", r, g, b);
	}
}
