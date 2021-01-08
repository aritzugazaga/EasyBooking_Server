package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;

import DTO.PaypalDTO;
import DTO.TarjetaCreditoDTO;

public interface IPagoService extends Remote{
	public boolean realizarPagoPaypal(PaypalDTO paypalorigen, PaypalDTO paypaldestino, double importe, String concepto) throws RemoteException;
	public boolean realizarPagoCreditCard(TarjetaCreditoDTO tarjetacreditoorigen, TarjetaCreditoDTO tarjetacreditodestino, double importe, String concepto) throws RemoteException;
}
