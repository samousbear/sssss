package service;

import java.util.List;

import bean.User;





public interface IUserService {
	void reg(User user);
	void addUser(User user);
	List<User> GetAllUsers();
	User getUserByUname(String uname);
	void updateUser(User user);
	User getUserByUid(int Uid);
	void delUser(Integer Uid);
	
}
