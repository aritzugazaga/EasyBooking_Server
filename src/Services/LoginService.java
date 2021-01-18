package Services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Gateways.GatewayGoogle;
import Gateways.IGatewayLogin;

public class LoginService {
	
	private static LoginService instance;
	
	private List<IGatewayLogin> logins;
	
	public LoginService() {
		logins = new ArrayList<IGatewayLogin>();
		GatewayGoogle google = new GatewayGoogle();
		logins.add(google);
	}
	
	public boolean login(String email, String contrasenya) throws RemoteException{
		return logins.get(0).login(email, contrasenya);
	}
	
	public boolean registrar(String email, String contrasenya) throws RemoteException{
		return logins.get(0).registrar(email, contrasenya);
		
	}
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}

		return instance;
	}
}
