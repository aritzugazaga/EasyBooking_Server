package Services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Gateways.GatewayPaypal;
import Gateways.IGatewayPago;

public class PagoService{
	
	private List<IGatewayPago> pagos;
	
	public PagoService() {
		pagos = new ArrayList<IGatewayPago>();
		GatewayPaypal paypal = new GatewayPaypal();
		pagos.add(0, paypal);
	}
	
	public boolean tieneFondos(int precio_unitario, String email, String codigo) throws RemoteException {
		return pagos.get(0).tienedinero(precio_unitario, email, codigo);
	}
	
	public boolean pagar(int precio_unitario, String email, String codigo) throws RemoteException {
		return pagos.get(0).pagar(precio_unitario, email, codigo);
	}
}
