package Gateways;

import java.rmi.RemoteException;
import server.remote.IGoogle;

public class GatewayGoogle implements IGatewayLogin {
	
	private String IP = "127.0.0.1";
	private int puerto = 1099;
	private String server = "Google";
	
	@Override
	public boolean registrar(String email, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		boolean registro = false;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String servidor = IP + "," + puerto + "," + server;
			IGoogle google = (IGoogle) java.rmi.Naming.lookup(servidor);
			
			try {
				registro = google.login(email, contrasenya);
				if (registro) {
					System.out.println("Los datos del usuario son correctos, usuario registrado");
				}
				else {
					System.out.println("Los datos del usuario son incorrectos, usuario no registrado");
				}
			} catch (Exception e) {
				System.err.println("Excepcion: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return registro;
	}
	

	@Override
	public boolean login(String email, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		boolean login = false;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String servidor = IP + "," + puerto + "," + server;
			IGoogle google = (IGoogle) java.rmi.Naming.lookup(servidor);
			
			try {
				login = google.login(email, contrasenya);
				if (login) {
					System.out.println("Los datos del usuario son correctos, login correcto");
				}
				else {
					System.out.println("Los datos del usuario son incorrectos, login incorrecto");
				}
			} catch (Exception e) {
				System.err.println("Excepcion:  " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return login;
	}

}
