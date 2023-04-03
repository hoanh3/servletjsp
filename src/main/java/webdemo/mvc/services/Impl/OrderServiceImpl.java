package webdemo.mvc.services.Impl;

import webdemo.mvc.DAO.OrderDAO;
import webdemo.mvc.DAO.impl.OrderDAOImpl;
import webdemo.mvc.models.Cart;
import webdemo.mvc.models.Order;
import webdemo.mvc.models.User;
import webdemo.mvc.services.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDAO orderDAO = new OrderDAOImpl();

	@Override
	public int addOrder(User user, Cart cart, Order order) {
		// TODO Auto-generated method stub
		return orderDAO.addOrder(user, cart, order);
	}
	
}
