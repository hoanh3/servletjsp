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
		
		String pid = req.getParameter("pid");
		if(pid == null) {
			pid = "1";
		}
		
		List<Admin> adminList = adminService.getAdminInPage(Integer.valueOf(pid));
		req.setAttribute("adminList", adminList);
		
		int NOAdmin = adminService.getNumOfAdmin();
		int endPage = NOAdmin / 10;
		if(NOAdmin % 10 != 0) {
			endPage++;
		}
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageActive", pid);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/admin.jsp");
		dispatcher.forward(req, resp);
	}
}
