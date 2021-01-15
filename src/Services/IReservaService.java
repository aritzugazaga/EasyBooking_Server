package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import DTO.UsuarioDTO;
import DTO.ReservaDTO;
import DTO.VueloDTO;

public interface IReservaService extends Remote{
	List<VueloDTO> buscarVuelos(String origen, String destino, int numeroplazas) throws RemoteException;
	boolean realizarReserva(ReservaDTO reservarealizada, int numeroplazas) throws RemoteException;
	List<ReservaDTO> getReservas(UsuarioDTO usuario) throws RemoteException;
}
