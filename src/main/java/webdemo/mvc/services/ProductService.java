package webdemo.mvc.services;

import java.util.List;

import webdemo.mvc.models.Product;

public interface ProductService {
	List<Product> getAll();
	List<Product> getTopLastest();
}
