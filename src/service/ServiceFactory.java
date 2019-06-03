package service;

public class ServiceFactory {
	public static IUserService getUserService(){
		return  new IUserServiceImpl();
	}
}
