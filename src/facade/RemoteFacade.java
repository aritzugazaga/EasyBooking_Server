package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DTO.VueloDTO;
import Services.LoginService;
import Services.ReservaService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade{
	
	private static final long serialVersionUID = 1L;
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
		return LoginService.getInstance().login(aEmail, aPassword);
	}
	
	@Override
	public boolean registrarUsuario(String aEmail, String aPassword) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(" *RemoteFacade register: " + aEmail + "/" + aPassword);
		return LoginService.getInstance().registrar(aEmail, aPassword);
		
	}

	@Override
	public List<VueloDTO> getVuelos(String aeropuertoOrigen, String aeropuertoDestino) throws RemoteException {
		System.out.println(" * RemoteFacade getVuelos: ");
		return ReservaService.getInstance().buscarVuelo(aeropuertoOrigen, aeropuertoDestino);
		
	}

	@Override
	public boolean hacerReserva(VueloDTO vuelo, String email, boolean paymentmethod) throws RemoteException {
		return false;
	}

}
