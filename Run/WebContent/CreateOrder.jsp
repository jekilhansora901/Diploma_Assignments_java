<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ page import="bean.Model" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- css styles -->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Order</title>
<script>
	function removeRow(button){

		var row=button.parentNode.parentNode;
		var i=row.rowIndex;
		document.getElementById("productList").deleteRow(i);
		
	}
	
	function insert(){
		var selectedModel=document.getElementById("catalog");
		var selected=selectedModel.options[selectedModel.selectedIndex].value;
		var qty=document.getElementById("qty").value;
		if(qty=='' || qty<1 || qty%1>0){
			alert("Enter a valid Quantity");
			return;
		}
		var infoArr=selected.split("/");
				
		var row='<tr>'+'<td>'+infoArr[0]+'</td>'+'<td>'+infoArr[1]+'</td>'+'<td>'+qty+'</td>'+'<td><input type=\'button\' value=\'Remove\' onclick=\'removeRow(this)\'></td>'+'</tr>';
		
		var cart=document.getElementById("productList");
		cart.innerHTML+=row;
	}
	
	function placeOrder(){
		var products='';
		var rows=document.getElementById("productList").childNodes;
		try{
			for(var i=2;i<=rows.length;i++){
				if(rows.item(i).innerHTML.toString().trim()!=''){
					var data=rows[i].getElementsByTagName('td');
					products+=modelObj(data[0].innerHTML, data[2].innerHTML);
				}
			}
		}catch(err){}
		finally{
			if(confirm("Do you want to make this order?")){
				var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (xhttp.readyState == 4 && xhttp.status == 200) {
				      alert("You Ordered : "+ xhttp.responseText);
				    }
				  };
				  xhttp.open("GET","./ItemOrder?order="+products+"&rand="+Math.random(), true);
				  xhttp.send();
			}			
		}		
	}
	
	function modelObj(id,qty){
		return id+':'+qty+'/';
	}
	
	
</script>

</head>
<body>
	<div class="container">
		<div style="display: block;">
			<div class="input-field col s12" style="display: inline-block;">
				<select id="catalog" class="browser-default" style="width: 25em;">
					<%
						@SuppressWarnings("unchecked")
						ArrayList<Model> al= (ArrayList<Model>)request.getAttribute("Models");
						if(al != null) {
						for(Model model:al){
							%>
								<option value='<%=model.getModelName()+"/"+model.getModelPrice()%>'> <%=model.getModelName() %> </option>
							<%
						}
						}
					%>
				</select> 
			</div>
			<div style="display: inline-block;">
				<input type="number" maxlength="3" id="qty" placeholder="Quantity" >
			</div>
			<div style="display: inline-block;">
				<a class="waves-effect waves-light btn" onclick='insert()'>Insert</a>
			</div>	
			<div style="display: inline-block;"><a class="waves-effect waves-light btn" onclick="placeOrder()">Place Order</a></div>
		</div>
		
		<div style="display:block;">
			<table id="productList" border="2em" class="striped"> 
				<tr><th  data-field="name">Product Name</th> <th data-field="price">Price</th> <th data-field="Qty">Qty</th><th> </th></tr>
				
			</table>
		</div><br>
		
		
	</div>
	
	<!-- Footer -->
	
</body>
</html>