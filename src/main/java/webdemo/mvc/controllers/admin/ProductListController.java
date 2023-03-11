package webdemo.mvc.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Product;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.Impl.ProductServiceImpl;

public class ProductListController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageId = req.getParameter("page-id");
		if(pageId == null) {
			pageId = "1";
		}
		
		List<Product> productList = productService.getProductInPage(Integer.valueOf(pageId));
		req.setAttribute("productList", productList);
		
		int numOfProduct = productService.getNumberOfProduct();
		
		int endPage = numOfProduct / 9;
		if(numOfProduct % 9 != 0) {
			endPage++;
		}
		req.setAttribute("endPage", endPage);
		
		req.setAttribute("pageActive", Integer.valueOf(pageId));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-product.jsp");
		dispatcher.forward(req, resp);
	}
}
