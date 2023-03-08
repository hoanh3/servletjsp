package webdemo.mvc.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.DAO.CategoryDAO;
import webdemo.mvc.DAO.impl.CategoryDAOImpl;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.User;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;

public class CategoryListController extends HttpServlet{
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pid = req.getParameter("page-id");
		if(pid == null) {
			pid = "1";
		}
		
		List<Category> categoryList = categoryService.getCategoryInPage(Integer.valueOf(pid));
		req.setAttribute("categoryList", categoryList);
		
		int NOCate = categoryService.getNumOfCategory();
		int endPage = NOCate / 10;
		if(NOCate % 10 != 0) {
			endPage++;
		}
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageActive", pid);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-cate.jsp");
		dispatcher.forward(req, resp);
	}
}
