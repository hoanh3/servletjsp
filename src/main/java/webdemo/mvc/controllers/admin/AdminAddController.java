package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.services.AdminService;
import webdemo.mvc.services.Impl.AdminServiceImpl;

public class AdminAddController extends HttpServlet{
	private AdminService adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addadmin.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminEmail = req.getParameter("admin-email");
		String adminPassword = req.getParameter("admin-password");
		String adminName = req.getParameter("admin-name");
		try {
			int status = adminService.addAdmin(adminName, adminEmail, adminPassword);
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/admin/list");
			} else {
				System.out.println("khong thanh cong");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addadmin.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
