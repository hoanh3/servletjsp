package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

import webdemo.mvc.DAO.UserDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.Product;
import webdemo.mvc.models.Role;
import webdemo.mvc.models.User;

public class UserDAOImpl implements UserDAO{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Override
	public User getUser(String email, String password) {
		User user = null;
		String query = "SELECT U.*, R.* FROM dbo.[user] as U\r\n"
				+ "INNER JOIN dbo.[role] AS R on R.id = U.role_id\r\n"
				+ "WHERE U.email = ? and U.[password] = ? and U.[delete] = 1";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String fullname = resultSet.getString(2);
				String emailD = resultSet.getString(3);
				String passwordD = resultSet.getString(4);
				String phoneNumber = resultSet.getString(5);
				String address = resultSet.getString(6);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				int delete = resultSet.getInt(10);
				int roleId = resultSet.getInt(11);
				String roleName = resultSet.getString(12);
				
				user = new User(id, fullname, emailD, passwordD, phoneNumber, address, new Role(roleId, roleName), createAt, updateAt, delete);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao");
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int insert(User user) {
		String query = "INSERT INTO [dbo].[user]\r\n"
				+ "([fullname], [email], [password], [role_id], [create_at], [update_at], [delete])\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?, 2, ?, ?, 1)";
		int status = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setDate(4, (java.sql.Date) user.getCreateAt());
			preparedStatement.setDate(5, (java.sql.Date) user.getUpdateAt());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao");
			e.printStackTrace();
		}
		return status;
	}
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.getUser("test2@gmail.com", "123456");
		System.out.println(user);
	}
}
