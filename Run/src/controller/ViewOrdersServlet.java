package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.OrderService;

import bean.Order;


@WebServlet("/ViewOrdersServlet")
public class ViewOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status=request.getParameter("status");
		if(status.equals("ViewOrders"))
		{
			
				response.sendRedirect("ViewOrders.jsp");
			
		}
		if(status.equals("View"))
		{
			try{
				OrderService orderdao=new OrderService();
				HttpSession session=request.getSession();
				String retailerId=session.getAttribute("retailerId").toString();
				String date=request.getParameter("date");
				Date ordersByDate=java.sql.Date.valueOf(date);
				ArrayList<Order> viewOrdersByDateList=orderdao.viewOrderByDateWithRetailerId(ordersByDate,retailerId);
		        if(viewOrdersByDateList.get(0)!=null)
		        {
		        	request.setAttribute("ordersByDateList", viewOrdersByDateList);
		        	request.getRequestDispatcher("ViewOrdersByDate.jsp").forward(request, response);
		        }
		        else
		        {
		        	String failure="No datas fetched for this date....please enter another date and try again";
					request.setAttribute("failureMessage", failure);
		        }
			}
			catch(Exception e)
			{
				String failure="No datas fetched for this date....Something went wrong"+e.getMessage();
				request.setAttribute("failureMessage", failure);
			}
		}
		
	}

}
