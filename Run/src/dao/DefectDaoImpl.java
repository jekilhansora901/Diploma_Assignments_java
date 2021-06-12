package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import services.OrderService;
import util.DBConnection;

import bean.DefectProducts;
import bean.Order;

public class DefectDaoImpl implements DefectDao{
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Order order = new Order();
	public long addDefect(DefectProducts product) throws Exception{	
		
		int records_Added = 0;
		int records_Updated = 0;
		long newOrderId=0;
		try{		
			connection = DBConnection.getConnection();		
			String insertTableSQL = "INSERT INTO DEFECT_PRODUCTS"
				+ "(DEFECTID, ORDERID, PRODUCTCODE, DEFECTDESCRIPTION, DEFECTDATETIME, NEWORDERID) VALUES"
				+ "(?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(insertTableSQL);
	
			preparedStatement.setLong(1, product.getDefectId());
			preparedStatement.setLong(2, product.getOrderId());
			preparedStatement.setString(3, product.getProductCode());
			preparedStatement.setString(4, product.getDefectDescription());
			
			preparedStatement.setDate(5, product.getDefectDateTime());
			preparedStatement.setLong(6, product.getNewOrderId());
			
			records_Added = preparedStatement.executeUpdate();
			
			String selectSQL = "SELECT MODELID FROM PRODUCT WHERE PRODUCTCODE=?";
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, product.getProductCode());
			resultSet = preparedStatement.executeQuery(selectSQL);
			String modelId = resultSet.getString("MODELID");
			
			OrderService orderService = new OrderService();
			ArrayList<String> productCodes = new ArrayList<String>();
			HashMap<String,Integer> productIdMap = new HashMap<String,Integer>();
			productIdMap.put(modelId, 1);
			productCodes=orderService.getAllProductCodes(productIdMap);
			
			Order order1 = orderService.getOrderById(product.getOrderId());
			
			order.setOrderDateTime(product.getDefectDateTime());
			order.setCustomerId(order1.getCustomerId());
			order.setRetailerId(order1.getRetailerId());
			order.setOrderType("Normal");
			order.setOrderStatus("Processing");
			order.setProductId(productCodes);
			order.setOrderAmount(0);
			
			newOrderId = orderService.placeOrder(order);
			
			String updateTableSQL = "UPDATE DEFECT_PRODUCTS SET NEWORDERID = ? WHERE PRODUCTCODE = ?";		
			preparedStatement = connection.prepareStatement(updateTableSQL);
		
			preparedStatement.setLong(1, newOrderId);
			preparedStatement.setString(2, product.getProductCode());		
			records_Updated = preparedStatement.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			DBConnection.closeConnection(connection);
		}
		
		return newOrderId;
	}
	
	/*public int updateDefectDetails(DefectProducts product) throws Exception{	
	int records_Updated = 0;	
	try{		
		connection = DBConnection.getConnection();		
		String updateTableSQL = "UPDATE DEFECT_PRODUCTS SET DEFECTSTATUS = ? WHERE DEFECTID = ?";		
		preparedStatement = connection.prepareStatement(updateTableSQL);
	
		preparedStatement.setString(1, product.getDefectStatus());
		preparedStatement.setLong(2, product.getDefectId());		
		records_Updated = preparedStatement .executeUpdate();		
	}catch(Exception e){
		throw e;
	}finally{
		DBConnection.closeConnection(connection);
	}	
	return records_Updated;
}

public DefectProducts viewDefectDetails(int defectId) throws Exception{

	DefectProducts defectProducts = null;
	
	try{		
		connection = DBConnection.getConnection();		
		String selectSQL = "SELECT * FROM DEFECT_PRODUCTS WHERE DEFECTID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, defectId);
		resultSet = preparedStatement.executeQuery(selectSQL );
		
		
		long defectID = resultSet.getLong("DEFECTID");
		long orderId = resultSet.getLong("ORDERID");
		String productCode = resultSet.getString("PRODUCTCODE");
		String defectDescription = resultSet.getString("DEFECTDESCRIPTION");
		String defectStatus = resultSet.getString("DEFECTSTATUS");
		Date defectDateTime = resultSet.getDate("DEFECTDATETIME");
		
		defectProducts = new DefectProducts(defectID, orderId, productCode, defectDescription, defectStatus, defectDateTime);
		
	}catch(Exception e){
		throw e;
	}finally{
		DBConnection.closeConnection(connection);
	}	

	return defectProducts;
}
	
public boolean deleteDefectProduct(DefectProducts product) throws Exception{
	boolean delete_status = false;
	
	try{		
		connection = DBConnection.getConnection();		
		String deleteSQL = "DELETE DEFECT_PRODUCTS WHERE DEFECTID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setLong(1, product.getDefectId());
		
		int status = preparedStatement.executeUpdate();
		
		if((status&1) != 0) delete_status = true;
		
	}catch(Exception e){
		throw e;
	}finally{
		DBConnection.closeConnection(connection);
	}	

	return delete_status;
}*/
}
