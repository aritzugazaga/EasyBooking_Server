package DTO;

import java.io.Serializable;

public class AerolineaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo_aerolinea;
	private String nombre;
	
	//NOTA: No es necesario constructor. Usad el que se genera por defecto sin parámetros
	//y luego los métodos SET.
	public AerolineaDTO(int codigo_aerolinea, String nombre) {
		super();
		this.codigo_aerolinea = codigo_aerolinea;
		this.nombre = nombre;
	}
	
	public int getCodigo_aerolinea() {
		return codigo_aerolinea;
	}
	public void setCodigo_aerolinea(int codigo_aerolinea) {
		this.codigo_aerolinea = codigo_aerolinea;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}


