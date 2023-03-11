package webdemo.mvc.services;

import java.util.List;

import webdemo.mvc.models.Product;

public interface ProductService {
	
	int getNumberOfProduct();
	
	List<Product> getProductInPage(int pageId);
	
	Product getProductById(int productId);

	List<Product> searchProductByName(String name);
	
	List<Product> getProductByCatId(String catId);
	
	List<Product> getAll();
	
	List<Product> getTopLastest();
	
	List<Product> getTopSale();

	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(int id);
}
