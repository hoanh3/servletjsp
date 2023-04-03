package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

	@Override
	public int deleteUser(int id) {
		String query = "UPDATE [dbo].[user]\r\n"
				+ "SET [delete] = 0\r\n"
				+ "WHERE [id] = ?";
		int status = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao");
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateUser(User user) {
		String query = "UPDATE [dbo].[user]\r\n"
				+ "SET\r\n"
				+ "    [fullname] = ?,\r\n"
				+ "    [email] = ?,\r\n"
				+ "    [password] = ?,\r\n"
				+ "    [phonenumber] = ?,\r\n"
				+ "    [address] = ?,\r\n"
				+ "    [update_at] = ?\r\n"
				+ "WHERE [delete] = 1 AND [id] = ?";
		int status = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setDate(6, (java.sql.Date) user.getUpdateAt());
			preparedStatement.setInt(7, user.getId());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao update");
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		String query = "SELECT U.*, R.* FROM dbo.[user] as U\r\n"
				+ "INNER JOIN dbo.[role] AS R on R.id = U.role_id\r\n"
				+ "WHERE U.id = ? and U.[delete] = 1";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int idN = resultSet.getInt(1);
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
				
				user = new User(idN, fullname, emailD, passwordD, phoneNumber, address, new Role(roleId, roleName), createAt, updateAt, delete);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao");
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getUserInPage(int pageId) {
		List<User> userList = new ArrayList<>();
		String query = "SELECT U.*, R.* FROM dbo.[user] as U\r\n"
				+ "INNER JOIN dbo.[role] AS R on R.id = U.role_id\r\n"
				+ "WHERE U.role_id = 2 and U.[delete] = 1"
				+ "ORDER BY U.id\r\n"
				+ "OFFSET ? ROWS\r\n"
				+ "FETCH NEXT 10 ROWS ONLY";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			int offsetIdx = (pageId - 1) * 10;
			preparedStatement.setInt(1, offsetIdx);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int idN = resultSet.getInt(1);
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
				
				userList.add(new User(idN, fullname, emailD, passwordD, phoneNumber, address, new Role(roleId, roleName), createAt, updateAt, delete));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao");
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public int getNumOfUser() {
		int total = 0;
		String query = "SELECT COUNT(*) FROM dbo.[user]\r\n"
				+ "WHERE [role_id] = 2 and [delete] = 1";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				total = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao");
		}
		return total;
	}
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		User u1 = userDAO.getUserById(1);
		System.out.println(u1);
		List<User> ls = userDAO.getUserInPage(1);
		for(User user : ls) {
			System.out.println(user);
		}
	}

	@Override
	public int getLastestUserId() {
		String query = "SELECT TOP 1 [id] FROM [dbo].[user]\r\n"
				+ "ORDER BY [id] DESC";
		int uid = -1;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				uid = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi userDao");
		}
		return uid;
	}
}
