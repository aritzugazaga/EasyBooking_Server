package Gateways;

import java.rmi.RemoteException;

public class GatewayPaypal implements IGatewayPago {

	@Override
	public boolean pagar(int precio_unitario, String email, String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tienedinero(int precio_unitario, String email, String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
