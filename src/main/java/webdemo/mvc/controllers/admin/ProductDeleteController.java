package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.Impl.ProductServiceImpl;

public class ProductDeleteController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productId = req.getParameter("id");
		try {
			int status = productService.deleteProduct(Integer.valueOf(productId));
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/product/list");
			} else {
				System.out.println("loi delete product");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
