<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ page import="bean.Order" %>
<!DOCTYPE html>
<html>
    <head>
     
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="css/tile-style.css"  />
      <link type="text/css" rel="stylesheet" href="css/border.css"  />
      
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/tabs-script.js"></script>

      
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
			
	</head>

    <body>
      


<!--Main Body-->
       
 

   <div class="container">
   	<div class="w3-container w3-border w3-round-xlarge z-depth-1">
		<div class="tile blue hoverable">
			<p align="center"> Check Your Order From your Order-Id (Or) Date of Order</p>
		</div>
		
		
		<form action="OrderServlet" method="post">
		<input type="hidden" name="status" value="viewOrders">
			<table>
				<tr>
				<td>Order Id</td>
				<td><input type="text" name="orderId" placeholder="OrderID"/></td> 
			 	<td></td>
				<td> <button class="btn waves-effect waves-light" type="submit" name="searchParam" value="searchById">Search By Id</button></td>
				 	
				</tr>
				

				<tr>
				<td>Order Date</td>
				<td><input type="text" name="orderDate" placeholder="OrderDateTime"/></td> 
				<td></td>
					<td> <button class="btn waves-effect waves-light" type="submit" name="searchParam" value="searchByDate">Search By Date</button></td> 
				</tr>         
			</table>
		</form>
		
		
<!--Table For Details of Order-Id-->		
		
<table border="1" >
			<tr> 
			 <th bgcolor="grey">Order Id</th><th bgcolor="red" >Status</th><th bgcolor="green">Action</th> 
			</tr>
					        
			<%-- <tr class="success">
				<td><%= request.getAttribute("OrderID")  %></td>
				<td><%= request.getAttribute("OrderStatus") %></td>
				<td> <a href="ViewSingleOrder.jsp"><i class="material-icons">visibility</i></a><a href="cancel.jsp"><i class="material-icons">cancel</i></a></td>
			</tr>
									                                                      
			<tr class="info">
				<td><%= request.getAttribute("OrderID") %></td>
				<td><%= request.getAttribute("OrderStatus") %> </td>
				<td> <a href="ViewSingleOrder.jsp"><i class="material-icons">visibility</i></a> <a href="cancel.jsp"><i class="material-icons">cancel</i></a></td>
			</tr> --%>
			
			<% 
				String searchParam = (String)request.getAttribute("searchParam");
				if(searchParam != null) {
					if(searchParam.equals("searchById")) {
						Order order = (Order)request.getAttribute("order");
						if(order != null) {
							%><tr> <td><%=order.getOrderId() %></td>
								<td><%=order.getOrderStatus() %></td>
								<td>	<a href="ViewSingleOrder.jsp"><i class="material-icons">visibility</i></a>
										<a href="cancel.jsp"><i class="material-icons">cancel</i></a>
								</td>
							<%
						}
					}
					else if(searchParam.equals("searchByDate")) {
						@SuppressWarnings("unchecked")
						ArrayList<Order> orders = (ArrayList<Order>)request.getAttribute("orderList");
						if(orders != null) {
							for(Order order:orders) {
								%><tr> <td><%=order.getOrderId() %></td>
								<td><%=order.getOrderStatus() %></td>
								<td>	<a href="ViewSingleOrder.jsp"><i class="material-icons">visibility</i></a>
										<a href="cancel.jsp"><i class="material-icons">cancel</i></a>
								</td>
							<%
							}
						}
					}
				}
			%>
		</table>
	</div>
</div>
	<h4><% String msg = request.getParameter("msg");
					if(msg!=null) {
						out.print(msg);
					}
	%></h4>

      <!--Main body ends-->
    </body>
  </html>