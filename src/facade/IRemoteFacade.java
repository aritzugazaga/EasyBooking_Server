package facade;

import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteFacade {
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public List<CategoryDTO> getCategories() throws RemoteException;
	public List<ArticleDTO> getArticles(String aCategory) throws RemoteException;
	public boolean makeBid(long aArticle, float aBid) throws RemoteException;
}
