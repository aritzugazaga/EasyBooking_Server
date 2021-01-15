package DTO;

public class PagoAssembler {
	private static PagoAssembler instance;
	
	private PagoAssembler() { }
	
	public static PagoAssembler getInstance() {
		if (instance == null) {
			instance = new PagoAssembler();
		}

		return instance;
	}
	
}
