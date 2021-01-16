package Services;

public class AerolineaService {
	private static AerolineaService instance;
	
	private AerolineaService() {
	}

	public static AerolineaService getInstance() {
		if (instance == null) {
			instance = new AerolineaService();
		}

		return instance;
	}
}
