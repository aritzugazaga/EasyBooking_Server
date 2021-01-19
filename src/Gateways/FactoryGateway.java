package Gateways;

import java.util.ArrayList;

public class FactoryGateway {
	
	private ArrayList<IGatewayAerolinea> gatewaysaerolineas;
	private ArrayList<IGatewayPago> gatewayspago;
	private ArrayList<IGatewayLogin> gatewayslogin;
	private TotalAerolineas totalaerolineas;
	
	public ArrayList<IGatewayAerolinea> getgatewaysaerolineas() {
		return gatewaysaerolineas;
	}

	public  FactoryGateway() {
		totalaerolineas = new TotalAerolineas();
		totalaerolineas.cargaraerolineas();
		gatewaysaerolineas = new ArrayList<IGatewayAerolinea>();
		gatewayspago = new ArrayList<IGatewayPago>();
		initializeGatewaysaerolinea();
		initializegatewaylogin();
		initializegatewaypago();
	}
	
	public void initializeGatewaysaerolinea() {
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
	public void initializegatewaypago() {
		initializePaypal();
	}
	public void initializegatewaylogin() {
		initializeGoogle();
	}
	private void initializeIberia() {
		GatewayIberia iberia = new GatewayIberia();
		gatewaysaerolineas.add(iberia);
	}
	
	private void initializeVueling() {
		GatewayVueling vueling = new GatewayVueling();
		gatewaysaerolineas.add(vueling);
	}
	private void initializePaypal() {
		GatewayPaypal paypal = new GatewayPaypal();
		gatewayspago.add(paypal);
	}
	private void initializeGoogle() {
		GatewayGoogle google = new GatewayGoogle();
		gatewayslogin.add(google);
	}
}
