package Gateways;

import java.rmi.RemoteException;

public class GatewayPaypal implements IGatewayPago {
	
	private String IP;
	private int puerto;
	private String server;

	@Override
	public boolean pagar(int precio_unitario, String email, String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		boolean pago = false;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String servidor = IP + "," + puerto + "," + server;
			IGatewayPago server = (IGatewayPago) java.rmi.Naming.lookup(servidor);
			
			try {
				pago = server.pagar(precio_unitario, email, codigo);
				if (pago) {
					System.out.println("Los datos de pago son correctos");
				}
				else {
					System.out.println("Los datos de pago son incorrectos");
				}
			} catch (Exception e) {
				System.err.println("Excepcion: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return pago;
	}

	@Override
	public boolean tienedinero(int precio_unitario, String email, String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		boolean tienedinero = false;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String servidor = IP + "," + puerto + "," + server;
			IGatewayPago server = (IGatewayPago) java.rmi.Naming.lookup(servidor);
			
			try {
				tienedinero = server.tienedinero(precio_unitario, email, codigo);
				if (tienedinero) {
					System.out.println("Hay fondos para pagar");
				}
				else {
					System.out.println("No hay fondos suficientes para pagar");
				}
			} catch (Exception e) {
				System.err.println("Excepcion: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return tienedinero;
	}

}
