package webdemo.mvc.DAO;

import java.util.List;

import webdemo.mvc.models.Item;

public interface OrderDetailDAO {
	public void addOrderLine(List<Item> items, int oid);
}
