package dataBase;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import Services.LoginService;

public class DB {
	private PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	private PersistenceManager pm = pmf.getPersistenceManager();				
	private Transaction transaction = pm.currentTransaction();
	private static DB instance;
	
	
	public DB() {
		super();
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}	
	
	public static DB getInstance() {
		if (instance == null) {
			instance = new DB();
		}

		return instance;
	}
	
}
