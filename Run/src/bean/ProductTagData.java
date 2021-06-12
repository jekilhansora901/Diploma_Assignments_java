package bean;

import java.util.ArrayList;

public class ProductTagData {
	private String userId;
	private ArrayList<String> productIdList = new ArrayList<String>();
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ArrayList<String> getProductIdList() {
		return productIdList;
	}
	public void setProductIdList(ArrayList<String> produclIdList) {
		this.productIdList = produclIdList;
	}
}