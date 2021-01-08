package DTO;

import java.io.Serializable;
import java.util.Date;

import domainObjects.Reserva;

public class TarjetaCreditoDTO extends PagoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numero_tarjeta;
	private String fecha_caducidad;
	private String titular;
	
	//NOTA: No es necesario constructor. Usad el que se genera por defecto sin parámetros
	//y luego los métodos SET.
	public TarjetaCreditoDTO(Date fecha_pago, Reserva reserva, String numero_tarjeta,
			String fecha_caducidad, String titular) {
		super(fecha_pago, reserva);
		this.numero_tarjeta = numero_tarjeta;
		this.fecha_caducidad = fecha_caducidad;
		this.titular = titular;
	}

	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public String getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(String fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
}
