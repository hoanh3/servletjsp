package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Admin;
import webdemo.mvc.services.AdminService;
import webdemo.mvc.services.Impl.AdminServiceImpl;

public class AdminUpdateController extends HttpServlet{
	AdminService adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminId = req.getParameter("id");
		Admin admin = adminService.getAdminById(Integer.valueOf(adminId));
		req.setAttribute("admin", admin);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/editadmin.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String fullName = req.getParameter("name");
		adminService.updateAdmin(new Admin(Integer.valueOf(id), fullName, email, password, 1));
		resp.sendRedirect(req.getContextPath() + "/admin/admin/list");
	}
}
