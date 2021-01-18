package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

import DTO.VueloDTO;

public interface IRemoteFacade extends Remote{
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public boolean registrarUsuario(String aEmail, String aPassword) throws RemoteException;
	public List<VueloDTO> getVuelos(String aeropuertoOrigen, String aeropuertoDestino) throws RemoteException;
	public boolean hacerReserva(VueloDTO vuelo, String email, boolean paymentmethod) throws RemoteException;
}
