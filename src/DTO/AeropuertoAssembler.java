package DTO;

public class AeropuertoAssembler {
	private static AeropuertoAssembler instance;
	
	private AeropuertoAssembler() { }
	
	public static AeropuertoAssembler getInstance() {
		if (instance == null) {
			instance = new AeropuertoAssembler();
		}

		return instance;
	}
	
}
