package prueba;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Peticion {
	private String url;
	private LocalDateTime fecha;
	private String codigo;
	
	public Peticion(String linea){
		String[] lineaDivididaComillas=linea.split("\"");
		this.url=lineaDivididaComillas[1];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		String[] lineaDivididaComa=linea.split(",");
		this.fecha=LocalDateTime.parse(lineaDivididaComa[0],formatter);
		String lineaDivididaParent=lineaDivididaComillas[2].split("\\(")[1];
		String codigo=lineaDivididaParent.split("\\)")[0];
		this.codigo=codigo;
		
		
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
