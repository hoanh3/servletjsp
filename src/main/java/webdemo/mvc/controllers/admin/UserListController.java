package webdemo.mvc.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdemo.mvc.models.Admin;
import webdemo.mvc.models.User;
import webdemo.mvc.services.UserService;
import webdemo.mvc.services.Impl.UserServiceImpl;

public class UserListController extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pid = req.getParameter("page-id");
		if(pid == null) {
			pid = "1";
		}
		
		List<User> userList = userService.getUserInPage(Integer.valueOf(pid));
		req.setAttribute("userList", userList);
		
		int NOAdmin = userService.getNumOfUser();
		int endPage = NOAdmin / 10;
		if(NOAdmin % 10 != 0) {
			endPage++;
		}
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageActive", pid);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/user.jsp");
		dispatcher.forward(req, resp);
	}
}
