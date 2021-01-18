package Gateways;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.VueloDTO;

public class GatewayIberia implements IGatewayAerolinea {
	
	private String IP;
	private int puerto;
	private String server;
	
	@Override
	public List<VueloDTO> busquedavuelo(String aeropuertodestino, String aeropuertoorigen) throws RemoteException {
		// TODO Auto-generated method stub
		List<VueloDTO> vuelos = new ArrayList<VueloDTO>();

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String servidor = IP + "," + puerto + "," + server;
			IGatewayAerolinea server = (IGatewayAerolinea) java.rmi.Naming.lookup(servidor);
			
			try {
				vuelos = server.busquedavuelo(aeropuertodestino, aeropuertoorigen);
				if (vuelos != null) {
					System.out.println("Los datos de busqueda de vuelo son correctos");
				}
				else {
					System.out.println("Los datos de busqueda de vuelo son incorrectos");
				}
			} catch (Exception e) {
				System.err.println("Excepcion: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return vuelos;
	}

	@Override
	public boolean reservavuelo(String codigovuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		boolean reserva = false;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String servidor = IP + "," + puerto + "," + server;
			IGatewayAerolinea server = (IGatewayAerolinea) java.rmi.Naming.lookup(servidor);
			
			try {
				reserva = server.reservavuelo(codigovuelo, nombre, plazas);
				if (reserva) {
					System.out.println("Los datos de reserva de vuelo son correctos");
				}
				else {
					System.out.println("Los datos de reserva de vuelo son incorrectos");
				}
			} catch (Exception e) {
				System.err.println("Excepcion: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return reserva;
	}
}
