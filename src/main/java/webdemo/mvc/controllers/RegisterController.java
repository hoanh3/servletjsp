package webdemo.mvc.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webdemo.mvc.models.User;
import webdemo.mvc.services.UserService;
import webdemo.mvc.services.Impl.UserServiceImpl;

public class RegisterController extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/login/signup.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			int status = userService.insert(username, email, password);
			if(status != 0) {
				request.setAttribute("message", "Successful! Login now <a href='login'>Login</a>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("view/login/signup.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "Already exist email!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("view/login/signup.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
