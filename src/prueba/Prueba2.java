package prueba;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prueba2 {

	public static void main(String[] args) {
		Path p=Paths.get("src/ficheros/timelog.log");
		System.out.print(Files.exists(p)+"\n");
		System.out.print(Files.isExecutable(p)+"\n");
		System.out.print(Files.isWritable(p)+"\n");
		System.out.print(Files.isReadable(p)+"\n");
		
		try {
			System.out.print(Files.readAllLines(p).get(1)+"\n");
			System.out.print("Número de filas: "+Files.readAllLines(p).size()+"\n");
			System.out.print("Número de errores: "+Files.readAllLines(p).stream().filter(l->l.contains("(4")||l.contains("(5")).count()+"\n");
			Map<Object, List<String>> listaAgrupadaDias=Files.readAllLines(p).stream().collect(Collectors.groupingBy(l->l.toString().substring(0, 10)));
			
		
			Object mayordias=listaAgrupadaDias.keySet().stream().max((f1,f2)->Integer.compare(listaAgrupadaDias.get(f1).size(),listaAgrupadaDias.get(f2).size())).get();
			System.out.print("Día con más visitas: "+mayordias+", total visitas: "+listaAgrupadaDias.get(mayordias).size()+"\n");

			
			
			Map<Object, List<String>> listaAgrupadaPaginas=Files.readAllLines(p).stream().collect(Collectors.groupingBy(l->l.split("\"")[1]));
			
			
			Object mayorpagina=listaAgrupadaPaginas.keySet().stream().max((x1,x2)->Integer.compare(listaAgrupadaPaginas.get(x1).size(),listaAgrupadaPaginas.get(x2).size())).get();
			System.out.print("Página con más visitas: "+mayorpagina+", total visitas: "+listaAgrupadaPaginas.get(mayorpagina).size()+"\n");
			
			
			Peticion peticion=new Peticion(Files.readAllLines(p).get(1));
			System.out.print(peticion.getFecha());
			//Map<Object, List<String>> listaAgrupada=Files.readAllLines(p).stream().collect(Collectors.groupingBy(l->l.toString().substring(0, 10)));
			//listaAgrupadaPaginas.forEach((g,s)-> System.out.print(g+": "+s.size()+"\n"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
