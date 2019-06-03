package service;

import java.util.List;

import bean.User;
import dao.DaoFactory;





public class IUserServiceImpl implements IUserService {

	@Override
	public void reg(User user) {
		user.setUrole("普通用户");
		user.setUstate("可用");
		DaoFactory.getUserDAO().save(user);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		user.setUrole("普通用户");
		user.setUstate("可用");
		DaoFactory.getUserDAO().save(user);
	}

	@Override
	public List<User> GetAllUsers() {
		// TODO Auto-generated method stub
		return DaoFactory.getUserDAO().selectAll();
	}

	@Override
	public User getUserByUname(String uname) {
		// TODO Auto-generated method stub
		return DaoFactory.getUserDAO().getUserByUname(uname);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		DaoFactory.getUserDAO().update(user);
	}

	@Override
	public User getUserByUid(int Uid) {
		// TODO Auto-generated method stub
		return DaoFactory.getUserDAO().selectOne(Uid);
	}

	@Override
	public void delUser(Integer Uid) {
		// TODO Auto-generated method stub
		
		DaoFactory.getUserDAO().delete(Uid);
	}


	

}
