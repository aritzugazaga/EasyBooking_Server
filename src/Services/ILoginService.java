package Services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Gateways.GatewayGoogle;
import Gateways.IGatewayLogin;

public class ILoginService {
	
	private List<IGatewayLogin> logins;
	
	public ILoginService() {
		logins = new ArrayList<IGatewayLogin>();
		GatewayGoogle google = new GatewayGoogle();
		logins.add(google);
	}
	
	public boolean login(String email, String contrasenya) throws RemoteException{
		return logins.get(0).login(email, contrasenya);
	}
	
	public void registrar(String email, String contrasenya) throws RemoteException{
		logins.get(0).registrar(email, contrasenya);
		
	}
}
