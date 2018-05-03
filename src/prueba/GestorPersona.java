package prueba;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestorPersona {
	private static GestorPersona gestorPersona;
	private Collection<Persona> personas;
	
	private GestorPersona() {
		this.personas=new HashSet<Persona>();
	}
	public static GestorPersona getInstance() {
		if(gestorPersona==null) {
			gestorPersona=new GestorPersona();
		}
		return gestorPersona;
	}
	public Collection<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(Collection<Persona> personas) {
		this.personas = personas;
	}
	public double getMediaEdad() {
		double res=0.0;
		for(Persona p:this.personas) {
			res+=p.getEdad();
		}
		res=res/this.personas.size();
		return res;
	}
	public void addEmpleado(Persona persona) throws DNIDuplicadoException {
		try {
			for(Persona p:this.personas) {
				if(persona.getDni().equals(p.getDni())) {
					throw new DNIDuplicadoException();
				}
			}
			this.personas.add(persona);
		} catch (DNINoValidoException e) {
			e.printStackTrace();
		}
		//Crear metrodo procesa persona, acepta lista, hace filtrado y aplica una función
		
	}
	public static Collection<Persona> imprime(Predicate<Persona> checker) {
		Collection<Persona> res=new HashSet<Persona>();
		for(Persona p:getInstance().getPersonas()) {
			if(checker.test(p)) {
				res.add(p);
			}
		}
		return res;
	}
	public static void procesaPersonas(Predicate<Persona> checker,Consumer<Persona> block) {
		//getInstance().getPersonas().stream().filter(p -> checker.test(p)).forEach(p -> block.accept(p));
		for(Persona p:getInstance().getPersonas()) {
			if(checker.test(p)) {
				block.accept(p);
			}
		}
	}
	public static List<Persona> filtraPersonas(Predicate<Persona> checker) {
		return getInstance().getPersonas().stream()
				.filter(p ->checker.test(p))
				.collect(Collectors.toList());
	}
	
}
