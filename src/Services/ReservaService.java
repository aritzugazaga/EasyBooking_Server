package Services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.VueloDTO;
import Gateways.FactoryGateway;
import Gateways.IGatewayAerolinea;

public class ReservaService { 
	
	private static ReservaService instance;
	
	private List<IGatewayAerolinea> aerolineas = new ArrayList<IGatewayAerolinea>();

	public ReservaService() {
		// TODO Auto-generated constructor stub
		FactoryGateway factory = new FactoryGateway();
		aerolineas = factory.getgatewaysaerolineas();	
	}
	
	public List<VueloDTO> buscarVuelo(String aeropuertodestino, String aeropuertoorigen) throws RemoteException{
		List<VueloDTO> vuelos = new ArrayList<VueloDTO>();
		for(IGatewayAerolinea aerolinea : aerolineas) {
			List<VueloDTO> flights = aerolinea.busquedavuelo(aeropuertodestino, aeropuertoorigen);
			for(VueloDTO v : flights) {
				vuelos.add(v);
			}
		}
		return vuelos;
	}
	
	public boolean reservaVuelo(String codigovuelo, String nombre, int plazas) throws RemoteException{
		for(IGatewayAerolinea aerolinea : aerolineas) {
			if(aerolinea.reservavuelo(codigovuelo, nombre, plazas) == true) return true;
		}
		return false;
	}
	
	public static ReservaService getInstance() {
		if (instance == null) {
			instance = new ReservaService();
		}

		return instance;
	}
}
