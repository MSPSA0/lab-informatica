import java.util.GregorianCalendar;

class Main {
	public static void main(String[] args) {
		Libro libro = new Libro("El código Da Vinci", "Dan Brown", 2003, 519);
		DVD dvd = new DVD("Mátrix", "Warner Bros.", 1999, 136);
		Socio socio = new Socio("Antón Fuentes", 1, 2);
		Préstamo préstamo1 = new Préstamo(socio, libro, new GregorianCalendar(), new GregorianCalendar(2026, 1, 25));
		Préstamo préstamo2 = new Préstamo(socio, dvd, new GregorianCalendar(), new GregorianCalendar(2026, 2, 12));
		
		libro.mostrar();
		dvd.mostrar();
		socio.mostrar();
		préstamo1.mostrar();
		préstamo2.mostrar();
	}
}
