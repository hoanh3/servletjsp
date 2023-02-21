package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import webdemo.mvc.DAO.ProductDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Product;

public class ProductDAOImpl implements ProductDAO{
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	@Override
	public List<Product> getAll() {
		List<Product> listProducts = new ArrayList<>();
		String query = "SELECT [id],[title],[price],[discount],[thumbnail],[description],[create_at]," +
						"[update_at],[category_id],[delete] FROM [dbo].[product]";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int price = resultSet.getInt(3);
				int discount = resultSet.getInt(4);
				String thumbnail = resultSet.getString(5);
				String description = resultSet.getString(6);
				Date createAt = resultSet.getDate(7);
				Date updateAt = resultSet.getDate(8);
				int categoryId = resultSet.getInt(9);
				int delete = resultSet.getInt(10);
				Product product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, categoryId, delete);
				listProducts.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi");
		}
		return listProducts;
	}
}
