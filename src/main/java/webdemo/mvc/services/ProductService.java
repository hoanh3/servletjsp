package webdemo.mvc.services;

import java.util.List;

import webdemo.mvc.models.Product;

public interface ProductService {
	
	int getNumberOfProduct();
	
	List<Product> getProductInPage(int pageId);
	
	Product getProductById(String productId);

	List<Product> searchProductByName(String name);
	
	List<Product> getProductByCatId(String catId);
	
	List<Product> getAll();
	
	List<Product> getTopLastest();
	
	List<Product> getTopSale();
}
