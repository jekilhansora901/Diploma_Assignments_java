<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ page import="bean.Order" %>
 <%@ page import="services.OrderService" %>
 <%@ page import="bean.Customer" %>
 <%@ page import="java.util.ArrayList" %>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
 <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>


<title>Cancellation Page</title>
</head>
<body>
<% Order order = (Order)request.getAttribute("order"); %>
  <div class="row">
        <div class="col s13 m5">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Order Information:</span>
               <table >
					<%if(order != null) {%>
					<tr>
					  	<td>Order Id:</td>
					  	<td><%= order.getOrderId() %></td>
					</tr>
				  	<tr>
				  		<td>Date:</td>
				  		<td><%= order.getOrderDateTime() %></td>
			  		</tr>  
				  	<tr>
				  		<td>Retailer Name:</td>
				  		<td><%= order.getRetailerId() %></td>
			  		</tr>
			  		<% } else {
			  			%> 
			  			<tr>
					  	<td>Order Id:</td>
					  	<td></td>
					</tr>
				  	<tr>
				  		<td>Date:</td>
				  		<td></td>
			  		</tr>  
				  	<tr>
				  		<td>Retailer Name:</td>
				  		<td></td>
			  		</tr>
			  		<%
			  		} %>
			  </table>
            </div>
          </div>
        </div>
        
     <div class="col s12 m5">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Customer Details:</span>     
	  <table>
	  <% OrderService orderService = new OrderService();
	  	if(order != null) {
	  	 long custId = order.getCustomerId();
	  	 Customer customer = orderService.getCustomerDetails("customerId", Long.toString(custId));
	  	 if(customer != null) {
	  %>
			<tr>
			  	<td>Customer Name:</td>
			  	<td><%= customer.getCustomerName() %></td>
		  	</tr>
		  	<tr>
			  	<td>Phone Number:</td>
			  	<td><%= customer.getCustomerContact() %></td>
	  		</tr>
		  	<tr>
		  		<td>Address:</td>
		  		<td><%= customer.getCustomerAddress() %></td>
	  		</tr>
			<% } } else { %>
			<tr>
			  	<td>Customer Name:</td>
			  	<td></td>
		  	</tr>
		  	<tr>
			  	<td>Phone Number:</td>
			  	<td></td>
	  		</tr>
		  	<tr>
		  		<td>Address:</td>
		  		<td></td>
	  		</tr>
	  		 <% } %>
	  </table>
  </div>
    </div>
    </div>      
    </div>
    <div class="row">
  <div class="col s12 m10">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Product Information:</span>
               <table class="stripped" border="1px">
               	<tr>  
               		<thead>
			     		<th data-field="id">Model Name</th>
				  		<th data-field="id">Product Code</th>
			  		</thead>
		  		</tr>
		  		<% 
		  			ArrayList<String> productCode = new ArrayList<String>();
		  			if(order != null) {
		  				productCode = order.getProductId();
		  				for(int index=0;index<productCode.size();index++) {
		  					%> 
		  					<tr>
		  						<td><%=orderService.getModelNameByProductCode(productCode.get(index)) %> </td>
		  						<td><%=productCode.get(index) %></td>
		  					</tr>
		  					<%
		  				}
		  			}
		  		%>
			  </table>
            </div>
            
            </div>
          </div>
          </div>
          
 
 
<div class="row">
      <div class="col s12 m6">
      
        <div class="card-panel teal ">
          <span class="white-text">
          <i class="material-icons"></i>
          Total Amount: 
			<% if(order!=null) {
				out.println(order.getOrderAmount());
			}%>		   
           </span>
        </div>
      </div>
    </div>  
 
<div class="center-align">
<div class="row">
      <div class="col s12 m12">
      
        <div class="card-panel teal ">
          <span class="white-text">
          <i class="material-icons"></i>
          <% String cnfMessage = (String)request.getAttribute("cnfMessage");
          	 if(cnfMessage!= null) {
          	 	out.println(cnfMessage);
          	 }%> 
		   <a class="waves-effect waves-light btn-large" href="./catalog.jsp"><i class="material-icons center">home</a>
           </span>
        </div>
      </div>
    </div>
    </div>     
 
</body>
</html>