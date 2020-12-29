package easyBooking;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.jdo.*;

public class Main {
	public static void main(String[] args) {
		try {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try {
			    transaction.begin();
			    
			    List<Reserva> reservas1 = new ArrayList<Reserva>();
			    List<String> nombre_pasajeros1 = new ArrayList<String>();
			    nombre_pasajeros1.add("Aritz Zugazaga");
			    Date fecha1 = new Date(System.currentTimeMillis());
			    
			    //Creación de usuario
			    Usuario usuario1 = new Usuario();
			    usuario1.setEmail("aritzugazaga@gmail.com");
			    usuario1.setIs_prime(true);
			    usuario1.setReservas(reservas1);
			    
			    //Creación de vuelo
			    Vuelo vuelo1 = new Vuelo();
			    vuelo1.setAsientos_disponibles(100);
			    vuelo1.setFecha_salida(fecha1);
			    vuelo1.setPrecio_unitario(120.00);
			    vuelo1.setReservas(reservas1);
			    
			    //Creación de reserva
			    Reserva reserva1 = new Reserva();
			    reserva1.setFecha(fecha1);
			    reserva1.setNombre_pasajeros(nombre_pasajeros1);
			    reserva1.setPrecio(120.00);
			    
			    //Creación de pago
			    Pago pago1 = new Pago();
			    pago1.setFecha_pago(fecha1);
			    pago1.setReserva(reserva1);
			    
			    persistentManager.makePersistent(usuario1);
			    System.out.println("+ Inserted user into db: " + usuario1.getEmail());
			    
			    persistentManager.makePersistent(reserva1);
			    System.out.println("+ Inserted booking into db: " + reserva1.getFecha().toString());
			    
			    persistentManager.makePersistent(vuelo1);
			    System.out.println("+ Inserted fligth into db: " + vuelo1.getFecha_salida().toString());
			    
			    persistentManager.makePersistent(pago1);
			    System.out.println("+ Inserted pago into db: " + reserva1.getFecha().toString());
			    
			    transaction.commit();
			    
			} catch(Exception ex) {
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			} finally {		    
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    persistentManager.close();
			}
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try {
				transaction.begin();
	
			    @SuppressWarnings("unchecked")
				Query<Vuelo> vuelosQuery = persistentManager.newQuery("SELECT FROM " + Vuelo.class.getName() + " WHERE precio_unitario > 110.00 ORDER BY precio_unitario ASC");
			    
			    for (Vuelo vuelo : vuelosQuery.executeList()) {
			        System.out.println("? Selected fligth from db where fecha salida: " + vuelo.getFecha_salida().toString());
			    }
			    	
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception executing a query: " + ex.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    persistentManager.close();
			}
			
			//Update data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try {
				
				transaction.begin();
	
			    Query query = persistentManager.newQuery(Usuario.class, "email == 'aritzugazaga@gmail.com'");
			    Collection result = (Collection) query.execute();
			    Usuario usuario = (Usuario) result.iterator().next();
			    usuario.setEmail("zaratillo123@gmail.com");
			    System.out.println("? Updated fligth from db");
			        
			    	
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception executing a query: " + ex.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    persistentManager.close();
			}

			//Delete data using Extent
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			
			try {
				transaction.begin();
				
			    @SuppressWarnings("unchecked")
				Query<Vuelo> vuelosQuery = persistentManager.newQuery("SELECT FROM " + Vuelo.class.getName() + " WHERE precio_unitario > 110.00 ORDER BY precio_unitario ASC");
			    
			    for (Vuelo vuelo : vuelosQuery.executeList()) {
			        System.out.println("- Deleted fligth from db where fecha salida: " + vuelo.getFecha_salida().toString());
			        persistentManager.deletePersistent(vuelo);
			    }

				
				Extent<Reserva> reservaExtent = persistentManager.getExtent(Reserva.class);
			    
			    for (Reserva reserva : reservaExtent) {
			    	System.out.println("- Deleted reservation from db where fecha: " + reserva.getFecha().toString());
			    	persistentManager.deletePersistent(reserva);
			    }
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception deleting data from DB: " + ex.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
				
			    persistentManager.close();
			}
			
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}
}
