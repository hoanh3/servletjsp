package webdemo.mvc.DAO;

import webdemo.mvc.models.Cart;
import webdemo.mvc.models.Order;
import webdemo.mvc.models.User;

public interface OrderDAO {
	public int addOrder(User user, Cart cart, Order order);
}
