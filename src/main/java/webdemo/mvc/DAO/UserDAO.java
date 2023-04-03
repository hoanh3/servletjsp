package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Admin;
import webdemo.mvc.models.User;

public interface UserDAO {
	
	int insert(User user);
	
	User getUser(String email, String password);
	
	int deleteUser(int id);
	int updateUser(User user);
	
	User getUserById(int id);
	
	List<User> getUserInPage(int pageId);
	int getNumOfUser();
	int getLastestUserId();
}
