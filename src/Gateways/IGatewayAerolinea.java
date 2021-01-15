package Gateways;

import java.rmi.Remote;
import java.rmi.RemoteException;

import DTO.VueloDTO;

public interface IGatewayAerolinea extends Remote{
	
	public VueloDTO busquedavuelo(String aeropuertodestino, String aeropuertoorigen, String fecha_salida, int asientos_disponibles) throws RemoteException;
	public boolean reservavuelo(String codigovuelo, String nombre, int plazas) throws RemoteException;
	public VueloDTO getvuelo(String codigovuelo) throws RemoteException;

}
