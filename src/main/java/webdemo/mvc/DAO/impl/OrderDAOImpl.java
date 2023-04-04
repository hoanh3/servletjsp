package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

import webdemo.mvc.DAO.OrderDAO;
import webdemo.mvc.DAO.OrderDetailDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Cart;
import webdemo.mvc.models.Item;
import webdemo.mvc.models.Order;
import webdemo.mvc.models.User;

public class OrderDAOImpl implements OrderDAO{
	OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public int addOrder(User user, Cart cart, Order order) {
		String query = "INSERT INTO [dbo].[order]\r\n"
				+ "( [fullname],[email],[phonenumber],[address],[note],[order_date],[status],[total_money],[user_id])\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String getOrderIDQuery = "SELECT TOP 1 [id] FROM [dbo].[order]\r\n"
				+ "ORDER BY [id] DESC";
		String insertOrderDetail = "INSERT INTO [dbo].[order_detail]\\r\\n\"\r\n"
				+ "				+ \"( [order_id],[product_id],[price],[num])\\r\\n\"\r\n"
				+ "				+ \"VALUES (?, ?, ?, ?)";
		int status = 0;
		int oid = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhoneNumber());
			preparedStatement.setString(4, order.getAddress());
			preparedStatement.setString(5, order.getNote());
			preparedStatement.setDate(6, (java.sql.Date) order.getOrderDate());
			preparedStatement.setString(7, "1");
			preparedStatement.setString(8, String.valueOf(cart.getTotalMoney()));
			preparedStatement.setString(9, String.valueOf(user.getId()));
			status = preparedStatement.executeUpdate();
			if(status > 0) {
				preparedStatement = connection.prepareStatement(getOrderIDQuery);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					oid = resultSet.getInt(1);
				}
				orderDetailDAO.addOrderLine(cart.getItems(), oid);
			}
		} catch (Exception e) {
 			// TODO: handle exception
			System.out.println("loi ngoai");
		}
		return status;
	}

}
