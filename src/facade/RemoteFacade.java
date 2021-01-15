package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DTO.UsuarioDTO;
import DTO.VueloDTO;
import domainObjects.Usuario;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade{
	
	private static RemoteFacade instance;
	

	protected RemoteFacade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFacade(/* args */);
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}

		return instance;
	}

	@Override
	public boolean login(String aEmail, String aPassword) throws RemoteException {
		System.out.println(" *RemoteFacade login: " + aEmail + "/" + aPassword);
		Usuario usuario = LoginService.getInstance().login(aEmail, aPassword);
		return usuario != null;
	}

	@Override
	public ArrayList<VueloDTO> getVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hacerReserva() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
