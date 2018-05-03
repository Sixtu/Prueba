package prueba;

public class Puesto<T> {
	private String ubicacion;
	private T elemento;
	
	public Puesto(String ubicacion,T elemento) {
		this.ubicacion=ubicacion;
		this.elemento=elemento;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
}
