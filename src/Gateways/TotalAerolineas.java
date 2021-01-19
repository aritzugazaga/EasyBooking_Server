package Gateways;

import java.util.ArrayList;

public class TotalAerolineas {
	
	private ArrayList<String> codigoaerolineas = new ArrayList<String>();
	public static int totalaerolineas = 0;
	
	public TotalAerolineas() {
		// TODO Auto-generated constructor stub
		totalaerolineas += 1;
	}
	
	public ArrayList<String> getcodigoaerolineas(){
		return this.codigoaerolineas;
	}
	
	public void setcodigoaerolineas(ArrayList<String> codigos){
		this.codigoaerolineas = codigos;
	}
	
	public void aniadircodigoaerolinea(String codigo) {
		codigoaerolineas.add(codigo);
		totalaerolineas += 1;
	}
	
	public void cargaraerolineas() {
		codigoaerolineas.add("Iberia");
		codigoaerolineas.add("Vueling");
		System.out.println();
		totalaerolineas = 2;
		
	}
}
