package DTO;

import domainObjects.Usuario;

public class UsuarioAssembler {
	private static UsuarioAssembler instance;
	
	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}
	
	public UsuarioDTO entityToDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setEmail(usuario.getEmail());
		dto.setNombre(usuario.getNombre());
		
		return dto;
	}
}
