package DTO;

import java.io.Serializable;
import java.util.Date;

import domainObjects.Reserva;

public class PaypalDTO extends PagoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;

	//NOTA: No es necesario constructor. Usad el que se genera por defecto sin parámetros
	//y luego los métodos SET.
	public PaypalDTO(Date fecha_pago, Reserva reserva, String email) {
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
