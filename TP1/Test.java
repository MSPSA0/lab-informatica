import javax.swing.JOptionPane;

public class Test {
	public void main() throws Throwable {
		String input = JOptionPane.showInputDialog("Aaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(input);
	}
	
	int getInteger(String message) {
		String input = JOptionPane.showInputDialog(message);
		return Integer.parseInt(input);
	}
}
