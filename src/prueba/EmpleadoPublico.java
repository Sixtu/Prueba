package prueba;

import java.util.Calendar;

public class EmpleadoPublico extends Persona implements AutoCloseable{
	// autocloseable cerrar expediente
	private String organismoPublico;
	private Integer numeroTrienio;
	
	public EmpleadoPublico(String nombre,String apellidos,int edad,String dni,int fechaInicio,
			TipoContrato tipoContrato,String organismoPublico, Integer numeroTrienio) {
		super(nombre,apellidos,edad,dni,fechaInicio,tipoContrato);
		this.organismoPublico=organismoPublico;
		this.numeroTrienio=numeroTrienio;
		
	}
	public EmpleadoPublico(String nombre,String apellidos,int edad,String dni,int fechaInicio,
			TipoContrato tipoContrato) {
		super(nombre,apellidos,edad,dni,fechaInicio,tipoContrato);
		
	}
	
	public Integer getNumeroTrienio() {
		return numeroTrienio;
	}
	public void setNumeroTrienio(Integer numeroTrienio) {
		this.numeroTrienio = numeroTrienio;
	}
	public String getOrganismoPublico() {
		return organismoPublico;
	}
	public void setOrganismoPublico(String organismoPublico) {
		this.organismoPublico = organismoPublico;
	}
	
	public int compareTo(Object object) {
		if(object instanceof EmpleadoPublico) {
			EmpleadoPublico empleado=(EmpleadoPublico)object;
			return this.numeroTrienio.compareTo(empleado.getNumeroTrienio());
		}else {
			return -1;
		}
	}
	@Override
	public boolean getPuedeJubilarse() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		boolean res=false;
		switch(this.getTipoContrato()) {
		case TEMPORAL:
			res= this.getEdad()>65 | year-this.getFechaInicio()>35*TipoContrato.TEMPORAL.getMultiplicador();
			break;
		default:
			res= this.getEdad()>65 | year-this.getFechaInicio()>35;
			break;
		}
		return res;
		/*if(this.getTipoContrato().equals(TipoContrato.TEMPORAL)) {
			return this.edad>65 | year-this.fechaInicio>35*0.1;
		}else {
			return this.edad>65 | year-this.fechaInicio>35;
		}*/
	}
	@Override
	public String imprimeHistorial() {
		return this.getNombre()+" "+this.getApellidos();
	}
	public boolean sonVerdaderos(boolean...lista) {
		boolean res=true;
		for(boolean b:lista) {
			if(!b && this.organismoPublico!=null) {
				res=false;
				break;
			}
		}
		return res;
	}
	@Override
	public void close() throws Exception {
		System.out.print("Cerrando recurso");
		
	}
	

}
