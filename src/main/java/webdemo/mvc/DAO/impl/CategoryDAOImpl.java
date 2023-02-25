package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webdemo.mvc.DAO.CategoryDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Category;

public class CategoryDAOImpl implements CategoryDAO{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	@Override
	public List<Category> getAll() {
		List<Category> listCat = new ArrayList<>();
		String query = "SELECT [int],[name],[thumbnail]" + 
					"FROM [QLHQ].[dbo].[category]";
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String thumbnail = resultSet.getString(3);
				listCat.add(new Category(id, name, thumbnail));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi categoryDao");
		}
		return listCat;
	}
}
