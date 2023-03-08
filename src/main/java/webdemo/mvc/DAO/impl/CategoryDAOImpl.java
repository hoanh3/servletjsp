package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webdemo.mvc.DAO.CategoryDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Admin;
import webdemo.mvc.models.Category;

public class CategoryDAOImpl implements CategoryDAO{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	@Override
	public List<Category> getAll() {
		List<Category> listCat = new ArrayList<>();
		String query = "SELECT [id],[name],[thumbnail]" + 
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

	@Override
	public int insertCategory(Category category) {
		int status = 0;
		String query = "INSERT INTO [dbo].[category]\r\n"
				+ "([name], [thumbnail])\r\n"
				+ "VALUES\r\n"
				+ "(?, ?)";
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2, category.getThumbnail());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi categoryDao");
		}
		return status;
	}

	@Override
	public List<Category> getCategoryInPage(int pageId) {
		List<Category> categoryList = new ArrayList<>();
		String query = "SELECT [id],[name],[thumbnail]\r\n"
				+ "FROM [QLHQ].[dbo].[category]\r\n"
				+ "ORDER BY id\r\n"
				+ "OFFSET ? ROWS\r\n"
				+ "FETCH NEXT 10 ROWS ONLY";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			int offsetIdx = (pageId - 1) * 10;
			preparedStatement.setInt(1, offsetIdx);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String thumbnail = resultSet.getString(3);
				categoryList.add(new Category(id, name, thumbnail));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi categoryDao");
		}
		return categoryList;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = null;
		String query = "SELECT [id],[name],[thumbnail]\r\n"
				+ "FROM [QLHQ].[dbo].[category]\r\n"
				+ "WHERE [id] = ?";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int idN = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String thumbnail = resultSet.getString(3);
				category = new Category(id, name, thumbnail);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi categoryDao");
		}
		return category;
	}

	@Override
	public int updateCategory(Category category) {
		String query = "UPDATE [dbo].[category]\r\n"
				+ "SET [name] = ?,\r\n"
				+ "    [thumbnail] = ?\r\n"
				+ "WHERE [id] = ?";
		int status = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2, category.getThumbnail());
			preparedStatement.setInt(3, category.getId());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi categoryDao update");
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteCategory(int id) {
		String query = "DELETE FROM [dbo].[category]\r\n"
				+ "WHERE id = ?";
		int status = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi categoryDao");
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int getNumOfCategory() {
		int total = 0;
		String query = "SELECT COUNT(*) FROM dbo.[category]\r\n";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				total = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi categoryDao");
		}
		return total;
	}
	
	public static void main(String[] args) {
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		Category category = new Category(6, "test1", "test");
		int status = categoryDAO.deleteCategory(6);
		System.out.println(status);
	}
}
