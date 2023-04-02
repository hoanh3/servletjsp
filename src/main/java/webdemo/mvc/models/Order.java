package webdemo.mvc.models;

import java.util.Date;

public class Order {
	private int id;
	private String fullName;
	private String email;
	private String phoneNumber;
	private String address;
	private String note;
	private Date orderDate;
	private int status;
	private int totalMoney;
	private int user_id;
	
	public Order() {
		super();
	}

	public Order(int id, String fullName, String email, String phoneNumber, String address, String note, Date orderDate,
			int status, int totalMoney, int user_id) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.note = note;
		this.orderDate = orderDate;
		this.status = status;
		this.totalMoney = totalMoney;
		this.user_id = user_id;
	}

	public Order(String fullName, String email, String phoneNumber, String address, String note, Date orderDate,
			int status, int totalMoney, int user_id) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.note = note;
		this.orderDate = orderDate;
		this.status = status;
		this.totalMoney = totalMoney;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", note=" + note + ", orderDate=" + orderDate + ", status=" + status
				+ ", totalMoney=" + totalMoney + ", user_id=" + user_id + "]";
	}
}