package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.services.AdminService;
import webdemo.mvc.services.Impl.AdminServiceImpl;

public class AdminDeleteController extends HttpServlet{
	AdminService adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminId = req.getParameter("admin-id");
		try {
			int status = adminService.deleteAdmin(Integer.valueOf(adminId));
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/admin/list");
			} else {
				System.out.println("loi adminDeleteController");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
