package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade{
	
	private static RemoteFacade instance;

	protected RemoteFacade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFacade(/* args */);
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}

		return instance;
	}

	@Override
	public boolean login(String aEmail, String aPassword) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CategoryDTO> getCategories() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleDTO> getArticles(String aCategory) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean makeBid(long aArticle, float aBid) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
