<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
	<!-- css styles -->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
</head>
<script>	function insert(){
	    var email=document.getElementById("email");
                    if(email=="" || email== null)
                    	{
                    	
                    	alert("Enter Valid Email ");
                    	return false;}
                    return true;
                    	}
	</script>
<body>
	<div class="container">
		<div style="display: block;">
			<div style="display: inline-block;">
			<table align="right">
			<tr><td> <div class="row">
            <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">email</i>
              <input  id="email" type="email" class="validate" length="50" maxlength="50" required>
              <label for="email" data-error="Please enter correct email.">Email</label>
            </div>
          </div></td>
			<td></td>
			     <td><a class="waves-effect waves-light btn" onclick=' return insert()'>Search Customer</a></td></tr></table>
				
			</div>	
		</div><br><br>
		
		
		<a href="CustomerDetail.jsp?status=Add" class="waves-effect waves-light btn right" name="status" value="Add">Add Customer</a>
		           <a href="CustomerDetail.jsp?status=Update" class="waves-effect waves-light btn"  name="status" value="Update">Update Customer</a>	<br><br>
		         
		
		<div style="display:block;">
			<table id="productList" border="2em" class="striped"> 
				<tr><th  data-field="customerId">Customer Id</th> <th data-field="customerName">Customer Name</th> <th data-field="customerAddress">Customer Address</th><th data-field="customerContact">Customer Contact </th></tr>
				<tr><th>Id</th>
				    <th>Name</th>
				    <th>Address</th>
				    <th>Contact</th></tr>
			</table>
		</div>
		<br>
		<div align="center"><a href="" class="waves-effect waves-light btn">Confirm Order</a></div>
		
	</div>
	
	<!-- Footer -->
</body>
</html>