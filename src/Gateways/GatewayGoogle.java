package Gateways;

import java.rmi.RemoteException;
import server.remote.IGoogle;

public class GatewayGoogle implements IGatewayLogin {
	
	private String IP = "127.0.0.1";
	private int puerto = 1099;
	private String server = "Google";
	private IGoogle google;
	
	
	public GatewayGoogle() {
		try {
			String servidor = IP + "," + puerto + "," + server;
			google = (IGoogle) java.rmi.Naming.lookup(servidor);
		}catch(Exception e) {
			System.err.println("Excepcion:  " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean registrar(String email, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		return google.registrar(email, contrasenya);
				
	}
	
	@Override
	public boolean login(String email, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		return google.login(email, contrasenya);
	}
}
