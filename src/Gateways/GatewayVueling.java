package Gateways;

import java.rmi.RemoteException;
import java.util.List;

import DTO.VueloDTO;

public class GatewayVueling implements IGatewayAerolinea {

	@Override
	public List<VueloDTO> busquedavuelo(String aeropuertodestino, String aeropuertoorigen) throws RemoteException {
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
