package dataBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import Services.LoginService;
import domainObjects.Pago;
import domainObjects.Reserva;
import domainObjects.Usuario;
import domainObjects.Vuelo;

public class DB {
	private PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	private PersistenceManager pm = pmf.getPersistenceManager();				
	private Transaction transaction = pm.currentTransaction();
	private static DB instance;
	
	
	private DB() {
		super();
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}	
	
	public static DB getInstance() {
		if (instance == null) {
			instance = new DB();
		}

		return instance;
	}
	
	public void deleteData() {
		List<Usuario> usuarios = DB.getInstance().getUsuarios();
		
		for (Usuario usuario : usuarios) {
			DB.getInstance().deleteObjectFromDB(usuario);
		}
	}
	
	public void deleteObjectFromDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println(" * Delete an object: " + object);
			
			pm.deletePersistent(object);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	public void storeObjectInDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("  * Storing an object: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	public void store(Usuario usuario) {
		DB.getInstance().storeObjectInDB(usuario);	
	}
	
	public void store(Pago pago) {
		DB.getInstance().storeObjectInDB(pago);	
	}

	public void store(Reserva reserva) {
		DB.getInstance().storeObjectInDB(reserva);	
	}

	public void store(Vuelo vuelo) {
		DB.getInstance().storeObjectInDB(vuelo);
	}
	
	public Vuelo getVuelo(String codigovuelo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Vuelo vuelo = null; 

		try {
			System.out.println("  * Querying an Vuelo by codigovuelo: " + codigovuelo);
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Vuelo.class.getName() + " WHERE codigovuelo == " + codigovuelo);
			query.setUnique(true);
			vuelo = (Vuelo) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Vuelo: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return vuelo;
	}

	public List<Vuelo> getVuelos() {
		List<Vuelo> vuelos = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all vuelos");

			tx.begin();
			
			Extent<Vuelo> extent = pm.getExtent(Vuelo.class, true);

			for (Vuelo vuelo : extent) {
				vuelos.add(vuelo);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all Vuelos: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return vuelos;		
	}

	
	public Usuario getUsuario(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Usuario usuario = null; 

		try {
			System.out.println("  * Querying a Usuario by email: " + email);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			usuario = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuario;
	}
	
	public List<Usuario> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		List<Usuario> usuarios = new ArrayList<>(); 

		try {
			System.out.println("  * Querying all usuarios");
			tx.begin();
			
			Extent<Usuario> usuarioExtent = pm.getExtent(Usuario.class, true);
			
			for (Usuario usuario : usuarioExtent) {
				usuarios.add(usuario);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all usuarios: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;
	}
	private void initializeData() {
		System.out.println(" * Initializing data base");
		//Create Sample data
		Usuario usuario0 = new Usuario();
		usuario0.setEmail("Iker.01@gmail.com");
		usuario0.setNombre("Iker");
		
						
		Usuario usuario1 = new Usuario();
		usuario1.setEmail("Anagu@gmail.com");
		usuario1.setNombre("Ana");
		
		Usuario usuario2 = new Usuario();
		usuario2.setEmail("Mikelgl@gmail.com");
		usuario2.setNombre("Mikel");
		
		
		Vuelo Italia = new Vuelo();
		Italia.setCodigovuelo("112");
		Italia.setAeropuertoorigen("Bilbao");
		Italia.setAeropuertodestino("Italia");
		Italia.setFecha_salida("2020-02-22");
		Italia.setPrecio_unitario(50.00);
		Italia.setAsientos_disponibles(2);
		
		Vuelo Brasil = new Vuelo();
		Brasil.setCodigovuelo("113");
		Brasil.setAeropuertoorigen("Bilbao");
		Brasil.setAeropuertodestino("Brasil");
		Brasil.setFecha_salida("2020/07/22");
		Brasil.setPrecio_unitario(70.30);
		Brasil.setAsientos_disponibles(7);
		
		
		Vuelo China = new Vuelo();
		China.setCodigovuelo("114");
		China.setAeropuertoorigen("Brasil");
		China.setAeropuertodestino("China");
		China.setFecha_salida("2021/02/22");
		China.setPrecio_unitario(199.30);
		China.setAsientos_disponibles(4);
		
		
		usuario2.addVuelo("Brasil");
		usuario2.addVuelo("China");
		usuario1.addVuelo("Brasil");
		usuario0.addVuelo("Italia");
		try {
			//Store users in DB
			DB.getInstance().store(usuario0);
			DB.getInstance().store(usuario1);
			DB.getInstance().store(usuario2);
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
