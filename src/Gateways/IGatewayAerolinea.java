package Gateways;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import DTO.VueloDTO;

public interface IGatewayAerolinea extends Remote{
	
	public List<VueloDTO> busquedavuelo(String aeropuertodestino, String aeropuertoorigen) throws RemoteException;
	public boolean reservavuelo(String codigovuelo, String nombre, int plazas) throws RemoteException;

}
