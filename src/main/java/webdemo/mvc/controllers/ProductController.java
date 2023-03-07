package webdemo.mvc.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Product;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;
import webdemo.mvc.services.Impl.ProductServiceImpl;

public class ProductController extends HttpServlet{
	private CategoryService categoryService = new CategoryServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid = request.getParameter("pid");
		Product product = productService.getProductById(pid);
		request.setAttribute("pDetail", product);
		
		String catId = String.valueOf(product.getCategoryId().getId());
		List<Product> relatedProductList = productService.getProductByCatId(catId);
		relatedProductList = relatedProductList.subList(0, Math.min(4, relatedProductList.size()));
		request.setAttribute("relatedList", relatedProductList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/product-detail.jsp");
		dispatcher.forward(request, response);
	}
}
