package prueba;

import java.util.Calendar;
import java.util.TreeSet;


public abstract class Persona implements Comparable<Object>,Cotizable{
	private String nombre;
	private String apellidos;
	private int edad;
	private String dni;
	private int fechaInicio;//mayor de 65 llevar 35 años
	private TipoContrato tipoContrato;
	private boolean jubilado;
	private static final int mayoriaDeEdad=18;
	
	public Persona(){
	
	}
	public Persona(String nombre,String apellidos,int edad,String dni,int fechaInicio,TipoContrato tipoContrato){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.dni=dni;
		this.fechaInicio=fechaInicio;
		this.tipoContrato=tipoContrato;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(int fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() throws DNINoValidoException {
		if(this.dni.length()!=9) {
			throw new DNINoValidoException();
		}
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		try {
			return "DNI: "+this.getDni()+", Nombre: "+this.nombre+", Apellidos: "+this.apellidos;
		} catch (DNINoValidoException e) {
			// TODO Auto-generated catch block
			return " Nombre: "+this.nombre+", Apellidos: "+this.apellidos;
		}
	}
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	// Temporal=10% ams de años
	public abstract boolean getPuedeJubilarse();
	@Override
	public int compareTo(Object object) {
		/*if(object instanceof Persona) {
			Persona persona=(Persona)object;
			return this.dni.compareTo(persona.getDni());
		}else {
			return -1;
		}
		*/
		if(object instanceof Persona) {
			Persona persona=(Persona)object;
			try {
				return this.dni.compareTo(persona.getDni());
			} catch (DNINoValidoException e) {
				return -1;
			}
		}else {
			return -1;
		}
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public static TreeSet<Persona> guardarPersonas(Persona...personas){
		TreeSet<Persona> res= new TreeSet<Persona>();
		for(Persona p:personas){
			res.add(p);
		}
		return res;
	}
	public static int getMayoriaDeEdad() {
		return mayoriaDeEdad;
	}
	public boolean isJubilado() {
		return jubilado;
	}
	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}
}
