package webdemo.mvc.DAO;

import webdemo.mvc.models.User;

public interface UserDAO {
	
	int insert(User user);
	
	User getUser(String email, String password);
}
