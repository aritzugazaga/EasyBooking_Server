package Gateways;

import java.rmi.RemoteException;

import DTO.VueloDTO;

public class GatewayVueling implements IGatewayAerolinea {

	@Override
	public VueloDTO busquedavuelo(String aeropuertodestino, String aeropuertoorigen, String fecha_salida,
			int asientos_disponibles) throws RemoteException {
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
