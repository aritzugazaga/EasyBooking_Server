package DTO;

public class AerolineaAssembler {

	private static AerolineaAssembler instance;
	
	private AerolineaAssembler() { }
	
	public static AerolineaAssembler getInstance() {
		if (instance == null) {
			instance = new AerolineaAssembler();
		}

		return instance;
	}
	
	
	
}
