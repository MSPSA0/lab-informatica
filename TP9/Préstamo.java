import java.util.Calendar;

class Préstamo {
	Socio _socio;
	MaterialBibliográfico _material;
	Calendar _fechaDePréstamo;
	Calendar _fechaDeVencimiento;
	
	public Préstamo(Socio socio, MaterialBibliográfico material, Calendar fechaDePréstamo, Calendar fechaDeVencimiento) {
		_socio = socio;
		_material = material;
		_fechaDePréstamo = fechaDePréstamo;
		_fechaDeVencimiento = fechaDeVencimiento;
	}
	
	public void mostrar() {
		String fechaDePréstamo = String.format(
			"%d/%d/%d",
			_fechaDePréstamo.get(Calendar.DAY_OF_MONTH),
			_fechaDePréstamo.get(Calendar.MONTH) + 1,
			_fechaDePréstamo.get(Calendar.YEAR)
		);
		String fechaDeVencimiento = String.format(
			"%d/%d/%d",
			_fechaDeVencimiento.get(Calendar.DAY_OF_MONTH),
			_fechaDeVencimiento.get(Calendar.MONTH) + 1,
			_fechaDeVencimiento.get(Calendar.YEAR)
		);
		
		System.out.printf("Préstamo:\n\tSocio: %s\n\tMaterial: %s\n\tFecha de préstamo: %s\n\tFecha de vencimiento: %s\n", _socio.getNombre(), _material.getTítulo(), fechaDePréstamo, fechaDeVencimiento);
	}
}
