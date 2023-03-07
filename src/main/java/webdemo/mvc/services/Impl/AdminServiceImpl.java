package webdemo.mvc.services.Impl;

import java.util.List;

import webdemo.mvc.DAO.AdminDAO;
import webdemo.mvc.DAO.impl.AdminDAOImpl;
import webdemo.mvc.models.Admin;
import webdemo.mvc.services.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDAO = new AdminDAOImpl();
	

	@Override
	public Admin getAdmin(String email, String password) {
		return adminDAO.getAdmin(email, password);
	}


	@Override
	public int addAdmin(String name, String email, String password) {
		Admin admin = new Admin(0, name, email, password, 1);
		return adminDAO.addAdmin(admin);
	}


	@Override
	public List<Admin> getAll() {
		return adminDAO.getAll();
	}


	@Override
	public List<Admin> getAdminInPage(int pageId) {
		return adminDAO.getAdminInPage(pageId);
	}


	@Override
	public int getNumOfAdmin() {
		// TODO Auto-generated method stub
		return adminDAO.getNumOfAdmin();
	}


	@Override
	public int deleteAdmin(int id) {
		return adminDAO.deleteAdmin(id);
	}


	@Override
	public int updateAdmin(Admin admin) {
		return adminDAO.updateAdmin(admin);
	}


	@Override
	public Admin getAdminById(int id) {
		return adminDAO.getAdminById(id);
	}

}
