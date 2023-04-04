package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import webdemo.mvc.DAO.OrderDetailDAO;
import webdemo.mvc.DAO.ProductDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Item;

public class OrderDetailDAOImpl implements OrderDetailDAO{
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void addOrderLine(List<Item> items, int oid) {
		String query = "INSERT INTO [QLHQ].[dbo].[order_detail]\r\n"
				+ "( [order_id],[product_id],[price],[num])\r\n"
				+ "VALUES (?, ?, ?, ?)";
		int status = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			for(Item item : items) {
				preparedStatement.setInt(1, oid);
				preparedStatement.setInt(2, item.getProduct().getId());
				preparedStatement.setFloat(3, item.getPrice());
				preparedStatement.setInt(4, item.getNum());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return ;
	}
	
	public static void main(String[] args) {
		OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		List<Item> items = new ArrayList<>();
		ProductDAO productDAO = new ProductDAOImpl();
		items.add(new Item(productDAO.getProductById(1), 1000, 1));
		items.add(new Item(productDAO.getProductById(2), 2000, 2));
		orderDetailDAO.addOrderLine(items, 1);
		System.out.println();
	}
}
