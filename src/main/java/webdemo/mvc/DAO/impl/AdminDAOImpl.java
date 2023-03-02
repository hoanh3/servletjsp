package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webdemo.mvc.DAO.AdminDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Admin;
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
				+ "WHERE [role_id] = 1 and [email] = ? and [password] = ?";
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
				+ "WHERE [role_id] = 1";
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
	
}
