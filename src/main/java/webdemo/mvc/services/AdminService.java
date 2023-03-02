package webdemo.mvc.services;

import java.util.List;

import webdemo.mvc.models.Admin;

public interface AdminService {
	Admin getAdmin(String email, String password);
	int addAdmin(String name, String email, String password);
	List<Admin> getAll();
}
