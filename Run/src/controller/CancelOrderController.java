package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.OrderService;


@WebServlet("/CancelOrderController")
public class CancelOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status=request.getParameter("status");
		if(status.equals("cancelOrder"))
		{
			response.sendRedirect("CancelOrderForm.jsp");
		}
		else if(status.equals("Cancel"))
		{
			try{
				long orderId=Long.parseLong(request.getParameter("orderId"));
				OrderService orderservice=new OrderService();
				int cancel=orderservice.cancelOrder(orderId);
				if(cancel!=0)
				{
					request.setAttribute("OrderId", orderId);
					request.setAttribute("confirmMessage", "Your order has been successfully canceled"+orderId);
					request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("failureMessage", "Unable to Cancel Order.......No Records found with this Order Id");
					request.getRequestDispatcher("Failure.jsp").include(request, response);
				}
			}
			catch (Exception e) {
				request.setAttribute("failureMessage", "Unable to Process......Something went Wrong");
				request.getRequestDispatcher("Failure.jsp").include(request, response);
			}
			
		}
	}

}
