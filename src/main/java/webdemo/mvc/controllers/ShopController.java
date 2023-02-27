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

public class ShopController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> listP = productService.getAll();
		request.setAttribute("listPro", listP);
		
		List<Category> listC = categoryService.getAll();
		request.setAttribute("listCat", listC);
		
		List<Product> listTopLastestProducts = productService.getTopLastest();
		request.setAttribute("topLastest", listTopLastestProducts);
		
		List<Product> listTopSaleProducts = productService.getTopSale();
		request.setAttribute("topSale", listTopSaleProducts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/shop.jsp");
		dispatcher.forward(request, response);
	}
}
