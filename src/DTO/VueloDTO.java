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
	private String codigovuelo;
	private String aeropuertoorigen;
	private String aeropuertodestino;
	private Date fecha_salida;
	private double precio_unitario;
	private int asientos_disponibles;
		
	public VueloDTO() {
		
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

	public String getCodigovuelo() {
		return codigovuelo;
	}

	public void setCodigovuelo(String codigovuelo) {
		this.codigovuelo = codigovuelo;
	}

	public String getAeropuertoorigen() {
		return aeropuertoorigen;
	}

	public void setAeropuertoorigen(String aeropuertoorigen) {
		this.aeropuertoorigen = aeropuertoorigen;
	}

	public String getAeropuertodestino() {
		return aeropuertodestino;
	}

	public void setAeropuertodestino(String aeropuertodestino) {
		this.aeropuertodestino = aeropuertodestino;
	}
}
