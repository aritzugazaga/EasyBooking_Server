package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginService extends Remote{
	public boolean registrarusuario(String nombre, String email, String contraseņa) throws RemoteException;
	public boolean login(String email, String contraseņa) throws RemoteException;
}
