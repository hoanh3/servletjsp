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
import webdemo.mvc.models.Category;
import webdemo.mvc.models.Item;
import webdemo.mvc.services.CategoryService;
import webdemo.mvc.services.ProductService;
import webdemo.mvc.services.Impl.CategoryServiceImpl;
import webdemo.mvc.services.Impl.ProductServiceImpl;

public class ShopCartController extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Category> listC = categoryService.getAll();
		request.setAttribute("listCat", listC);
		
		HttpSession session = request.getSession(true);
		Cart cart = null;
		Object object = session.getAttribute("cart");
		if(object != null) {
			cart = (Cart) object;
		} else {
			cart = new Cart();
		}

		List<Item> listItem = cart.getItems();
		request.setAttribute("listItem", listItem);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/shop-cart.jsp");
		dispatcher.forward(request, response);
	}
}
