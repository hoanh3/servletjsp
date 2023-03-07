package webdemo.mvc.controllers.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Admin;
import webdemo.mvc.models.User;
import webdemo.mvc.services.UserService;
import webdemo.mvc.services.Impl.UserServiceImpl;

public class UserUpdateController extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("user-id");
		User user = userService.getUserById(Integer.valueOf(userId));
		req.setAttribute("user", user);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/edituser.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("user-id");
		String email = req.getParameter("user-email");
		String password = req.getParameter("user-password");
		String fullName = req.getParameter("user-fullname");
		String phoneNumber = req.getParameter("user-phoneNumber");
		String address = req.getParameter("user-address");
		userService.updateUser(new User(Integer.valueOf(id), fullName, email, password, phoneNumber, address, null, null, null, 1));
		resp.sendRedirect(req.getContextPath() + "/admin/user/list");
	}
}
