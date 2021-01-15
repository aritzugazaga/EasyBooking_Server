package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import domainObjects.Reserva;

public class VueloDTO implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fecha_salida;
	private double precio_unitario;
	private int asientos_disponibles;
	private List<Reserva> reservas;
		
	public VueloDTO(Date fecha_salida, double precio_unitario, int asientos_disponibles,
			List<Reserva> reservas) {
		super();
		this.fecha_salida = fecha_salida;
		this.precio_unitario = precio_unitario;
		this.asientos_disponibles = asientos_disponibles;
		this.reservas = reservas;
	}
		
	public VueloDTO() {
		super();

	}
		
	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public int getAsientos_disponibles() {
		return asientos_disponibles;
	}

	public void setAsientos_disponibles(int asientos_disponibles) {
		this.asientos_disponibles = asientos_disponibles;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void getVuelo() {
		// TODO - implement Vuelo.getVuelo
		throw new UnsupportedOperationException();
	}

	public void busquedaVuelos() {
		// TODO - implement Vuelo.busquedaVuelos
		throw new UnsupportedOperationException();
	}
}
