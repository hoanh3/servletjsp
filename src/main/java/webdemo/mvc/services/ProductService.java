package webdemo.mvc.services;

import java.util.List;

import webdemo.mvc.models.Product;

public interface ProductService {
	
	Product getProductById(String productId);

	List<Product> searchProductByName(String name);
	List<Product> getProductByCatId(String catId);
	List<Product> getAll();
	List<Product> getTopLastest();
	List<Product> getTopSale();
}
