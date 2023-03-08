package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Category;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;

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
		String thumbnail = req.getParameter("cate-thumbnail");
		try {
			int status = categoryService.insertCategory(new Category(0, name, thumbnail));
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
}
