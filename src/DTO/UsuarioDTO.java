package DTO;

import java.io.Serializable;
import java.util.List;

import domainObjects.Reserva;

public class UsuarioDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private boolean is_prime;
	private List<Reserva> reservas;

	//NOTA: Falta el aeropuerto por defecto, el sistema de autorización
	
	public UsuarioDTO(String email, boolean is_prime, List<Reserva> reservas) {
		super();
		this.email = email;
		this.is_prime = is_prime;
		this.reservas = reservas;
	}
	
	public UsuarioDTO() {
		super();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_prime() {
		return is_prime;
	}

	public void setIs_prime(boolean is_prime) {
		this.is_prime = is_prime;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void registrarUsuario() {
		// TODO - implement Usuario.registrarUsuario
		throw new UnsupportedOperationException();
	}

	public void getUsuario() {
		// TODO - implement Usuario.getUsuario
		throw new UnsupportedOperationException();
	}

	public void borrarUsuario() {
		// TODO - implement Usuario.borrarUsuario
		throw new UnsupportedOperationException();
	}

	public void iniciarSesion() {
		// TODO - implement Usuario.iniciarSesion
		throw new UnsupportedOperationException();
	}
}
