package webdemo.mvc.controllers.admin;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import webdemo.mvc.models.Category;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CategoryAddController extends HttpServlet{
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addcate.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("cate-name");
		Part filePart = req.getPart("thumbnail");
		String fileName = filePart.getSubmittedFileName();
		for (Part part : req.getParts()) {
			part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
		}
		try {
			int status = categoryService.insertCategory(new Category(0, name, fileName));
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/cate/list");
			} else {
				System.out.println("khong thanh cong");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addcate.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public File getFolderUpload() {
		String folderPath = getServletContext().getRealPath("") + "/view/client/assets/img/categories" ;
		File folderUpload = new File(folderPath);
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
}
