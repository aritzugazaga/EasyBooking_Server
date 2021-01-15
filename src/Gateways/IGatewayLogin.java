package Gateways;

import java.rmi.RemoteException;

public interface IGatewayLogin{
	
	public void registrar(String email, String contrasenya) throws RemoteException;
	public boolean login(String email, String contrasenya) throws RemoteException;

}
