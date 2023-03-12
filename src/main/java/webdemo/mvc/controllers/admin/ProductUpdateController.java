package webdemo.mvc.controllers.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

public class ProductUpdateController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	private SimpleDateFormat fmDate = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productId = req.getParameter("id");
		Product product = productService.getProductById(Integer.valueOf(productId));
		req.setAttribute("product", product);
		
		List<Category> catelist = categoryService.getAll();
		req.setAttribute("catelist", catelist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/editproduct.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("product-id");
		String title = req.getParameter("product-title");
		String price = req.getParameter("product-price");
		String discount = req.getParameter("product-discount");
		String categoryId = req.getParameter("product-cate");
		Category category = categoryService.getCategoryById(Integer.valueOf(categoryId));
		String createAt = req.getParameter("create-at");
		String availability = req.getParameter("product-status");
		String description = req.getParameter("product-desc");
		try {
			int status = productService.updateProduct(
					new Product(Integer.valueOf(id), title, Integer.valueOf(price), Integer.valueOf(discount), "", description, fmDate.parse(createAt), fmDate.parse(createAt), category, 1, Integer.valueOf(availability))
			);
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/product/list");
			} else {
				System.out.println("khong thanh cong");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/editproduct.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
