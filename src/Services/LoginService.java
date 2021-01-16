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
	/*	Usuario usuario = DB.getInstance().getUser(email);
		
		if(usuario!= null && usuario.chekPassword(password)) {
			return usuario;
		}else {
			return null;
		}*/Usuario us = new Usuario();
		return us;
	}
	
	public void registro(String email, String password) {
		Usuario user = DB.getInstance().getUser(email);
		
		if(user == null) {
			DB.store(new Usuario(email, password));
		}

	}
}
