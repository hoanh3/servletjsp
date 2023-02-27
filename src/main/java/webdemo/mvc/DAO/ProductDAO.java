package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Product;

public interface ProductDAO {
	
	List<Product> getAll();
	List<Product> getTopLastest();
	List<Product> getTopSale();
}
