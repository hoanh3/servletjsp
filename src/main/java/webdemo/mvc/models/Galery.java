package webdemo.mvc.models;

public class Galery {
	private int id;
	private int productId;
	private String thumbnail;
	
	public Galery() {
		super();
	}

	public Galery(int id, int productId, String thumbnail) {
		super();
		this.id = id;
		this.productId = productId;
		this.thumbnail = thumbnail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
