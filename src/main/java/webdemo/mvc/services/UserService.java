package webdemo.mvc.services;

import java.util.List;

import webdemo.mvc.models.User;

public interface UserService {
	int insert(String fullname, String email, String password);
	User getUser(String email, String password);
	

	int deleteUser(int id);
	int updateUser(User user);
	
	User getUserById(int id);
	
	List<User> getUserInPage(int pageId);
	int getNumOfUser();

	int getLastestUserId();
}
