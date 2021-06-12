/**
 * @author 1082874 - Jekil
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.DAOException;
import util.DBConnection;
import util.DBException;
import bean.Customer;
import bean.Order;


public class OrderDAOImpl implements OrderDAO {
	
	Connection con = null;
	PreparedStatement pst = null;
	Statement st = null;
	ResultSet rst = null;
	public int addCustomer(Customer cust) throws DAOException{
		int noOfCustomerAdded = 0;
		try
		{
			con = DBConnection.getConnection();
			st = con.createStatement();
			rst = st.executeQuery("Select SEQ_Cust.NEXTVAL from dual");
			while(rst.next())
			{
				cust.setCustomerId(rst.getLong(1));
			}
			pst = con.prepareStatement("INSERT INTO CUSTOMER_INFORMATION(CUSTOMERID,CUSTOMERNAME,CUSTOMERADDRESS,CUSTOMERCONTACT,CUSTOMEREMAIL) VALUES (?,?,?,?,?)");
			pst.setLong(1, cust.getCustomerId());
			pst.setString(2, cust.getCustomerName());
			pst.setString(3, cust.getCustomerAddress());
			pst.setString(4, cust.getCustomerContact());
			pst.setString(5, cust.getCustomerEmail());
			noOfCustomerAdded = pst.executeUpdate();
			System.out.println(cust.getCustomerId());
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
			
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
			
		}
		return noOfCustomerAdded;
	}
	public int updateCustomer(Customer cust) throws DAOException {
		int noOfCustomerUpdated = 0;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("UPDATE CUSTOMER_INFORMATION set CUSTOMERNAME=?, CUSTOMERADDRESS=? ,CUSTOMERCONTACT=?, CUSTOMEREMAIL=? where CUSTOMERID = ?");
			pst.setString(1, cust.getCustomerName());
			pst.setString(2, cust.getCustomerAddress());
			pst.setString(3, cust.getCustomerContact());
			pst.setString(4, cust.getCustomerEmail());
			pst.setLong(5, cust.getCustomerId());
			noOfCustomerUpdated = pst.executeUpdate();
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return noOfCustomerUpdated;
	}
	public long placeOrder(Order order) throws DAOException {
		int noOfOrderAdded = 0;
		int noOfProductAdded = 0;
		try
		{
			con = DBConnection.getConnection();
			st = con.createStatement();
			rst = st.executeQuery("Select SEQ_ORDER.NEXTVAL from dual");
			while(rst.next())
			{
				order.setOrderId(rst.getLong(1));
			}
			pst = con.prepareStatement("INSERT INTO ORDERS(ORDERID,ORDERDATETIME,RETAILERID,CUSTOMERID,ORDERTYPE,ORDERSTATUS,ORDERAMOUNT) VALUES (?,?,?,?,?,?,?)");
			pst.setLong(1, order.getOrderId());
			pst.setDate(2, order.getOrderDateTime());
			pst.setString(3, order.getRetailerId());
			pst.setLong(4, order.getCustomerId());
			pst.setString(5, order.getOrderType());
			pst.setString(6, order.getOrderStatus());
			pst.setDouble(7, order.getOrderAmount());
			
			noOfOrderAdded = pst.executeUpdate();
			
			if(noOfOrderAdded != 0)
			{
				pst = con.prepareStatement("INSERT INTO ORDER_DETAILS(ORDERID,PRODUCTCODE) VALUES (?,?)");
				ArrayList<String> productCode = order.getProductId();
				for(String productcode : productCode) {
					pst.setLong(1, order.getOrderId());
					pst.setString(2, productcode);
					noOfProductAdded = pst.executeUpdate();
					if(noOfProductAdded == 0) {
						break;
					}
				}
			}
		}
		catch (DBException e) {
			
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		if(noOfOrderAdded != 0)
			return order.getOrderId();
		else
			return 0;
	}
	public int checkCustomerId(long custId) throws DAOException {
		long customerId=0;
		int status;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select * from CUSTOMER_INFORMATION where customerid = ?");
			pst.setLong(1, custId);
			rst = pst.executeQuery();
			
			while(rst.next()) {
				customerId = rst.getLong(1);
			}
			if(customerId != 0)
			{
				status = 1;
			}
			else 
			{
				status = 0;
			}
		}
		catch (DBException e) {
			
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return status;
	}
	public int checkCustomerEmail(String custEmail) throws DAOException {
		long customerId=0;
		int status;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select * from CUSTOMER_INFORMATION where customeremail = ?");
			pst.setString(1, custEmail);
			rst = pst.executeQuery();
			
			while(rst.next()) {
				customerId = rst.getLong(1);
			}
			if(customerId != 0)
			{
				status = 1;
			}
			else 
			{
				status = 0;
			}
		}
		catch (DBException e) {
			
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return status;
	}
	public int updateOrder(long orderId, long customerId) throws DAOException {
		int noOfOrderUpdated = 0;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("UPDATE ORDERS set CustomerID=? where orderid = ?");
			pst.setLong(1, customerId);
			pst.setLong(2, orderId);

			noOfOrderUpdated = pst.executeUpdate();
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return noOfOrderUpdated;
	}
	public ArrayList<String> getAllProductCodes(HashMap<String,Integer> productDetail) throws DAOException{
		ArrayList<String> productCode = new ArrayList<String>();
		PreparedStatement pst1 = null;
		String modelId = null;
		String productcode;
		int productQty;
		int qty=0;
		boolean isQtyAvail = false;
		try
		{
			con = DBConnection.getConnection();
			for(Map.Entry products:productDetail.entrySet()) {  
				  modelId = products.getKey().toString();
				  productQty = Integer.parseInt(products.getValue().toString());
				  pst = con.prepareStatement("Select count(ProductCode) from Product where ModelID = ? and ProductStatus = 'Available'");
				  pst.setString(1, modelId);
				  rst = pst.executeQuery();
				  
				  qty = 0;
				  while(rst.next()) {
					  qty = rst.getInt(1);	
				  }
			  	  if(qty >= productQty) {
					  isQtyAvail = true; 
				  }
			  	  else {
			  		  isQtyAvail = false;
			  		  break;
			  	  }
			}
			if(isQtyAvail) {

				for(Map.Entry products:productDetail.entrySet()) {  
					  modelId = products.getKey().toString();
					  productQty = Integer.parseInt(products.getValue().toString());
					  pst = con.prepareStatement("Select ProductCode from Product where ModelID = ? and ProductStatus = 'Available'");
					  pst.setString(1, modelId);
					  rst = pst.executeQuery();
					  
					  pst1 = con.prepareStatement("Update Product set ProductStatus = 'Allocated' where ProductCode = ?");
					  while(rst.next()) {
						  if(rst.getRow()<=productQty) {
							  productcode = rst.getString("ProductCode");
							  productCode.add(productcode);
							  pst1.setString(1, productcode);
							  pst1.executeUpdate();
						  }
						  else {
							  break;
						  }
					  }
				}
			}
			else
			  {
				  throw new DAOException("Product Quantity is less than order Quantity. Available Quantity : "+qty + " for Model : "+modelId);
			  }
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closePreparedStatement(pst1);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return productCode;
	}
	public double getTotalAmount(ArrayList<String> productCode) throws DAOException {
		double totalAmount = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select Model.ModelPrice from Model, Product where Model.ModelId = Product.ModelId and Product.ProductCode = ?");
			int qty = productCode.size();
			int i=0;
			while(qty >0) {
				pst.setString(1, productCode.get(i++));
				rst = pst.executeQuery();
				while(rst.next()) {
					totalAmount += rst.getDouble(1);
				}
				qty--;
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return totalAmount;
	}
	public Order getOrderById(long orderId) throws DAOException {
		ArrayList<String> productCode;
		Order order = null;
		try
		{
			productCode = new ArrayList<String>();
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select * from Order_details where orderid = ?");
			pst.setLong(1, orderId);
			rst = pst.executeQuery();
			
			while(rst.next()) {
				productCode.add(rst.getString("PRODUCTCODE"));
			}

			pst = con.prepareStatement("Select * from ORDERS where orderid = ?");
			pst.setLong(1, orderId);
			rst = pst.executeQuery();
			while(rst.next()) {
				order = new Order();
				order.setOrderId(orderId);
				order.setOrderDateTime(rst.getDate("ORDERDATETIME"));
				order.setRetailerId(rst.getString("RETAILERID"));
				order.setCustomerId(rst.getLong("CUSTOMERID"));
				order.setOrderType(rst.getString("ORDERTYPE"));
				order.setOrderStatus(rst.getString("ORDERSTATUS"));
				order.setOrderAmount(rst.getDouble("ORDERAMOUNT"));
				order.setProductId(productCode);
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return order;
	}
	public Customer getCustomerByEmail(String email) throws DAOException {
		Customer customer = null;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select * from CUSTOMER_INFORMATION where CUSTOMEREMAIL = ?");
			pst.setString(1, email);
			rst = pst.executeQuery();
			while(rst.next()) {
				customer = new Customer();
				customer.setCustomerId(rst.getLong("CUSTOMERID"));
				customer.setCustomerName(rst.getString("CUSTOMERNAME"));
				customer.setCustomerAddress(rst.getString("CUSTOMERADDRESS"));
				customer.setCustomerContact(rst.getString("CUSTOMERCONTACT"));
				customer.setCustomerEmail(rst.getString("CUSTOMEREMAIL"));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return customer;
	}
	public Customer getCustomerById(long custId) throws DAOException {
		Customer customer = null;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select * from CUSTOMER_INFORMATION where CUSTOMERID = ?");
			pst.setLong(1, custId);
			rst = pst.executeQuery();
			while(rst.next()) {
				customer = new Customer();
				customer.setCustomerId(rst.getLong("CUSTOMERID"));
				customer.setCustomerName(rst.getString("CUSTOMERNAME"));
				customer.setCustomerAddress(rst.getString("CUSTOMERADDRESS"));
				customer.setCustomerContact(rst.getString("CUSTOMERCONTACT"));
				customer.setCustomerEmail(rst.getString("CUSTOMEREMAIL"));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return customer;
	}
	public ArrayList<Order> viewOrderByRetailer(String retailerId) throws DAOException {
		ArrayList<Long> orderId = new ArrayList<Long>();
		ArrayList<Order> orders = new ArrayList<Order>();
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select ORDERID from ORDERS where Retailerid = ?");
			pst.setString(1, retailerId);
			rst = pst.executeQuery();
			while(rst.next()) {
				orderId.add(rst.getLong("ORDERID"));
			}
			for(long orderid : orderId) {
				orders.add(getOrderById(orderid));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return orders;
	}
	public ArrayList<Order> viewOrderByDate(Date date) throws DAOException {
		ArrayList<Long> orderId = new ArrayList<Long>();
		ArrayList<Order> orders = new ArrayList<Order>();
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select ORDERID from ORDERS where ORDERDATETIME = ?");
			pst.setDate(1, date);
			rst = pst.executeQuery();
			while(rst.next()) {
				orderId.add(rst.getLong("ORDERID"));
			}
			for(long orderid : orderId) {
				orders.add(getOrderById(orderid));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return orders;
	}
	public ArrayList<Order> viewOrderByDateWithRetailerId(Date date,String retailerId) throws DAOException {
		ArrayList<Long> orderId = new ArrayList<Long>();
		ArrayList<Order> orders = new ArrayList<Order>();
		
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select ORDERID from ORDERS where ORDERDATETIME = ? and RETAILERID = ?");
			pst.setDate(1, date);
			pst.setString(2, retailerId);
			rst = pst.executeQuery();
			while(rst.next()) {
				orderId.add(rst.getLong("ORDERID"));
			}
			for(long orderid : orderId) {
				orders.add(getOrderById(orderid));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return orders;
	}
	public ArrayList<Order> viewOrderByStatus(String status) throws DAOException {
		ArrayList<Long> orderId = new ArrayList<Long>();
		ArrayList<Order> orders = new ArrayList<Order>();
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select ORDERID from ORDERS where ORDERSTATUS = ?");
			pst.setString(1, status);
			rst = pst.executeQuery();
			while(rst.next()) {
				orderId.add(rst.getLong("ORDERID"));
			}
			for(long orderid : orderId) {
				orders.add(getOrderById(orderid));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return orders;
	}
	public ArrayList<Order> getOrderByRetailerWithStatus(String retailerId, String status) throws DAOException {
		ArrayList<Long> orderId = new ArrayList<Long>();
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select ORDERID from orders where RetailerId = ? and OrderStatus = ?");
			pst.setString(1, retailerId);
			pst.setString(2, status);
			rst = pst.executeQuery();
			while(rst.next()) {
				orderId.add(rst.getLong("ORDERID"));
			}
			for(long orderid : orderId) {
				orders.add(getOrderById(orderid));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return orders;
	}
	
	public HashMap<String,Double> getTotalAmountOrderPerDate(Date date) throws DAOException {
		HashMap<String,Double> ordersAmount = null;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("SELECT RetailerId, sum(amount) from orders where orderstatus = 'Dispatched' and orderdatetime=? group by retailerid");
			pst.setDate(1, date);
			rst = pst.executeQuery();
			ordersAmount = new HashMap<String, Double>();
			while(rst.next()) {
				ordersAmount.put(rst.getString(1), rst.getDouble(2));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return ordersAmount;
	}
	public String getRetailerAvailOffer(Double totalAmount) throws DAOException {
		String offer = null;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select offer from Promotion where value <= ? and value = (select max(value) from Promotion where value <= ?)");
			pst.setDouble(1, totalAmount);
			pst.setDouble(2, totalAmount);
			while(rst.next()) {
				offer = rst.getString(1);
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return offer;
	}
	public int cancelOrder(long orderId) throws DAOException {
		int status = 0;
		PreparedStatement pst1;
		PreparedStatement pst2;
		Order order = null;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select OrderId from orders where orderId = ? and orderStatus = 'Processing'");
			pst.setLong(1, orderId);
			rst = pst.executeQuery();
			int noOfRow = 0;
			while(rst.next()) {
				noOfRow++;
			}
			if(noOfRow != 0) {
				pst1 = con.prepareStatement("Update Orders set OrderStatus = 'Cancel' where OrderId = ?");
				pst1.setLong(1, orderId);
				status = pst1.executeUpdate();
				if(status != 0) {
					pst2 = con.prepareStatement("UPDATE Product SET ProductStatus='Available' where ProductCode = ?");
					order = getOrderById(orderId);
					for(String productCodes : order.getProductId()) {
						pst2.setString(1, productCodes);
						pst2.executeUpdate();
					}
				}
			}
			else {
				throw new DAOException("Order Id and Product Code combination did not match. Please Verify OrderId and Product Code");
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return status;
	}
	public ArrayList<Customer> getCustomersByRetialerId(String retailerId) throws DAOException {
		ArrayList<Customer> customers = null;
		long custId=0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select CustomerId from orders where retailerId = ? ");
			pst.setString(1, retailerId);
			rst = pst.executeQuery();
			customers = new ArrayList<Customer>();
			while(rst.next()) {
				custId = rst.getLong(1);
				customers.add(getCustomerById(custId));
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return customers;
	}
	public int checkOrderIdProductId(long orderId, String productCode) throws DAOException {
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select 1 from ORDER_DETAILS where OrderID = ? and ProductCode = ?");
			pst.setLong(1, orderId);
			pst.setString(2, productCode);
			rst = pst.executeQuery();
			int rows = 0;
			while(rst.next()) {
				rows++;
			}
			if(rows != 0) {
				status = 1;
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return status;
	}
	public String getModelNameByProductCode(String productCode) throws DAOException {
		String modelName=null;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("Select ModelName from Model,Product where Model.ModelId=Product.ModelId and Product.ProductCode = ?");
			pst.setString(2, productCode);
			rst = pst.executeQuery();
			while(rst.next()) {
				modelName = rst.getString(1);
			}
		}
		catch (DBException e) {
			throw new DAOException(e.getMessage());
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				DBConnection.closeConnection(con);
				DBConnection.closePreparedStatement(pst);
				DBConnection.closeResultSet(rst);
			} catch (DBException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return modelName;
	}
}

