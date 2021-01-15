package domainObjects;

import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Pago {

	private Date fecha_pago;
	private Reserva reserva;

	//NOTA: No es necesario constructor. Usad el que se genera por defecto sin parámetros
	//y luego los métodos SET.
	public Pago(Date fecha_pago, Reserva reserva) {
		super();
		this.fecha_pago = fecha_pago;
		this.reserva = reserva;
	}
	
	public Pago() {
		super();
		
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}