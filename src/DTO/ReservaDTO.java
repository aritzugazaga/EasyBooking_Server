package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReservaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double precio;
	private List<String> nombre_pasajeros;
	private Date fecha;
	
	//NOTA: Falta el atributo para relacionar la Reserva con el vuelo y el Pago.
	
	
	//NOTA: No es necesario constructor. Usad el que se genera por defecto sin parámetros
	//y luego los métodos SET.
	public ReservaDTO(double precio, List<String> nombre_pasajeros, Date fecha) {
		super();
		this.precio = precio;
		this.nombre_pasajeros = nombre_pasajeros;
		this.fecha = fecha;
	}
	
	public ReservaDTO() {
		super();

	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<String> getNombre_pasajeros() {
		return nombre_pasajeros;
	}

	public void setNombre_pasajeros(List<String> nombre_pasajeros) {
		this.nombre_pasajeros = nombre_pasajeros;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void getReserva() {
		// TODO - implement Reserva.getReserva
		throw new UnsupportedOperationException();
	}

	public void anularReserva() {
		// TODO - implement Reserva.anularReserva
		throw new UnsupportedOperationException();
	}

	public void reservarVuelo() {
		// TODO - implement Reserva.reservarVuelo
		throw new UnsupportedOperationException();
	}
}
