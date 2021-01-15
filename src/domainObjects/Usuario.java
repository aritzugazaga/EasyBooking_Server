package domainObjects;

import java.util.List;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Usuario {

	private String email;
	private boolean is_prime;
	private List<Reserva> reservas;

	//NOTA: Falta el aeropuerto por defecto, el sistema de autorización
	
	public Usuario(String email, boolean is_prime, List<Reserva> reservas) {
		super();
		this.email = email;
		this.is_prime = is_prime;
		this.reservas = reservas;
	}
	
	public Usuario() {
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