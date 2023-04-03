package webdemo.mvc.services;

import webdemo.mvc.models.Cart;
import webdemo.mvc.models.Order;
import webdemo.mvc.models.User;

public interface OrderService {
	public int addOrder(User user, Cart cart, Order order);
}
