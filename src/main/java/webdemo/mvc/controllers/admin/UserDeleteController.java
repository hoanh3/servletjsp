package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.services.UserService;
import webdemo.mvc.services.Impl.UserServiceImpl;

public class UserDeleteController extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminId = req.getParameter("user-id");
		try {
			int status = userService.deleteUser(Integer.valueOf(adminId));
			if(status != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/user/list");
			} else {
				System.out.println("loi userDeleteController");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
