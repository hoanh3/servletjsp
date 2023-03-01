package webdemo.mvc.services;

import webdemo.mvc.models.User;

public interface UserService {
	int insert(String fullname, String email, String password);
	User getUser(String email, String password);
}
