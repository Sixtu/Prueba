package prueba;

public class Jubilado extends Persona{

	@Override
	public String imprimeHistorial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getPuedeJubilarse() {
		// TODO Auto-generated method stub
		return false;
	}
	public Jubilado(Persona persona) throws DNINoValidoException {
		super(persona.getNombre(),persona.getApellidos(),persona.getEdad(),persona.getDni(),persona.getFechaInicio(),persona.getTipoContrato());
	}

}
