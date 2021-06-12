package bean;

import java.sql.Date;
import java.util.ArrayList;



public class Order {
	private long orderId;
	private Date orderDateTime ;
    private String retailerId;
    private long customerId;
    private String orderType;
    private String orderStatus;  
    private double orderAmount;
    private ArrayList<String> products;
    
     public ArrayList<String> getProductId() {
		return products;
	}

	public void setProductId(ArrayList<String> products) {
		this.products = products;
	}

	public Order()
     {
    	 
     }

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
     
     
}
