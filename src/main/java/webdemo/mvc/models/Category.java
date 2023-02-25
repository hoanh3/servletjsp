package webdemo.mvc.models;

public class Category {
	private int id;
	private String name;
	private String thumbnail;
	
	public Category() {
		super();
	}

	public Category(int id, String name, String thumbnail) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", thumbnail=" + thumbnail + "]";
	}
	
	
}
