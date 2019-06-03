package dao;

import java.util.List;

import bean.User;






public interface IUserDAO {
	void save(User user);
	void update(User user);
	void delete(Integer Uid);
	User selectOne(Integer Uid);
	User login(String Uname,String Upwd);
	List<User> selectAll();
	User getUserByUname(String uname);
	
	
}
