package DTO;

public class PaypalAssembler {
	private static PaypalAssembler instance;
	
	private PaypalAssembler() { }
	
	public static PaypalAssembler getInstance() {
		if (instance == null) {
			instance = new PaypalAssembler();
		}

		return instance;
	}
	
}
