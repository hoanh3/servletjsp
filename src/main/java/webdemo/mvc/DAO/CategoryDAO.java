package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Category;

public interface CategoryDAO {
	List<Category> getAll();
	
	int insertCategory(Category category);
	List<Category> getCategoryInPage(int pageId);
	Category getCategoryById(int id);
	int updateCategory(Category category);
	int deleteCategory(int id);
	int getNumOfCategory();
}
