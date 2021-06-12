package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.OrderService;
import util.ServiceException;

//import dao.orderservice;


import bean.Customer;
import bean.Order;
import bean.OrderProduct;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long time = System.currentTimeMillis();
		HttpSession session = request.getSession();
		//session.setAttribute("retailerid", "A1231");
		java.sql.Date date = new java.sql.Date(time);
		Order order=null;
		OrderService orderservice=new OrderService();
		long orderId=0;
		//get status of page you are visiting and work accordingly
		String status=(String)request.getParameter("status");
		if(status.equals("placeorder"))
		{
			try{
				String type=(String)request.getAttribute("type");
				order = new Order();
				order.setOrderDateTime(date);
				order.setRetailerId((String)(session.getAttribute("retailerid")));
				order.setOrderStatus("Processing");
				if(type.equals("reward"))
				{
					order.setOrderType("Reward");
				}
				else
				{
					order.setOrderType("Normal");
				}
				//get map from catalog containing model and quantity
				ArrayList<OrderProduct> arrprodlist;
				HashMap<String,Integer> productMap=new HashMap<String,Integer>(); 
				ArrayList<String> productList;
				arrprodlist=(ArrayList<OrderProduct>)request.getAttribute("OrderProduct");
				for(int i=0;i<arrprodlist.size();i++)
				{
					productMap.put(arrprodlist.get(i).getModelID(), Integer.parseInt(arrprodlist.get(i).getQty()));
				}
				//import dao package and call function to get product id from orderservice class
				//create object of this class
				productList=orderservice.getAllProductCodes(productMap);
				order.setProductId(productList);
				//call method to get total amount from same class as mentioned above
				double amnt=orderservice.getTotalAmount(productList);
				if(type.equals("reward"))
				{
					order.setOrderAmount(0);
					order.setCustomerId(Long.parseLong(session.getAttribute("rewardRetailerId").toString()));
				}
				else
				{
					order.setOrderAmount(amnt);
					order.setCustomerId(0);
				}
				
				
				orderId=orderservice.placeOrder(order);
				if(orderId!=0)
				{
					session.setAttribute("orderId", orderId);
					if(type.equals("reward"))
					{
						response.sendRedirect("ConfirmOrder.jsp");
					}
					else
					{
						request.getRequestDispatcher("CustomerForm.jsp").forward(request, response);
					}
					
				}
				else
				{
					request.setAttribute("failureMessage", "Order not Placed due to some error!!");
					request.getRequestDispatcher("Failure.jsp").forward(request, response);
				}
			
			}
			catch(Exception e)
			{
				request.setAttribute("failureMessage", "Order not Placed due to some error!!"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
				
			}
			
		}
		
		if(status.equals("addCustomer"))
		{
			
			try{
				String customerEmail=(String)request.getParameter("CustomerEmail");
				
				Customer customer=new Customer();
				int check_flag = orderservice.checkCustomerDetails("customerEmail",customerEmail);		//Check if the Customer Email already exists
				if(check_flag==0){
					String customerName=(String)request.getParameter("CustomerName");
					String customerAddress=(String)request.getParameter("CustomerAddress");
					String customerContact=(String)request.getParameter("CustomerContact");
					
					customer.setCustomerName(customerName);
					customer.setCustomerAddress(customerAddress);
					customer.setCustomerContact(customerContact);
					customer.setCustomerEmail(customerEmail);
					
					int customerAdded=orderservice.addCustomer(customer);
					if(customerAdded!=0){
						request.setAttribute("customerobj", customer);
						RequestDispatcher rd = request.getRequestDispatcher("CustomerForm.jsp"); 
						rd.forward(request, response);
					}
					
				}
				else{
					Customer customerObject = orderservice.getCustomerDetails("customerEmail",customerEmail);	//Fetch Customer Details
					request.setAttribute("CustomerObject",customerObject);
					RequestDispatcher rd = request.getRequestDispatcher("CustomerForm.jsp"); 
					rd.forward(request, response);
				}
				
			}
			catch(Exception e)
			{
				request.setAttribute("failureMessage", "Customer Cannot be added due to some error !!"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
			}
			
			
		}
		if(status.equals("search"))
		{
			try{
				String customerEmail=(String)request.getParameter("CustomerEmail");
				
				int check_flag = orderservice.checkCustomerDetails("CustomerEmail",customerEmail);		//Check if the Customer Email already exists
				if(check_flag!=0){
					Customer customerObject = orderservice.getCustomerDetails("CustomerEmail",customerEmail);	//Fetch Customer Details
					request.setAttribute("CustomerObject",customerObject);
					RequestDispatcher rd = request.getRequestDispatcher("CustomerForm.jsp"); 
					rd.forward(request, response);
				}
				else{
					response.sendRedirect("AddCustomer.jsp");
				}
				
		}
			catch(Exception e)
			{
				request.setAttribute("failureMessage", "Unable search for given Customer Email due to some error!!"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
			}
		
	
		
		
	}
		if(status.equals("confirm"))
		{
			try{
				long customerId=Long.parseLong(request.getParameter("custId"));
				long oId=Long.parseLong(session.getAttribute("orderId").toString());
				int update=orderservice.updateOrder(oId,customerId);
				if(update!=0)
				{
					Order ord=orderservice.getOrderById(oId);
					request.setAttribute("orderobject", ord);
					request.getRequestDispatcher("ConfirmOrder.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("Failure.jsp").forward(request, response);
				}
			}
			catch(Exception e)
			{
				request.setAttribute("failureMessage", "Could not confirm order....Something went wrong"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
				
			}
			
		}
		
		
		
		
		if(status.equals("Searchupdate")){
			try{
				String customerId = request.getParameter("CustomerId");
				int check_flag = orderservice.checkCustomerDetails("customerId",customerId);		//Check if the Customer ID is valid
				if(check_flag!=0){
					//if Customer ID is valid
					Customer customerObject = orderservice.getCustomerDetails("customerId",customerId);	//Fetch Customer Details
					request.setAttribute("CustomerObject",customerObject);
					RequestDispatcher rd = request.getRequestDispatcher("CustomerUpdateForm.jsp"); 
					rd.forward(request, response);
				}
				else{
					//if Customer ID is not valid
					PrintWriter out=response.getWriter();
					out.print("Enter a valid Customer ID");
					
					/*request.setAttribute("Message","Enter a valid Customer ID");
					RequestDispatcher rd = request.getRequestDispatcher("CustomerUpdateForm.jsp"); 
					rd.forward(request, response);*/
				}
			}
			catch(Exception e)
			{
				request.setAttribute("failureMessage", "Could not search for Customer id ...Something went wrong while Searching"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
				
			}
			
		}
		
		if(status.equals("Update")){
			try{
				long customerId = Long.parseLong(request.getParameter("CustomerId"));
				String customerName=(String)request.getParameter("CustomerName");
				String customerAddress=(String)request.getParameter("CustomerAddress");
				String customerContact=(String)request.getParameter("CustomerContact");
				String customerEmail=(String)request.getParameter("CustomerEmail");
				
				Customer customer=new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customerName);
				customer.setCustomerAddress(customerAddress);
				customer.setCustomerContact(customerContact);
				customer.setCustomerEmail(customerEmail);
				int customerUpdated = orderservice.updateCustomer(customer);
				
				if(customerUpdated!=0){
					
					RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomerConfirmation.jsp"); 
					rd.forward(request, response);
				}
			}
			catch(Exception e)
			{
				request.setAttribute("failureMessage", "Could not update customer info...Something went wrong"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
				
				
			}
			
		}
		if(status.equals("viewOrders")) {
			try{
				String retailerId="0";//session.getAttribute("retailerId").toString();
				String searchParam = request.getParameter("searchParam");
				request.setAttribute("searchParam", searchParam);
				if(searchParam.equals("searchById")) {
					String searchValue = request.getParameter("orderId");
					
					order = new Order();
					order = orderservice.getOrderById(Long.parseLong(searchValue));
					if(order.getOrderId() != 0) {
						request.setAttribute("order", order);
					}
					else {
						request.setAttribute("msg", "Invalied Order Id. Please Enter valied Order Id");
					}
				}
				else if(searchParam.equals("searchByDate")) {
					String searchValue = request.getParameter("orderDate");
					System.out.println(searchValue);
					java.sql.Date javaSqlDate = java.sql.Date.valueOf(searchValue);
					ArrayList<Order> orderList = orderservice.viewOrderByDateWithRetailerId(javaSqlDate, retailerId);
					if(orderList.size()>0) {
						request.setAttribute("orderList", orderList);
					}
					else {
						request.setAttribute("msg", "No Orders found in that Date. Please Select other Date.");
					}
				}
	        	request.getRequestDispatcher("ViewOrderDetails.jsp").forward(request, response);
			}
			catch(ServiceException e)
			{
				request.setAttribute("failureMessage", "Something Went Wrong. Please try again after some time.\n"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
			}
		}
	}


}

