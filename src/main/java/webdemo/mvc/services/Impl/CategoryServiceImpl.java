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

	@Override
	public int insertCategory(Category category) {
		return categoryDAO.insertCategory(category);
	}

	@Override
	public List<Category> getCategoryInPage(int pageId) {
		return categoryDAO.getCategoryInPage(pageId);
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryDAO.getCategoryById(id);
	}

	@Override
	public int updateCategory(Category category) {
		return categoryDAO.updateCategory(category);
	}

	@Override
	public int deleteCategory(int id) {
		return categoryDAO.deleteCategory(id);
	}

	@Override
	public int getNumOfCategory() {
		return categoryDAO.getNumOfCategory();
	}
}
