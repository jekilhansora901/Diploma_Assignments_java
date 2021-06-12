package bean;

import java.sql.Date;

public class DefectProducts {
	private long defectId;
	private long orderId;
	private String productCode;
	private String defectDescription;
	private long newOrderId;
	private Date defectDateTime;
		
		
	public DefectProducts() {
		super();
	}
	
	
	public DefectProducts(long defectId, long orderId, String productCode,
			String defectDescription, long newOrderId, Date defectDateTime) {
		super();
		this.defectId = defectId;
		this.orderId = orderId;
		this.productCode = productCode;
		this.defectDescription = defectDescription;
		this.newOrderId = newOrderId;
		this.defectDateTime = defectDateTime;
	}


	public long getDefectId() {
		return defectId;
	}
	public void setDefectId(long defectId) {
		this.defectId = defectId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getDefectDescription() {
		return defectDescription;
	}
	public void setDefectDescription(String defectDescription) {
		this.defectDescription = defectDescription;
	}
	public long getNewOrderId() {
		return newOrderId;
	}
	public void setNewOrderId(long newOrderId) {
		this.newOrderId = newOrderId;
	}
	public Date getDefectDateTime() {
		return defectDateTime;
	}
	public void setDefectDateTime(Date defectDateTime) {
		this.defectDateTime = defectDateTime;
	}
	
	

}
