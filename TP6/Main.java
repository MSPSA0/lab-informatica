import java.text.Collator;
import javax.swing.JOptionPane;

public class Main {
	static final String[][] NAMES = {
		{"Olga", "Diego", "Iván", "Omar"},
		{"Elena", "Sergio", "Thiago", "Andrea"},
		{"María", "Andrés", "Teresa", "Emilio"},
		{"Raúl", "Irene", "Ana", "Antonio"},
		{"Marta", "Ignacio", "Gustavo", "Oscar"}
	};

	public static void main(String[] args) {
		String name = null;
		
		// Ingresa un nombre válido.
		while (name == null || name.isEmpty()) {
			name = JOptionPane.showInputDialog("Ingrese un nombre.").trim();
		}
		
		// Usa la clase Collator para comparar nombres ignorando acentos y capitalización.
		Collator collator = Collator.getInstance();
		collator.setStrength(Collator.PRIMARY);

		// Itera por todas las columnas de cada fila.
		for (int row = 0; row < NAMES.length; row++) {
			for (int col = 0; col < NAMES[row].length; col++) {
				if (collator.equals(NAMES[row][col], name)) {
					String message = String.format("El nombre se encuentra el la fila %d, columna %d.", row + 1, col + 1);
					JOptionPane.showMessageDialog(null, message);
					return;
				}
			}
		}

		JOptionPane.showMessageDialog(null, "No se encontró el nombre.");
	}
}
