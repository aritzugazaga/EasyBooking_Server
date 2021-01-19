package Gateways;

import java.rmi.RemoteException;

import server.remote.IPaypal;

public class GatewayPaypal implements IGatewayPago {
	
	private String IP = "127.0.0.1";
	private int puerto = 1099;
	private String server = "Paypal";
	private IPaypal paypal;
	
	public GatewayPaypal() {
		try {
			String servidor = IP + "," + puerto + "," + server;
			paypal = (IPaypal) java.rmi.Naming.lookup(servidor);
		}catch(Exception e) {
			System.err.println("Excepcion: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public boolean pagar(int precio_unitario, String email, String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return paypal.pagar(precio_unitario, email, codigo);		
	}	
	
	@Override
	public boolean tienedinero(int precio_unitario, String email, String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return paypal.tienedinero(precio_unitario, email, codigo);
	}
}