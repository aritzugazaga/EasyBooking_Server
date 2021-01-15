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
			return new GatewayVueling();
		} else if (type.equalsIgnoreCase("IBERIA")) {
			return new GatewayIberia();
		} else {
			return null;
		}

	}

	public IGatewayLogin craergatewaylogin(String type) {
		if (type == null) {
			return null;
		}

		if (type.equalsIgnoreCase("GOOGLE")) {
			return new GatewayGoogle();
		} else if (type.equalsIgnoreCase("FACEBOOK")) {
			return new GatewayFacebook();
		} else {
			return null;
		}

	}

	public IGatewayPago creargatewaypago(String type) {
		if (type == null) {
			return null;
		}

		if (type.equalsIgnoreCase("VISA")) {
			return new GatewayTarjetaCredito();
		} else if (type.equalsIgnoreCase("PAYPAL")) {
			return new GatewayPaypal();
		} else {
			return null;
		}

	}
}
