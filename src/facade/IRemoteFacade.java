package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.UsuarioDTO;
import DTO.VueloDTO;

public interface IRemoteFacade extends Remote{
	 boolean login(String aEmail, String aPassword) throws RemoteException;
	//public List<CategoryDTO> getCategories() throws RemoteException;
	//public List<ArticleDTO> getArticles(String aCategory) throws RemoteException;
	//public boolean makeBid(long aArticle, float aBid) throws RemoteException;
	ArrayList <VueloDTO> getVuelos() throws RemoteException;
	String hacerReserva() throws RemoteException;
	//
	public void registrarUsuario(String aEmail, String aPassword);
	public List<VueloDTO> getVuelos(String aeropuertoOrigen, String aeropuertoDestino, Date salida) throws RemoteException;
	public boolean hacerReserva(VueloDTO vuelo, String email, boolean paymentmethod) throws RemoteException;
}
