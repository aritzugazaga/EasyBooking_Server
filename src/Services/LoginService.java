package Services;

import java.rmi.RemoteException;

import DTO.UsuarioDTO;
import dataBase.DB;
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
		Usuario usuario = DB.getInstance().getUsuario(email);
		
		if(usuario!= null && usuario.checkPassword(password)) {
			return usuario;
		}else {
			return null;
		}
		
	}
	
	public Usuario registro(String email, String password) {
		Usuario usuario = DB.getInstance().getUsuario(email);
		
		
		if(usuario == null) {
			DB.store(new Usuario(email, password));
			
		}
		
		return usuario;

	}
}
