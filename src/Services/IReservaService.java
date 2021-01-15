package Services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.VueloDTO;
import Gateways.FactoryGateway;
import Gateways.IGatewayAerolinea;

public class IReservaService { 
	
	private List<IGatewayAerolinea> aerolineas = new ArrayList<IGatewayAerolinea>();

	
	public IReservaService() {
		// TODO Auto-generated constructor stub
		FactoryGateway factory = new FactoryGateway();
		aerolineas = factory.getgatewaysaerolineas();	
	}
	
	public List<VueloDTO> buscarVuelo(String aeropuertodestino, String aeropuertoorigen, String fecha_salida, int asientos_disponibles) throws RemoteException{
		List<VueloDTO> vuelo = new ArrayList<VueloDTO>();
		for(IGatewayAerolinea aerolinea : aerolineas) {
			VueloDTO v = aerolinea.busquedavuelo(aeropuertodestino, aeropuertoorigen, fecha_salida, asientos_disponibles);
			if(v != null) {
				vuelo.add(v);
			}
		}
		return vuelo;
	}
	
	public VueloDTO getVuelo(String codigovuelo) throws RemoteException{
		for(IGatewayAerolinea aerolinea : aerolineas) {
			if(aerolinea.getvuelo(codigovuelo) != null) return aerolinea.getvuelo(codigovuelo);
		}
		return null;
	}
	
	public boolean reservavuelo(String codigovuelo, String nombre, int plazas) throws RemoteException{
		for(IGatewayAerolinea aerolinea : aerolineas) {
			if(aerolinea.reservavuelo(codigovuelo, nombre, plazas) == true) return true;
		}
		return false;
	}
}
