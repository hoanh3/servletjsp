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
import webdemo.mvc.models.Product;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.Impl.ProductServiceImpl;

public class CartController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	
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
		String num = req.getParameter("num");
		String pid = req.getParameter("pid");
		try {
			Product product = productService.getProductById(Integer.parseInt(pid));
			Item item = new Item(product, Integer.parseInt(num), product.getDiscount());
			cart.addItem(item);
		} catch (Exception e) {
			num = "1";
		}
		List<Item> listItem = cart.getItems();
		req.setAttribute("listItem", listItem);
		session.setAttribute("cart", cart);
		session.setAttribute("cartSize", cart.getCartSize());
		session.setAttribute("cartTotalMoney", cart.getTotalMoney());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/shop-cart.jsp");
		dispatcher.forward(req, resp);
	}
}
