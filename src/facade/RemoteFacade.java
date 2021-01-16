package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.UsuarioDTO;
import DTO.VueloDTO;
import Services.AerolineaService;
import Services.LoginService;
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
	public void registrarUsuario(String aEmail, String aPassword) {
		// TODO Auto-generated method stub
		System.out.println(" *RemoteFacade register: " + aEmail + "/" + aPassword);
		LoginService.getInstance().registro(aEmail, aPassword);
		
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

	@Override
	public List<VueloDTO> getVuelos(String aeropuertoOrigen, String aeropuertoDestino, Date salida)
			throws RemoteException {
		System.out.println(" * RemoteFacade getVuelos: ");
		return AerolineaService.getInstance().getFlights();
		
	}

	@Override
	public boolean hacerReserva(VueloDTO vuelo, String email, boolean paymentmethod) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	

	

}
