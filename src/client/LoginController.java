package client;

import java.rmi.RemoteException;

public class LoginController {
	
	public static LoginController instance;
	
	public boolean iniciarSesion(String email, String password) {
		try {
			return ServiceLocator.getInstance().getService().login(email, password);
		} catch(RemoteException e) {
			System.err.println(e);
			return false;
		}
	}
	
	
}
