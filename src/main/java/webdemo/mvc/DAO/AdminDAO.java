package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Admin;
import webdemo.mvc.models.User;

public interface AdminDAO {
	
	List<Admin> getAll();
	Admin getAdmin(String email, String password);
	int addAdmin(Admin admin);
}
