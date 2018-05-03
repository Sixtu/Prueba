package prueba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PruebaPersona {

	public static void main(String[] args) {
		String nombre="Nombre";
		String apellidos="Apellidos";
		int edad=16;
		Integer dninumber=12345678;
		int fechainicio=2012;
		List<EmpleadoPublico> personas= new ArrayList<EmpleadoPublico>();
		for(int i=1;i<=200;i++) {
			TipoContrato tipoContrato;
			switch(i%3) {
			case 0:
				tipoContrato=TipoContrato.INDEFINIDO;
				break;
			case 1:
				tipoContrato=TipoContrato.OBRA_Y_SERVICIO;
				break;
			default:
				tipoContrato=TipoContrato.TEMPORAL;
				break;
			}
			EmpleadoPublico persona=new EmpleadoPublico(nombre+i,apellidos+i,(edad+i)%100,(dninumber+i)+"N",fechainicio-i,tipoContrato,"Junta de Andalucía",3131+i);
			personas.add(persona);
		}/*
		for(Persona p:personas) {
			try {
				System.out.print("DNI: "+p.getDni()+"  Nombre: "+p.getNombre()+"  Apellido: "+p.getApellidos()+"  Tipo contrato: "+p.getTipoContrato()+"\n");
			} catch (DNINoValidoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.print("----------------------------------------------------------------------\n");
		Collections.sort(personas);
		for(Persona p:personas) {
			try {
				System.out.print("DNI: "+p.getDni()+"  Nombre: "+p.getNombre()+"  Apellido: "+p.getApellidos()+"  Tipo contrato: "+p.getTipoContrato()+"\n");
			} catch (DNINoValidoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		*/
		
		
		Set<Persona> personasSet=personas.stream().collect(Collectors.toSet());
		System.out.print("-----------------------------------------------------------\n");
		System.out.print(personas.size()+" "+personasSet.size());
	//Crear DNIException y usarlo en getDNI
		/*
		long t1=System.currentTimeMillis();
		personas.parallelStream().filter(p -> p.getEdad()>40).forEach(p->System.out.print(p+" Edad:"+p.getEdad()+"\n"));
		long t2=System.currentTimeMillis();
		long tt1=t2-t1;
		
		long t3=System.currentTimeMillis();
		personas.stream().filter(p -> p.getEdad()>40).forEach(p->System.out.print(p+" Edad:"+p.getEdad()+"\n"));
		long t4=System.currentTimeMillis();
		long tt2=t4-t3;
		*/
		
		long t5=System.currentTimeMillis();
		personas.parallelStream()
			.filter(p ->{System.out.print("Hilo: "+Thread.currentThread().getName());return p.getEdad()>40;})
			.sorted((p1,p2)->{System.out.print("Hilo: "+Thread.currentThread().getName()); return p1.getApellidos().compareTo(p2.getApellidos());})
			.forEach(p->{System.out.print("Hilo: "+Thread.currentThread().getName());System.out.print(p+" Edad:"+p.getEdad()+"\n");});
		long t6=System.currentTimeMillis();
		long tt3=t6-t5;
		/*
		long t7=System.currentTimeMillis();
		personas.stream()
			.filter(p -> p.getEdad()>40)
			.sorted((p1,p2)->p1.getApellidos().compareTo(p2.getApellidos()))
			.forEach(p->System.out
					.print(p+" Edad:"+p.getEdad()+"\n"));
		long t8=System.currentTimeMillis();
		long tt4=t8-t7;
		*/
	//	System.out.print("Con parallel: "+tt1+"\n");
	//	System.out.print("Sin parallel: "+tt2+"\n");
		System.out.print("Sort con parallel: "+tt3+"\n");
		//System.out.print("Sort sin parallel: "+tt4+"\n");
	
	}
	

}
