/**
 * @author 1082874 - Jekil
 */
package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import bean.Customer;
import bean.Order;
import util.DAOException;

public interface OrderDAO {
	public int addCustomer(Customer cust) throws DAOException;
	public int updateCustomer(Customer cust) throws DAOException;
	public long placeOrder(Order order) throws DAOException;
	public int checkCustomerId(long custId) throws DAOException;
	public int checkCustomerEmail(String custEmail) throws DAOException;
	public int updateOrder(long orderId, long customerId) throws DAOException;
	public ArrayList<String> getAllProductCodes(HashMap<String,Integer> productDetail) throws DAOException;
	public double getTotalAmount(ArrayList<String> productCode)  throws DAOException;
	public Order getOrderById(long orderId) throws DAOException;
	public Customer getCustomerById(long custId) throws DAOException;
	public Customer getCustomerByEmail(String email) throws DAOException;
	public ArrayList<Order> viewOrderByRetailer(String retailerId) throws DAOException;
	public ArrayList<Order> viewOrderByDateWithRetailerId(Date date,String retailerId) throws DAOException ;
	public ArrayList<Order> viewOrderByDate(Date date) throws DAOException;
	public ArrayList<Order> viewOrderByStatus(String status) throws DAOException;
	public ArrayList<Order> getOrderByRetailerWithStatus(String retailerId, String status) throws DAOException;
	public HashMap<String,Double> getTotalAmountOrderPerDate(Date date) throws DAOException;
	public String getRetailerAvailOffer(Double totalAmount) throws DAOException;
	public int cancelOrder(long orderId) throws DAOException;
	public ArrayList<Customer> getCustomersByRetialerId(String retailerId) throws DAOException;
	public int checkOrderIdProductId(long orderId, String productCode) throws DAOException;
	public String getModelNameByProductCode(String productCode) throws DAOException;
}
