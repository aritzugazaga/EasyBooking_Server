package domainObjects;
public class Aeropuerto {

	private String codigo_aeropuerto;
	private String ciudad;
	private int numero_puertas_embarque;
	
	public Aeropuerto(String codigoAeropuertos, String ciudad) {
		this.codigo_aeropuerto = codigoAeropuertos;
		this.ciudad = ciudad;
	}
	
	public String getCodigo_aeropuerto() {
		return codigo_aeropuerto;
	}
	public void setCodigo_aeropuerto(String codigo_aeropuerto) {
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