package Gateways;

import java.rmi.RemoteException;

import DTO.VueloDTO;

public class GatewayIberia implements IGatewayAerolinea {
	
	private String IP;
	private int puerto;
	private String server;
	
	@Override
	public VueloDTO busquedavuelo(String aeropuertodestino, String aeropuertoorigen) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reservavuelo(String codigovuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VueloDTO getvuelo(String codigovuelo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
