package webdemo.mvc.controllers.admin;

import java.io.IOException;

import javax.print.ServiceUIFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webdemo.mvc.models.Admin;
import webdemo.mvc.services.AdminService;
import webdemo.mvc.services.Impl.AdminServiceImpl;

public class AdminLoginController extends HttpServlet{
	private AdminService adminService = new AdminServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailAdmin = req.getParameter("admin-email");
		String passwordAdmin = req.getParameter("admin-password");
		try {
			Admin admin = adminService.getAdmin(emailAdmin, passwordAdmin);
			if(admin != null) {
				HttpSession session = req.getSession();
				session.setAttribute("adminUser", admin);
				session.setAttribute("admin-username", admin.getName());
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else {
				req.setAttribute("errorMessage", "Invalid email or password!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminlogin");
		}
	}
}
