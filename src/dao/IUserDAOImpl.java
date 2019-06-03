package dao;

import java.util.List;


import com.woniu.utils.BaseDao;

import bean.User;



public class IUserDAOImpl implements IUserDAO {
	BaseDao bd = new BaseDao();
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user values(null,?,?,?,?,?)";
		Object[] objs = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUstate(),user.getUphoto()};
		bd.update(sql, objs);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "update t_user set Uname=?,Upwd=?,Urole=?,Ustate=?,Uphoto=? where Uid=?";
		Object[] objs = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUstate(),user.getUphoto(),user.getUid()};
		bd.update(sql, objs);	
	}

	@Override
	public void delete(Integer Uid) {
		// TODO Auto-generated method stub
		String sql = "delete  from t_user where Uid=?";
		Object[] objs = {Uid};
		bd.update(sql, objs);
	}

	@Override
	public User selectOne(Integer Uid) {
		String sql = "select * from t_user where Uid=?";
		Object[] objs = {Uid};
		List<User> list = bd.selct(sql, objs, User.class);
		return list.size()!=0?list.get(0):null;
	}
	
	@Override
	public User login(String Uname,String Upwd) {
		String sql = "select * from t_user where Uname=? and Upwd=?";
		Object[] objs = {Uname,Upwd};
		List<User> list = bd.selct(sql, objs, User.class);
		return list.size()!=0?list.get(0):null;
	}

	@Override
	public List<User> selectAll() {
		String sql = "select * from t_user";
		Object[] objs = {};
		List<User> users = bd.selct(sql, objs, User.class);
		return users;
	}

	@Override
	public User getUserByUname(String uname) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where Uname=?";
		Object[] objs = {uname};
		List<User> list = bd.selct(sql, objs, User.class);
		return list.size()!=0?list.get(0):null;
	}

	

}
