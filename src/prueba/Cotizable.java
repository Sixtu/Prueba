package prueba;

public abstract interface Cotizable {
	public String imprimeHistorial();
	public default boolean sonVerdaderos(boolean...lista) {
		boolean res=true;
		for(boolean b:lista) {
			if(!b) {
				res=false;
				break;
			}
		}
		return res;
	}
	
}
