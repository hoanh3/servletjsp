package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import webdemo.mvc.DAO.AdminDAO;
import webdemo.mvc.DAO.UserDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Admin;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.Product;
import webdemo.mvc.models.User;

public class AdminDAOImpl implements AdminDAO{

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	@Override
	public Admin getAdmin(String email, String password) {
		Admin admin = new Admin();
		String query = "SELECT TOP (1000) [id],[fullname],[email],[password],[role_id]\r\n"
				+ "FROM [QLHQ].[dbo].[user]\r\n"
				+ "WHERE [role_id] = 1 and [email] = ? and [password] = ? and [delete] = 1";
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String emailA = resultSet.getString(3);
				String passwordA = resultSet.getString(4);
				int role_id = resultSet.getInt(5);
				admin = new Admin(id, fullName, emailA, passwordA, role_id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminDAO");
		}
		
		return admin;
	}

	@Override
	public int addAdmin(Admin admin) {
		int status = 0;
		String query = "INSERT INTO [dbo].[user]\r\n"
				+ "( [fullname], [email], [password], [role_id], [delete])\r\n"
				+ "VALUES (?, ?, ?, ?, 1)";
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getEmail());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setString(4, "1");
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminDAO");
		}
		return status;
	}

	@Override
	public List<Admin> getAll() {
		List<Admin> adminList = new ArrayList<>();
		String query = "SELECT [id],[fullname],[email],[password],[role_id]\r\n"
				+ "FROM [QLHQ].[dbo].[user]\r\n"
				+ "WHERE [role_id] = 1 and [delete] = 1";
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String password = resultSet.getString(4);
				int role_id = resultSet.getInt(5);
				adminList.add(new Admin(id, fullName, email, password, role_id));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminDAO");
		}
		
		return adminList;
	}

	@Override
	public List<Admin> getAdminInPage(int pageId) {
		List<Admin> adminList = new ArrayList<>();
		String query = "SELECT [id],[fullname],[email],[password],[role_id]\r\n"
				+ "FROM [QLHQ].[dbo].[user]\r\n"
				+ "WHERE [role_id] = 1 and [delete] = 1\r\n"
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
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String password = resultSet.getString(4);
				int role_id = resultSet.getInt(5);
				adminList.add(new Admin(id, fullName, email, password, role_id));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminDao");
		}
		return adminList;
	}

	@Override
	public int getNumOfAdmin() {
		int total = 0;
		String query = "SELECT COUNT(*) FROM dbo.[user]\r\n"
				+ "WHERE [role_id] = 1 and [delete] = 1";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				total = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminDao");
		}
		return total;
	}

	@Override
	public int deleteAdmin(int id) {
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
			System.out.println("loi adminDao");
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateAdmin(Admin admin) {
		String query = "UPDATE [dbo].[user]\r\n"
				+ "SET [fullname] = ?,\r\n"
				+ "    [email] = ?,\r\n"
				+ "    [password] = ?\r\n"
				+ "WHERE [id] = ? and [delete] = 1";
		int status = 0;
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getEmail());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setInt(4, admin.getId());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminDao update");
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public Admin getAdminById(int id) {
		Admin admin = new Admin();
		String query = "SELECT TOP (1000) [id],[fullname],[email],[password],[role_id]\r\n"
				+ "FROM [QLHQ].[dbo].[user]\r\n"
				+ "WHERE id = ? and [delete] = 1";
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int idN = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String emailA = resultSet.getString(3);
				String passwordA = resultSet.getString(4);
				int role_id = resultSet.getInt(5);
				admin = new Admin(idN, fullName, emailA, passwordA, role_id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi adminDAO");
		}
		
		return admin;
	}
	
	public static void main(String[] args) {
		AdminDAO adminDAO = new AdminDAOImpl();
		System.out.println(adminDAO.deleteAdmin(4));
	}

}
