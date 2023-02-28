package webdemo.mvc.services.Impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import webdemo.mvc.DAO.ProductDAO;
import webdemo.mvc.DAO.impl.ProductDAOImpl;
import webdemo.mvc.models.Product;
import webdemo.mvc.services.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	public List<Product> getAll() {
		return productDAO.getAll();
	}

	@Override
	public List<Product> getTopLastest() {
		// TODO Auto-generated method stub
//		List<Product> listProduct = productDAO.getAll();
//		Collections.sort(listProduct, (p1, p2) -> {
//			Date d1 = (Date) ((Product) p1).getCreateAt();
//			Date d2 = (Date) ((Product) p2).getCreateAt();
//			return (int) (d2.getTime() - d1.getTime());
//		});
//		return listProduct.subList(0, 6);
		
		return productDAO.getTopLastest();
	}
	
	@Override
	public List<Product> getTopSale() {
		return productDAO.getTopSale();
	}
	
	@Override
	public List<Product> getProductByCatId(String catId) {
		return productDAO.getProductByCatId(catId);
	}
	
	@Override
	public Product getProductById(String productId) {
		return productDAO.getProductById(productId);
	}
	
	@Override
	public List<Product> searchProductByName(String name) {
		return productDAO.searchProductByName(name);
	}
	
	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		Product lProducts = productService.getProductById("1");
		List<Product> products = productService.searchProductByName("fruit");
		for(Product product : products) {
			System.out.println(product);
		}
	}

}
