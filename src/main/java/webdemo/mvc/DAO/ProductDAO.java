package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Product;

public interface ProductDAO {
	
	
	Product getProductById(String productId);

	List<Product> searchProductByName(String name);
	List<Product> getProductByCatId(String catId);
	List<Product> getAll();
	List<Product> getTopLastest();
	List<Product> getTopSale();
}
