package easyBooking;

import java.util.Date;

public class Paypal extends Pago {
	
	private String email;

	//NOTA: No es necesario constructor. Usad el que se genera por defecto sin parámetros
	//y luego los métodos SET.
	public Paypal(Date fecha_pago, Reserva reserva, String email) {
		super(fecha_pago, reserva);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}