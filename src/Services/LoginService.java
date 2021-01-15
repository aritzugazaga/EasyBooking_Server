package Services;

import java.rmi.RemoteException;

import DTO.UsuarioDTO;
import domainObjects.Usuario;

public class LoginService {
	private static LoginService instance;
	
	private LoginService() {
	}

	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}

		return instance;
	}

	public Usuario login(String email, String password) {
		Usuario usuario = DBHandler.getInstance().getUser(email);
		
		if(usuario!= null && usuario.chekPassword(password)) {
			return usuario;
		}else {
			return null;
		}
	}
}
