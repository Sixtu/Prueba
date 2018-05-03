package prueba;

public enum TipoContrato {
	INDEFINIDO(1.0,"Indefinido"),TEMPORAL(1.1,"Temporal"), OBRA_Y_SERVICIO(1.0,"Obra y servicio");
	
	private final double multiplicador;
	private final String nombre;
	
	TipoContrato(double multiplicador, String nombre) { 
		this.multiplicador = multiplicador; 
		this.nombre = nombre; 
	}
	public double getMultiplicador() { 
		return this.multiplicador; 
	}
	public String getNombre() {
		return this.nombre;
	}
	public double getYears(int years) {
		return this.multiplicador*years;
	}
	//clase gestor personar con una sola instancia,constructor privado, 
	//atributo del mismo tipo que gestor persona inicializado a null, 
	//getInstance() Si es null llama al constructor privado
}
