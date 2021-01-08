package Gateways;

public class FactoryGateway {
	private static FactoryGateway instance = new FactoryGateway();

	private FactoryGateway() {
	}

	public static FactoryGateway getInstance() {
		return instance;
	}

	public IGatewayAerolinea creargatewayaerolinea(String type) {
		if (type == null) {
			return null;
		}

		if (type.equalsIgnoreCase("VUELING")) {
			return (IGatewayAerolinea) new GatewayVueling();
		} else if (type.equalsIgnoreCase("IBERIA")) {
			return (IGatewayAerolinea) new GatewayIberia();
		} else {
			return null;
		}

	}

	public IGatewayLogin craergatewaylogin(String type) {
		if (type == null) {
			return null;
		}

		if (type.equalsIgnoreCase("GOOGLE")) {
			return (IGatewayLogin) new GatewayGoogle();
		} else if (type.equalsIgnoreCase("FACEBOOK")) {
			return (IGatewayLogin) new GatewayFacebook();
		} else {
			return null;
		}

	}

	public IGatewayPago creargatewaypago(String type) {
		if (type == null) {
			return null;
		}

		if (type.equalsIgnoreCase("VISA")) {
			return (IGatewayPago) new GatewayTarjetaCredito();
		} else if (type.equalsIgnoreCase("PAYPAL")) {
			return (IGatewayPago) new GatewayPaypal();
		} else {
			return null;
		}

	}
}
