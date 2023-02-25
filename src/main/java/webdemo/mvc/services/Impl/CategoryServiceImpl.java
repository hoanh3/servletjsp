package webdemo.mvc.services.Impl;

import java.util.List;

import webdemo.mvc.DAO.CategoryDAO;
import webdemo.mvc.DAO.impl.CategoryDAOImpl;
import webdemo.mvc.models.Category;
import webdemo.mvc.services.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	private CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDAO.getAll();
	}
}
