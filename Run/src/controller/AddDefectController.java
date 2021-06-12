package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DefectProducts;

import services.DefectService;
import services.OrderService;


@WebServlet("/AddDefectController")
public class AddDefectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public AddDefectController() {
        
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RETAILER SESSION
		String status=request.getParameter("status");
		if(status.equals("ReportDefect"))
		{
			
				response.sendRedirect("ViewOrders.jsp");
			
		}
		if(status.equals("Report"))
		{
			OrderService orderservice = new OrderService();
			DefectService defectService = new DefectService();
			DefectProducts defect = new DefectProducts();
			try{
				long orderId = Long.parseLong(request.getParameter("OrderId"));
				String productCode=(String)request.getParameter("ProductCode");
				int check_flag = orderservice.checkOrderIdProductId(orderId,productCode);
				if(check_flag!=0){
					long time = System.currentTimeMillis();
					java.sql.Date date = new java.sql.Date(time);
					
					String defectDescription=(String)request.getParameter("DefectDescription");
					
					defect.setOrderId(orderId);
					defect.setDefectDescription(defectDescription);
					defect.setProductCode(productCode);
					defect.setNewOrderId(0);
					defect.setDefectDateTime(date);
					
					long defectOrderId = defectService.addDefect(defect);
					if(defectOrderId!=0){
						request.setAttribute("DefectOrderId", defectOrderId);
						RequestDispatcher rd = request.getRequestDispatcher("defectAddedConfirmation.jsp"); 
						rd.forward(request, response);
					}
					else
					{
						request.setAttribute("failureMessage", "could not update Defect Order details ...Enter Correct Order Id and Product Id!!");
						request.getRequestDispatcher("Failure.jsp").forward(request, response);
					}
					
				}
			}
			catch(Exception e){
				request.setAttribute("failureMessage", "could not update Defect Order details....Something went wrong!!"+e.getMessage());
				request.getRequestDispatcher("Failure.jsp").forward(request, response);
			}
		}
				
	}

}
