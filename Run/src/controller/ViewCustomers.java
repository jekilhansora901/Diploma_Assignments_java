package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;

import services.OrderService;


@WebServlet("/ViewCustomers")
public class ViewCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session=request.getSession();
			String retailerId=session.getAttribute("retailerId").toString();
			OrderService orderservice=new OrderService();
			ArrayList<Customer> customerList=orderservice.getCustomersByRetialerId(retailerId);
			if(customerList.get(0)!=null)
			{
				request.setAttribute("customerList", customerList);
	        	request.getRequestDispatcher("ViewCustomerList.jsp").forward(request, response);
			}
			else
		    {
				String failure="No Customer Details fetched for this Retailer Id...";
				request.setAttribute("failureMessage", failure);
		        	
		    }
		}
		catch(Exception e)
		{
			String failure="No Customer details Found....Something went wrong"+e.getMessage();
			request.setAttribute("failureMessage", failure);
		}

	}

}
