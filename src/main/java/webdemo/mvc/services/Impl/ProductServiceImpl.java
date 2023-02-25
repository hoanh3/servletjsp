package webdemo.mvc.services.Impl;

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
	
}
