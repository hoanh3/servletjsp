package webdemo.mvc.services;

import java.util.List;

import webdemo.mvc.models.Admin;

public interface AdminService {

	int deleteAdmin(int id);
	int updateAdmin(Admin admin);
	

	Admin getAdminById(int id);
	
	List<Admin> getAdminInPage(int pageId);
	int getNumOfAdmin();
	Admin getAdmin(String email, String password);
	int addAdmin(String name, String email, String password);
	List<Admin> getAll();
}
