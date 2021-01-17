package client;

import java.rmi.RemoteException;

public class LoginController {
	
	public static LoginController instance;
	
	public boolean login(String email, String password) {
		try {
			return ServiceLocator.getInstance().getService().login(email, password);
		} catch(RemoteException e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean register(String email, String password) {
		try {
			return ServiceLocator.getInstance().getService().registrarUsuario(email, password);
		} catch(RemoteException e) {
			System.err.println(e);
			return false;
		}
	}
	
	public static LoginController getInstance() {
		if (instance == null) {
			try {
				instance = new LoginController();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return instance;
	
	}
}
