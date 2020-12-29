package easyBooking;
public class Aeropuerto {

	private int codigo_aeropuerto;
	private String ciudad;
	private int numero_puertas_embarque;
	
	//NOTA: No es necesario constructor. Usad el que se genera por defecto sin parámetros
	//y luego los métodos SET.
	public Aeropuerto(int codigo_aeropuerto, String ciudad, int numero_puertas_embarque) {
		super();
		this.codigo_aeropuerto = codigo_aeropuerto;
		this.ciudad = ciudad;
		this.numero_puertas_embarque = numero_puertas_embarque;
	}
	
	public int getCodigo_aeropuerto() {
		return codigo_aeropuerto;
	}
	public void setCodigo_aeropuerto(int codigo_aeropuerto) {
		this.codigo_aeropuerto = codigo_aeropuerto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getNumero_puertas_embarque() {
		return numero_puertas_embarque;
	}
	public void setNumero_puertas_embarque(int numero_puertas_embarque) {
		this.numero_puertas_embarque = numero_puertas_embarque;
	}
	
	

}