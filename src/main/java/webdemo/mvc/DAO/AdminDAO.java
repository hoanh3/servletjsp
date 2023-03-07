package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Admin;
import webdemo.mvc.models.User;

public interface AdminDAO {
	
	int deleteAdmin(int id);
	int updateAdmin(Admin admin);
	
	Admin getAdminById(int id);
	
	List<Admin> getAdminInPage(int pageId);
	int getNumOfAdmin();
	List<Admin> getAll();
	Admin getAdmin(String email, String password);
	int addAdmin(Admin admin);
}
