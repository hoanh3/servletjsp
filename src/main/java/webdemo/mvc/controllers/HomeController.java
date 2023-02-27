package webdemo.mvc.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.Product;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;
import webdemo.mvc.services.Impl.ProductServiceImpl;

public class HomeController extends HttpServlet{
	private CategoryService categoryService = new CategoryServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> listCategories = categoryService.getAll();
		request.setAttribute("listCat", listCategories);
//
		List<Product> listProducts = productService.getAll();
		request.setAttribute("listPro", listProducts);
		
		List<Product> listTopLastestProducts = productService.getTopLastest();
		request.setAttribute("topLastest", listTopLastestProducts);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/index.jsp");
		dispatcher.forward(request, response);
		
	}
}
