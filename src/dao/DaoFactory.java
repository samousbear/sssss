package dao;

public class DaoFactory {

	public static IUserDAO getUserDAO(){
		return new IUserDAOImpl();
		
	}
}
