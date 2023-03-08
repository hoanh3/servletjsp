package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.DAO.CategoryDAO;
import webdemo.mvc.DAO.impl.CategoryDAOImpl;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;

public class CategoryDeleteController extends HttpServlet{
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cateId = req.getParameter("cate-id");
		try {
			int status = categoryService.deleteCategory(Integer.valueOf(cateId));
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/cate/list");
			} else {
				System.out.println("loi cateDeleteController");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
