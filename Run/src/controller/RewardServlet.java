package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.OrderService;

import bean.Order;

//import dao.orderservice;


@WebServlet("/RewardServlet")
public class RewardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status=request.getParameter("status");
	
		OrderService orderservice=new OrderService();
		String date=request.getParameter("date");
		Date rewardDate=java.sql.Date.valueOf(date);
		HttpSession session = request.getSession();
		
			//rewardDate.valueOf(request.getParameter("searchDate"));
			HashMap<String,Double> rewardMap=new HashMap<String,Double>();
			String offer=null;
			if(status.equals("viewOrderbyDate"))
			{
				try{
					rewardMap=orderservice.getTotalAmountOrderPerDate(rewardDate);
					request.setAttribute("rewarddate", rewardDate);
					request.setAttribute("rewardmap", rewardMap);
				}
				catch(Exception e)
				{
					request.setAttribute("failureMessage", "Unable to show orders of this date...Something went wrong"+e.getMessage());
					request.getRequestDispatcher("Failure.jsp").forward(request, response);
					
					
				}
				
			}
			if(status.equals("checkReward"))
			{
				try{
					String retailerId=request.getParameter("retailerId");
					session.setAttribute("rewardRetailerId", retailerId);
					double amount=Double.parseDouble(request.getParameter("amount"));
					offer=orderservice.getRetailerAvailOffer(amount);
					request.setAttribute("offer",offer);
				}
				catch(Exception e)
				{
					request.setAttribute("failureMessage", "Unable to show Reward Offers ...Something went wrong"+e.getMessage());
					request.getRequestDispatcher("Failure.jsp").forward(request, response);
					
					
				}
				
			}
			
			if(status.equals("placeRewardOrder"))
			{
				try{
					session.setAttribute("type", "reward");
					request.getRequestDispatcher("CreateOrder.jsp").forward(request, response);
				}
				catch(Exception e)
				{
					request.setAttribute("failureMessage", "Unable to show Reward Offers ...Something went wrong"+e.getMessage());
					request.getRequestDispatcher("Failure.jsp").forward(request, response);
				}
				
			}
	
		
		
	}

}
