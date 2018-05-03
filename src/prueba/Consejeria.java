package prueba;

import java.util.List;

public class Consejeria<T> {
	private List<Puesto<T>> listaPuestos;

	public Consejeria() {
		
	}
	public List<Puesto<T>> getListaPuestos() {
		return listaPuestos;
	}

	public void setListaPuestos(List<Puesto<T>> listaPuestos) {
		this.listaPuestos = listaPuestos;
	}
}
