package Gateways;

import java.util.ArrayList;
import java.util.List;

public class FactoryGateway {
	
	private ArrayList<IGatewayAerolinea> gatewaysaerolineas;
	private TotalAerolineas totalaerolineas;
	
	public ArrayList<IGatewayAerolinea> getgatewaysaerolineas() {
		return gatewaysaerolineas;
	}

	public  FactoryGateway() {
		// TODO Auto-generated constructor stub
		totalaerolineas = new TotalAerolineas();
		totalaerolineas.cargaraerolineas();
		gatewaysaerolineas = new ArrayList<IGatewayAerolinea>();
		initializeGateways();
	}
	
	public void initializeGateways() {
		for (String e : totalaerolineas.getcodigoaerolineas()) {
			switch (e) {
				case "Iberia":
					initializeIberia();
					break;
					
				case "Vueling":
					initializeVueling();
					break;
		
				default:
					throw new IllegalArgumentException("Unexpected value: " + e);
			}
		}
		
	}
	
	private void initializeIberia() {
		GatewayIberia iberia = new GatewayIberia();
		gatewaysaerolineas.add(iberia);
	}
	
	private void initializeVueling() {
		GatewayVueling vueling = new GatewayVueling();
		gatewaysaerolineas.add(vueling);
	}
}
