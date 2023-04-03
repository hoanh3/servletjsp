package webdemo.mvc.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webdemo.mvc.models.Cart;
import webdemo.mvc.models.Item;

public class CartProcessController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		Cart cart = null;
		Object object = session.getAttribute("cart");
		if(object != null) {
			cart = (Cart) object;
		} else {
			cart = new Cart();
		}
		String pid = req.getParameter("pid");
		String act = req.getParameter("act");
		if(act != null) {
			if(act.compareTo("delete") == 0) {
				cart.removeItem(Integer.valueOf(pid));
			} else {
				try {
					cart.changeNumById(Integer.valueOf(pid), Integer.valueOf(act));			
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println(act);
				}
			}
		}

		List<Item> listItem = cart.getItems();
		req.setAttribute("listItem", listItem);
		session.setAttribute("cart", cart);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/shop-cart.jsp");
		dispatcher.forward(req, resp);
	}
}
