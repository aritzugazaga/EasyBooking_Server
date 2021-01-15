package DTO;

public class UsuarioAssembler {
	private static UsuarioAssembler instance;
	
	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}
	
}
