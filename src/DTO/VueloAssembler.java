package DTO;

public class VueloAssembler {
	private static VueloAssembler instance;
	
	private VueloAssembler() { }
	
	public static VueloAssembler getInstance() {
		if (instance == null) {
			instance = new VueloAssembler();
		}

		return instance;
	}
	
}
