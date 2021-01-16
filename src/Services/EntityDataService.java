package Services;

import java.util.List;

import DTO.VueloAssembler;
import DTO.VueloDTO;
import dataBase.DB;

public class EntityDataService {
	private static EntityDataService instance;

	private EntityDataService() { }
	
	public static EntityDataService getInstance() {
		if (instance == null) {
			instance = new EntityDataService();
		}

		return instance;
	}

	public List<VueloDTO> getVuelos() {
		return VueloAssembler.getInstance().entityToDTO(DB.getInstance().getVuelos());
	}
}
