/**
 * @author 1082874 - Jekil
 */

package services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import bean.Customer;
import bean.Order;
import dao.OrderDAOImpl;
import util.DAOException;
import util.ServiceException;

public class OrderService {
	OrderDAOImpl orderDao = new OrderDAOImpl();
	/* Add New Customer using Customer Object */
	public int addCustomer(Customer cust) throws ServiceException {
		try {
			return orderDao.addCustomer(cust);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Update Customer Detail using Customer Object */
	public int updateCustomer(Customer cust) throws ServiceException {
		try {
			return orderDao.updateCustomer(cust);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Place New Order using Order Object */
	public long placeOrder(Order order) throws ServiceException {
		try {
			return orderDao.placeOrder(order);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Check Customer Details by Email or Id */
	public int checkCustomerDetails(String searchParameter, String searchValue) throws ServiceException {
		int status = 0;
		if(searchParameter.equals("customerId")) {
			try {
				status = orderDao.checkCustomerId(Long.parseLong(searchValue));
			} catch (NumberFormatException e) {
				throw new ServiceException(e.getMessage());
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
		else if(searchParameter.equals("customerEmail")) {
			try {
				status = orderDao.checkCustomerEmail(searchValue);
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
		return status;
	}
	/* Update Order Id with customer Id  */
	public int updateOrder(long orderId, long customerId) throws ServiceException {
		try {
			return orderDao.updateOrder(orderId, customerId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get New Unique product codes by giving model Id and quantity required for new order */
	public ArrayList<String> getAllProductCodes(HashMap<String,Integer> productDetail) throws ServiceException {
		try {
			return orderDao.getAllProductCodes(productDetail);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get total amount of all products */
	public double getTotalAmount(ArrayList<String> productCode)  throws ServiceException {
		try {
			return orderDao.getTotalAmount(productCode);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get order object by giving order Id */
	public Order getOrderById(long orderId) throws ServiceException {
		try {
			return orderDao.getOrderById(orderId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get customer object by giving Email id or Customer Id */
	public Customer getCustomerDetails(String searchParameter, String searchValue) throws ServiceException {
		Customer  customer = null;
		if(searchParameter.equals("customerId")) {
			try {
				customer = orderDao.getCustomerById(Long.parseLong(searchValue));
			} catch (NumberFormatException e) {
				throw new ServiceException(e.getMessage());
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
		else if(searchParameter.equals("customerEmail")) {
			try {
				customer = orderDao.getCustomerByEmail(searchValue);
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
		return customer;
	}
	/*Get all orders given by particular Retailer */
	public ArrayList<Order> viewOrderByRetailer(String retailerId) throws ServiceException {
		try {
			return orderDao.viewOrderByRetailer(retailerId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get all orders given by retailer id and date */
	public ArrayList<Order> viewOrderByDateWithRetailerId(Date date,String retailerId) throws ServiceException {
		try {
			return orderDao.viewOrderByDateWithRetailerId(date, retailerId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get all orders by Date */
	public ArrayList<Order> viewOrderByDate(Date date) throws ServiceException {
		try {
			return orderDao.viewOrderByDate(date);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get all orders by Status (processing/dispatched) */
	public ArrayList<Order> viewOrderByStatus(String status) throws ServiceException {
		try {
			return orderDao.viewOrderByStatus(status);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get all retailer id with total amount of order given on particular date */
	public HashMap<String,Double> getTotalAmountOrderPerDate(Date date) throws ServiceException {
		try {
			return orderDao.getTotalAmountOrderPerDate(date);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get offer avail by retailer by giving total amount of order per day */
	public String getRetailerAvailOffer(Double totalAmount) throws ServiceException {
		try {
			return orderDao.getRetailerAvailOffer(totalAmount);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Cancel particular order by order id if order is not dispatched yet */
	public int cancelOrder(long orderId) throws ServiceException {
		try {
			return orderDao.cancelOrder(orderId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get all customers by Retailer Id */
	public ArrayList<Customer> getCustomersByRetialerId(String retailerId) throws ServiceException {
		try {
			return orderDao.getCustomersByRetialerId(retailerId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/*Check order id or product id is valid or not for Defect request */
	public int checkOrderIdProductId(long orderId, String productCode) throws ServiceException {
		try {
			return orderDao.checkOrderIdProductId(orderId,productCode);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get all orders which can be canceled */
	public ArrayList<Order> getOrderByRetailerWithStatus(String retailerId, String status) throws ServiceException {
		try {
			return orderDao.getOrderByRetailerWithStatus(retailerId,status);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/* Get Model Name by giving unique Product Code */
	public String getModelNameByProductCode(String productCode) throws ServiceException {
		try {
			return orderDao.getModelNameByProductCode(productCode);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
