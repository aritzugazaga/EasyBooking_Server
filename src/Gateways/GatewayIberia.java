package Gateways;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.VueloDTO;
import server.remote.IIberia;

public class GatewayIberia implements IGatewayAerolinea {
	
	private String IP = "127.0.0.1";
	private int puerto = 1099;
	private String server = "Iberia";
	private IIberia iberia;
	
	public GatewayIberia() {
		try {
			String servidor = "//" + IP + ":" + puerto + "/" + server;
			iberia = (IIberia) java.rmi.Naming.lookup(servidor);
		}catch(Exception e) {
			System.err.println("Excepcion: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public List<VueloDTO> busquedavuelo(String aeropuertodestino, String aeropuertoorigen) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<VueloDTO> a = new ArrayList<VueloDTO>();
		for(server.data.dto.VueloDTO v : iberia.busquedavuelo(aeropuertoorigen, aeropuertodestino)) {
			a.add(cambiodto(v));
		}
		return a;
	}

	@Override
	public boolean reservavuelo(String codigovuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		return iberia.reservavuelo(codigovuelo, nombre, plazas);
	}
	
	private VueloDTO cambiodto(server.data.dto.VueloDTO vr) throws RemoteException  {
		if (vr != null) {
			VueloDTO v = new VueloDTO();
			v.setAeropuertodestino(vr.getAeropuertodestino());
			v.setAeropuertoorigen(vr.getAeropuertoorigen());
			v.setFecha_salida(vr.getFecha_salida());
			v.setAsientos_disponibles(vr.getAsientos_disponibles());
			v.setCodigovuelo(vr.getCodigovuelo());
			v.setPrecio_unitario(60);
			return v;
		} else {
		return null;
		}
	}
}
