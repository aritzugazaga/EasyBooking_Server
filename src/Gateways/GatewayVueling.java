package Gateways;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.VueloDTO;

public class GatewayVueling implements IGatewayAerolinea {
	
	//
	private String IP = "127.0.0.1";
	private int puerto = 1024;
	private Socket socket;
	
	public GatewayVueling() {
		try(Socket tcpsocket = new Socket(IP,puerto)){
			System.out.println("Socket creado");
		}catch(UnknownHostException e){
			System.err.println("Socket error: " + e.getMessage());
		}catch(EOFException e) {
			System.err.println("EOF error: " + e.getMessage());
		}catch(IOException e) {
			System.err.println("IO error: " + e.getMessage());
		}
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<VueloDTO> busquedavuelo(String aeropuertodestino, String aeropuertoorigen) throws RemoteException {
		// TODO Auto-generated method stub
		String datos = aeropuertodestino + "," + aeropuertoorigen;
		System.out.println(datos);
		List<VueloDTO> busqueda = new ArrayList<>();
		try (Socket tcpSocket = new Socket(IP, puerto);
			ObjectInputStream in = new ObjectInputStream(tcpSocket.getInputStream());
			DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			out.writeUTF(datos);
			ArrayList<VueloDTO> vueling =new ArrayList<VueloDTO>();
			vueling =  (ArrayList<VueloDTO>) in.readObject();
			
			
			VueloDTO v = new VueloDTO();
			for(int i = 0; i< vueling.size(); i++) {
				v.setCodigovuelo(vueling.get(i).getCodigovuelo());
				v.setAeropuertoorigen(vueling.get(i).getAeropuertoorigen());
				v.setAeropuertodestino(vueling.get(i).getAeropuertodestino());
				v.setAsientos_disponibles(vueling.get(i).getAsientos_disponibles());
				v.setFecha_salida(vueling.get(i).getFecha_salida());
				v.setPrecio_unitario(vueling.get(i).getPrecio_unitario());		
				busqueda.add(v);
			}
		}catch (UnknownHostException e) {
			System.err.println("Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return busqueda;
	}

	@Override
	public boolean reservavuelo(String codigovuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		String datos = codigovuelo + "," + nombre + "," + plazas;
		boolean reserva = false;
		try {
			System.out.println(IP+","+puerto);
			socket = new Socket(IP, puerto);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			DataInputStream in = new DataInputStream(socket.getInputStream());
			out.writeUTF(datos);
			System.out.println("Metodo reservarVuelo" +in);
			reserva = Boolean.parseBoolean(in.readUTF());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(UnknownHostException e){
				System.err.println("Socket error: " + e.getMessage());
			}catch(EOFException e) {
				System.err.println("EOF error: " + e.getMessage());
			}catch(IOException e) {
				System.err.println("IO error: " + e.getMessage());
			}
		}
		return reserva;
	}
}
