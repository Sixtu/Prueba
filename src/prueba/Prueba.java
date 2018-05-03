package prueba;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Prueba {

	public static void main(String[] args) {
		EmpleadoPublico persona1=new EmpleadoPublico("Pedro","Díaz",15,"12345678N",1980,TipoContrato.INDEFINIDO,"Junta de Andalucía",3131);
		EmpleadoPublico persona2=new EmpleadoPublico("Jose","Rodriguez",68,"72233344D",1990,TipoContrato.INDEFINIDO,"Junta de Andalucía",3132);
		EmpleadoPublico persona3=new EmpleadoPublico("Paco","Perez",32,"55226678E",1980,TipoContrato.TEMPORAL,"Junta de Andalucía",3133);
		EmpleadoPublico persona4=new EmpleadoPublico("Jesus","Santos",28,"51116678E",1990,TipoContrato.OBRA_Y_SERVICIO,"Junta de Andalucía",3111);
		EmpleadoPublico persona5=new EmpleadoPublico("Carlos","Delgado",32,"55226678E",1980,TipoContrato.TEMPORAL,"Junta de Andalucía",3122);
		EmpleadoPublico persona6=new EmpleadoPublico("Manuel","Ortega",36,"55226678E",1980,TipoContrato.TEMPORAL,"Junta de Andalucía",3124);
		persona2.setJubilado(true);
		persona4.setJubilado(true);
		
		EmpleadoPublico empleado1=new EmpleadoPublico("Pedro","Díaz",68,"14445678N",1980,TipoContrato.INDEFINIDO,"Junta de Andalucía",3131);
		EmpleadoPublico empleado2=new EmpleadoPublico("Jose","Rodriguez",64,"72233444D",1990,TipoContrato.INDEFINIDO,"Seguridad social",1233);
		EmpleadoPublico empleado3=new EmpleadoPublico("Paco","Perez",54,"55220789E",1980,TipoContrato.TEMPORAL,"Seguridad social",4211);
		System.out.print(Calendar.getInstance().get(Calendar.YEAR));
		System.out.print("\nPersona1 con persona2: "+persona1.compareTo(persona2)+"\n");
		System.out.print("Persona1 con persona3: "+persona1.compareTo(persona3)+"\n");
		System.out.print("¿Persona1 puede jubilarse?: "+persona1.getPuedeJubilarse()+"\n");
		System.out.print("¿Persona2 puede jubilarse?: "+persona2.getPuedeJubilarse()+"\n");
		System.out.print("¿Persona3 puede jubilarse?: "+persona3.getPuedeJubilarse()+"\n");
		TreeSet<Persona> personas=Persona.guardarPersonas(persona1,persona2,persona3,persona4,persona5,persona6);
		System.out.print("\n"+personas+"\n");
		for(Persona p:personas) {
			try {
				System.out.print("DNI: "+p.getDni()+"  Nombre: "+p.getNombre()+"  Apellido: "+p.getApellidos()+"  Tipo contrato: "+p.getTipoContrato()+"\n");
			} catch (DNINoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print(Persona.getMayoriaDeEdad()+"\n");
		System.out.print(TipoContrato.TEMPORAL.getYears(20)+"\n");
		GestorPersona g= GestorPersona.getInstance();
		g.setPersonas(personas);
		System.out.print(GestorPersona.getInstance().getMediaEdad()+"\n");
		TreeSet<EmpleadoPublico> empleados=new TreeSet<EmpleadoPublico>();
		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
		for(EmpleadoPublico p:empleados) {
			try {
				System.out.print("DNI: "+p.getDni()+"  Nombre: "+p.getNombre()+"  Apellido: "+p.getApellidos()+"  Trienio: "+p.getNumeroTrienio()+"\n");
			} catch (DNINoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print(persona1.sonVerdaderos(true,true,false,false,true,true)+"\n");
		System.out.print(persona1.sonVerdaderos(true,true,true,true,true,true)+"\n");
		//persona1.setDni("dawd");
		try {
			System.out.print(persona1.getDni()+"\n");
		} catch (DNINoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			g.addEmpleado(persona1);
		} catch (DNIDuplicadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(GestorPersona.getInstance().getPersonas()+"\n");
		
		
		try(EmpleadoPublico empleado= new EmpleadoPublico("Paco","Perez",54,"55226789E",1980,TipoContrato.TEMPORAL,"Seguridad social",4211)) {
			g.addEmpleado(empleado);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.print("\n"+GestorPersona.getInstance().getPersonas()+"\n");
		System.out.print("-----------------------------------------------------------\n");
		Collection<Persona> personasFiltradas=GestorPersona.imprime((Persona p) ->{ return p.getEdad()>18 && p.getEdad()<40;});
		System.out.print("\n"+personasFiltradas+"\n");
		System.out.print("-----------------------------------------------------------\n");
		
		//GestorPersona.procesaPersonas((Persona p) ->{ return p.getEdad()>65;}, p-> p.setJubilado(true));
		
		/*for(Persona p:GestorPersona.getInstance().getPersonas()) {
			try {
				System.out.print("DNI: "+p.getDni()+"  Nombre: "+p.getNombre()+"  Apellido: "+p.getApellidos()+"  Jubilado: "+p.isJubilado()+"\n");
			} catch (DNINoValidoException e) {
				e.printStackTrace();
			}
		}*/ /*
		GestorPersona.getInstance().getPersonas().stream().filter(p -> p.getEdad()>65).forEach(p->p.setJubilado(true));
		
		for(Persona p:GestorPersona.getInstance().getPersonas()) {
			try {
				System.out.print("DNI: "+p.getDni()+"  Nombre: "+p.getNombre()+"  Apellido: "+p.getApellidos()+"  Jubilado: "+p.isJubilado()+"\n");
			} catch (DNINoValidoException e) {
				e.printStackTrace();
			}
		}*/
		//GestorPersona.getInstance().getPersonas().stream().filter(p -> p.getEdad()>65).forEach((Persona p)->{p.setJubilado(true);System.out.print(p+", Jubilado: "+p.isJubilado());});
		Double media=g.getPersonas().stream().mapToInt(p ->  p.getEdad()).average().getAsDouble();
		List<Persona> personasMayorMedia=GestorPersona.filtraPersonas(p -> p.getEdad()>media);
		List<Persona> personasMenorMedia=GestorPersona.filtraPersonas(p -> p.getEdad()<=media);
		System.out.print(personasMayorMedia+"\n"+personasMenorMedia+"\n");
		System.out.print("-----------------------------------------------------------\n");
		g.getPersonas().stream()
				.mapToInt(p ->{System.out.print("map: "+p+"\n");  return p.getEdad();})
				.filter(p -> {System.out.print("filter: "+p+"\n");  return p>=18;})
				.forEach(p->System.out.print("forEach: "+p+"\n"));
		
		//Supplier<Stream<Persona>> personasJubiladas=() -> g.getPersonas().stream().filter(p -> p.getEdad()>65);
		//personasJubiladas.get().forEach(System.out::println);
		System.out.print("-----------------------------------------------------------\n");
		Map<Character,List<Persona>> listaAgrupada=g.getPersonas().stream()
				.collect(Collectors.groupingBy(p -> p.getApellidos().charAt(0)));
		listaAgrupada.forEach((l,p)-> System.out.print(l+": "+p+"\n"));
		
		Collector<Persona,StringJoiner, String> collectPersonas=
				Collector.of(
						()-> new StringJoiner("|"),
						(j,p) -> {
							try {
								j.add(p.getDni());
							} catch (DNINoValidoException e) {
								e.printStackTrace();
							}
						},
						(j1,j2) -> j1.merge(j2),
						StringJoiner::toString);
		
		//Map<Character,String> listaDNIAgrupada=g.getPersonas().stream().collect(Collectors.groupingBy(p -> p.getApellidos().charAt(0)),collectPersonas);
		
		listaAgrupada.forEach((l,p)-> System.out.print(l+": "+p.stream().collect(collectPersonas)+"\n"));
	
		
		//persona mayor no jubilada, buscar todas las personas jubiladas y transformarla en una entidad tansformadojubilado
		g.getPersonas().stream().filter(p -> p.getPuedeJubilarse()==false).reduce((p1,p2)->p1.getEdad() > p2.getEdad() ? p1:p2).ifPresent(p->{
			try {
				System.out.print(p.getDni()+" "+p.getEdad()+" "+p.isJubilado());
			} catch (DNINoValidoException e) {
				e.printStackTrace();
			}
		});
	
		//Collection<Jubilado> jubilados=g.getPersonas().stream().filter(p -> p.isJubilado()).flatMap(p->Stream.of((Jubilado)p));
		System.out.print("-----------------------------------------------------------\n");
		StringBuilder prueba=new StringBuilder("prueba1");
		prueba.insert(7,"-");
		prueba.insert(0,"-");
		prueba.insert(4,"-");
		System.out.print(prueba);
		prueba.reverse();
		System.out.print(prueba);
		System.out.print("-----------------------------------------------------------\n");
		/*Puesto<EmpleadoPublico> puesto1=new Puesto<EmpleadoPublico>("Mesa1",persona1);
		Puesto<EmpleadoPublico> puesto2=new Puesto<EmpleadoPublico>("Mesa2",persona2);
		Puesto<EmpleadoPublico> puesto3=new Puesto<EmpleadoPublico>("Mesa3",persona3);
		List<Puesto<Object>> listaPuestos=new ArrayList<Puesto<Object>>();*/
		
	}
	
}
