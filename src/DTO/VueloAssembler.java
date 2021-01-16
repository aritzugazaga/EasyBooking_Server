package DTO;

import java.util.ArrayList;
import java.util.List;

import domainObjects.Vuelo;

public class VueloAssembler {
	private static VueloAssembler instance;
	
	private VueloAssembler() { }
	
	public static VueloAssembler getInstance() {
		if (instance == null) {
			instance = new VueloAssembler();
		}

		return instance;
	}
	
	public VueloDTO entityToDTO(Vuelo vuelo) {
		VueloDTO dto = new VueloDTO();		
		dto.setCodigovuelo(vuelo.getCodigovuelo());
		dto.setAeropuertoorigen(vuelo.getAeropuertoorigen());
		dto.setAeropuertodestino(vuelo.getAeropuertodestino());
		dto.setFecha_salida(vuelo.getFecha_salida());
		dto.setPrecio_unitario(vuelo.getPrecio_unitario());
		dto.setAsientos_disponibles(vuelo.getAsientos_disponibles());
		return dto;
	}

	public List<VueloDTO> entityToDTO(List<Vuelo> vuelos) {		
		List<VueloDTO> dtos = new ArrayList<>();
		
		for (Vuelo vuelo : vuelos) {
			dtos.add(this.entityToDTO(vuelo));
		}
		
		return dtos;
	}
}
