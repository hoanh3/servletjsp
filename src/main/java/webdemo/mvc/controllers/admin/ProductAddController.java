package webdemo.mvc.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.Product;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;
import webdemo.mvc.services.Impl.ProductServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProductAddController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	private SimpleDateFormat fmDate = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Category> catelist = categoryService.getAll();
		req.setAttribute("catelist", catelist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addproduct.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part filePart = req.getPart("product-thumbnail");
		String fileName = filePart.getSubmittedFileName();
		for (Part part : req.getParts()) {
			part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
		}
		
		String title = req.getParameter("product-title");
		String price = req.getParameter("product-price");
		String discount = req.getParameter("product-discount");
		String categoryId = req.getParameter("product-cate");
		Category category = categoryService.getCategoryById(Integer.valueOf(categoryId));
		String createAt = req.getParameter("create-at");
		String updateAt = req.getParameter("update-at");
		String availability = req.getParameter("product-status");
		String description = req.getParameter("product-desc");
		try {
			int status = productService.insertProduct(
					new Product(0, title, Integer.valueOf(price), Integer.valueOf(discount), fileName, description, fmDate.parse(createAt), fmDate.parse(updateAt), category, 1, Integer.valueOf(availability))
			);
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/product/list");
			} else {
				System.out.println("khong thanh cong");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addproduct.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public File getFolderUpload() {
		String folderPath = getServletContext().getRealPath("") + "/view/client/assets/img/product" ;
		File folderUpload = new File(folderPath);
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
}
