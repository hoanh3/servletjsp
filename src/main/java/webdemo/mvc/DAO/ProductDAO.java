package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Product;

public interface ProductDAO {
	
	List<Product> getAll();
}
