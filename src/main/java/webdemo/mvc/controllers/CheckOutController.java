package webdemo.mvc.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webdemo.mvc.models.Cart;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.Order;
import webdemo.mvc.models.User;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.OrderService;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.UserService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;
import webdemo.mvc.services.Impl.OrderServiceImpl;
import webdemo.mvc.services.Impl.ProductServiceImpl;
import webdemo.mvc.services.Impl.UserServiceImpl;

public class CheckOutController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	private UserService userService = new UserServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listC = categoryService.getAll();
		request.setAttribute("listCat", listC);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/checkout.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fullname = req.getParameter("fullName");
		String streetAddress = req.getParameter("streetAddress");
		String optinalAddress = req.getParameter("optinalAddress");
		String address = req.getParameter("address");
		String phoneNumber = req.getParameter("phoneNumber");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String note = req.getParameter("note");
		
		
		HttpSession session = req.getSession();
		User user = null;
		Object object = session.getAttribute("user");
		if(object != null) {
			user = (User) object;
		} else {
			userService.insert(fullname, email, password);
			user = userService.getUserById(userService.getLastestUserId());
			user.setAddress(address);
			user.setPhoneNumber(phoneNumber);
			userService.updateUser(user);
		}
		Cart cart = (Cart) session.getAttribute("cart");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		date = new java.sql.Date(calendar.getTimeInMillis());
		
		Order order = new Order(fullname, email, phoneNumber, optinalAddress + ", " + streetAddress + ", " + address, note, date, 0, 0, 0);
		try {
			int status = orderService.addOrder(user, cart, order);
			if(status != 0) {
				cart.setItems(new ArrayList<>());
			} else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		resp.sendRedirect(req.getContextPath() + "/");
	}
}
