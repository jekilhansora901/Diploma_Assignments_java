

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderProduct;


@WebServlet("/ItemOrder")
public class ItemOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OrderProduct> product=new ArrayList<OrderProduct>();
		String orderString=request.getParameter("order");
		String orders[]=orderString.split("/");
		for(String productInfo: orders){
			String productDetail[]=productInfo.split(":");
			OrderProduct op=new OrderProduct();
			op.setModelID(productDetail[0]);
			op.setQty(productDetail[1]);
			product.add(op);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./OrderServlet");
		request.setAttribute("OrderProduct", product);
		rd.forward(request, response);
		
		
	}

}
