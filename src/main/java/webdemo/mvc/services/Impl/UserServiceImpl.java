package webdemo.mvc.services.Impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import webdemo.mvc.DAO.UserDAO;
import webdemo.mvc.DAO.impl.UserDAOImpl;
import webdemo.mvc.models.Role;
import webdemo.mvc.models.User;
import webdemo.mvc.services.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public User getUser(String email, String password) {
		return userDAO.getUser(email, password);
	}

	@Override
	public int insert(String fullname, String email, String password) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		date = new java.sql.Date(calendar.getTimeInMillis());
		User user = new User(0, fullname, email, password, "", "", new Role(), date, date, 1);
		return userDAO.insert(user);
	}

	@Override
	public int deleteUser(int id) {
		return userDAO.deleteUser(id);
	}

	@Override
	public int updateUser(User user) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		date = new java.sql.Date(calendar.getTimeInMillis());
		user.setUpdateAt(date);
		return userDAO.updateUser(user);
	}

	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Override
	public List<User> getUserInPage(int pageId) {
		return userDAO.getUserInPage(pageId);
	}

	@Override
	public int getNumOfUser() {
		return userDAO.getNumOfUser();
	}
	
}
