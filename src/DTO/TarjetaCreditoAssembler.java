package DTO;

public class TarjetaCreditoAssembler {
	private static TarjetaCreditoAssembler instance;
	
	private TarjetaCreditoAssembler() { }
	
	public static TarjetaCreditoAssembler getInstance() {
		if (instance == null) {
			instance = new TarjetaCreditoAssembler();
		}

		return instance;
	}
	
}
