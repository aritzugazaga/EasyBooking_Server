package Gateways;

import java.rmi.RemoteException;

public interface IGatewayPago {
	
	public boolean pagar(int precio_unitario, String email, String codigo) throws RemoteException; 
	public boolean tienedinero(int precio_unitario, String email, String codigo) throws RemoteException;
}
