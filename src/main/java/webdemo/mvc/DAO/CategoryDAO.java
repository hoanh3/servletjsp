package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Category;

public interface CategoryDAO {
	List<Category> getAll();
}
