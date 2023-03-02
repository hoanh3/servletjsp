package webdemo.mvc.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Admin;
import webdemo.mvc.services.AdminService;
import webdemo.mvc.services.Impl.AdminServiceImpl;

public class AdminListController extends HttpServlet{
	private AdminService adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Admin> adminList = adminService.getAll();
		req.setAttribute("adminList", adminList);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/admin.jsp");
		dispatcher.forward(req, resp);
	}
}
