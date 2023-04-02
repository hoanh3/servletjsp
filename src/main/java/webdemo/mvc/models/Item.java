package webdemo.mvc.models;

public class Item {
	private Product product;
	private int num;
	private int price;
	
	public Item() {
		super();
	}

	public Item(Product product, int num, int price) {
		super();
		this.product = product;
		this.num = num;
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", num=" + num + ", price=" + price + "]";
	}
	
	
}
