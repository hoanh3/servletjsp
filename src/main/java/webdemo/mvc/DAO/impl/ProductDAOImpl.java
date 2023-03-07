package webdemo.mvc.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import webdemo.mvc.DAO.ProductDAO;
import webdemo.mvc.context.DBContext;
import webdemo.mvc.models.Category;
import webdemo.mvc.models.Product;

public class ProductDAOImpl implements ProductDAO{
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	@Override
	public List<Product> getAll() {
		List<Product> listProducts = new ArrayList<>();
		String query = "SELECT P.*, CAT.*\r\n"
				+ "FROM dbo.product AS P\r\n"
				+ "INNER JOIN dbo.category AS CAT ON P.[category_id] = CAT.[id];";
		
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
				int delete = resultSet.getInt(10);
				int availability = resultSet.getInt(11);
				int categoryId = resultSet.getInt(12);
				String categoryName = resultSet.getString(13);
				String categoryThumbnail = resultSet.getString(14);
				Product product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, new Category(categoryId, categoryName, categoryThumbnail), delete, availability);
				listProducts.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return listProducts;
	}

	@Override
	public List<Product> getTopLastest() {
		List<Product> listProducts = new ArrayList<>();
		String query = "SELECT TOP 6 P.*, CAT.*\r\n"
				+ "FROM dbo.product AS P\r\n"
				+ "INNER JOIN dbo.category AS CAT ON P.[category_id] = CAT.[id]\r\n"
				+ "ORDER BY p.[create_at] DESC";
		
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
				int delete = resultSet.getInt(10);
				int availability = resultSet.getInt(11);
				int categoryId = resultSet.getInt(12);
				String categoryName = resultSet.getString(13);
				String categoryThumbnail = resultSet.getString(14);
				Product product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, new Category(categoryId, categoryName, categoryThumbnail), delete, availability);
				listProducts.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return listProducts;
	}

	@Override
	public List<Product> getTopSale() {
		List<Product> listProducts = new ArrayList<>();
		String query = "SELECT TOP 6 PR.*, CAT.*\r\n"
				+ "FROM dbo.product AS PR \r\n"
				+ "INNER JOIN dbo.category AS CAT ON PR.category_id = CAT.id\r\n"
				+ "ORDER BY ROUND((PR.price - PR.discount) / PR.price * 100, 0) DESC";
		
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
				int delete = resultSet.getInt(10);
				int availability = resultSet.getInt(11);
				int categoryId = resultSet.getInt(12);
				String categoryName = resultSet.getString(13);
				String categoryThumbnail = resultSet.getString(14);
				Product product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, new Category(categoryId, categoryName, categoryThumbnail), delete, availability);
				listProducts.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return listProducts;
	}

	@Override
	public List<Product> getProductByCatId(String catId) {
		List<Product> listProducts = new ArrayList<>();
		String query = "SELECT PR.*, CAT.*\r\n"
				+ "FROM dbo.product AS PR \r\n"
				+ "INNER JOIN dbo.category AS CAT ON PR.category_id = CAT.id\r\n"
				+ "WHERE PR.category_id = " + catId;
		
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
				int delete = resultSet.getInt(10);
				int availability = resultSet.getInt(11);
				int categoryId = resultSet.getInt(12);
				String categoryName = resultSet.getString(13);
				String categoryThumbnail = resultSet.getString(14);
				Product product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, new Category(categoryId, categoryName, categoryThumbnail), delete, availability);
				listProducts.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return listProducts;
	}

	@Override
	public Product getProductById(String productId) {
		Product product = new Product();
		String query = "SELECT PR.*, CAT.*\r\n"
				+ "FROM dbo.product AS PR \r\n"
				+ "INNER JOIN dbo.category AS CAT ON PR.category_id = CAT.id\r\n"
				+ "WHERE PR.id = " + productId;
		
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
				int delete = resultSet.getInt(10);
				int availability = resultSet.getInt(11);
				int categoryId = resultSet.getInt(12);
				String categoryName = resultSet.getString(13);
				String categoryThumbnail = resultSet.getString(14);
				product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, new Category(categoryId, categoryName, categoryThumbnail), delete, availability);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return product;
	}

	@Override
	public List<Product> searchProductByName(String name) {
		List<Product> listProducts = new ArrayList<>();
		String query = "SELECT PR.*, CAT.*\r\n"
				+ "FROM dbo.product AS PR \r\n"
				+ "INNER JOIN dbo.category AS CAT ON PR.category_id = CAT.id\r\n"
				+ "WHERE PR.title LIKE N'%" + name + "%'";
		
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
				int delete = resultSet.getInt(10);
				int availability = resultSet.getInt(11);
				int categoryId = resultSet.getInt(12);
				String categoryName = resultSet.getString(13);
				String categoryThumbnail = resultSet.getString(14);
				Product product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, new Category(categoryId, categoryName, categoryThumbnail), delete, availability);
				listProducts.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return listProducts;
	}

	@Override
	public List<Product> getProductInPage(int pageId) {
		List<Product> listProducts = new ArrayList<>();
		String query = "SELECT P.*, CAT.*\r\n"
				+ "FROM [dbo].[product] AS P\r\n"
				+ "INNER JOIN dbo.category AS CAT ON P.category_id = CAT.id\r\n"
				+ "ORDER BY P.[id]\r\n"
				+ "OFFSET ? ROWS\r\n"
				+ "FETCH NEXT 9 ROWS ONLY";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			int offsetIdx = (pageId - 1) * 9;
			preparedStatement.setInt(1, offsetIdx);
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
				int delete = resultSet.getInt(10);
				int availability = resultSet.getInt(11);
				int categoryId = resultSet.getInt(12);
				String categoryName = resultSet.getString(13);
				String categoryThumbnail = resultSet.getString(14);
				Product product = new Product(id, title, price, discount, thumbnail, description, createAt, updateAt, new Category(categoryId, categoryName, categoryThumbnail), delete, availability);
				listProducts.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return listProducts;
	}

	@Override
	public int getNumberOfProduct() {
		int total = 0;
		String query = "SELECT COUNT(*) FROM dbo.product";
		
		try {
			connection = DBContext.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				total = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi productDao");
		}
		return total;
	}
	
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAOImpl();
		List<Product> ls = productDAO.getProductInPage(1);
		for(Product p : ls) {
			System.out.println(p);
		}
	}
}
