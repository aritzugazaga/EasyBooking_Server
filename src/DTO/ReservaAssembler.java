package DTO;

public class ReservaAssembler {
	private static ReservaAssembler instance;
	
	private ReservaAssembler() { }
	
	public static ReservaAssembler getInstance() {
		if (instance == null) {
			instance = new ReservaAssembler();
		}

		return instance;
	}
}
