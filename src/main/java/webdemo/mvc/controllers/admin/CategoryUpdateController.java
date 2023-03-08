package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.User;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;

public class CategoryUpdateController extends HttpServlet{
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cateId = req.getParameter("cate-id");
		Category category = categoryService.getCategoryById(Integer.valueOf(cateId));
		req.setAttribute("category", category);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/editcate.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("cate-id");
		String name = req.getParameter("cate-name");
		String thumbnail = req.getParameter("cate-thumnail");
		categoryService.updateCategory(new Category(Integer.valueOf(id), name, thumbnail));
		resp.sendRedirect(req.getContextPath() + "/admin/cate/list");
	}
}
