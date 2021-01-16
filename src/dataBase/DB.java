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
	
	public static void store(Usuario usuario) {
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
	
}
