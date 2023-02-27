package webdemo.mvc.models;

import java.util.Date;

public class Product {
	private int id;
	private String title;
	private int price;
	private int discount;
	private String thumbnail;
	private String description;
	private Date createAt;
	private Date updateAt;
	private Category categoryId;
	private int delete;
	private int availability;
	
	public Product() {
		super();
	}
	public Product(int id, String title, int price, int discount, String thumbnail, String description, Date createAt,
			Date updateAt, Category categoryId, int delete, int availability) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.thumbnail = thumbnail;
		this.description = description;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.categoryId = categoryId;
		this.delete = delete;
		this.availability = availability;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	public int getDelete() {
		return delete;
	}
	public void setDelete(int delete) {
		this.delete = delete;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", discount=" + discount + ", thumbnail="
				+ thumbnail + ", description=" + description + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ ", categoryId=" + categoryId + ", delete=" + delete + ", availability=" + availability + "]";
	}
	
}
