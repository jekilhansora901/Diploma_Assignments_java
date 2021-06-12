
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>View Order Details</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css\materialize.min.css"  media="screen,projection"/>
 <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="css/tile-style.css"  />
      <link type="text/css" rel="stylesheet" href="css/border.css"  />
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="container">
          <div class="w3-container w3-border w3-round-xlarge z-depth-4">

    <div class="row" >
    <div class="col s12 m9">
          <div class="tile blue hoverable">
            <div class="card-content white-text">
              <span class="card-title" ><p align="center">Customer Details</p></span>                                                                      
            </div>

          </div>
         <i>Customer can see list of products here.</i>
        </div>
     
        <div class="col s12 m3">
          <div class="card blue-grey darken-1 center">
            <div class="card-content white-text">
              <span class="card-title">Customer Details</span>
               <table><tr><th>Customer Id</th>
	                     <td><%= request.getAttribute("CustomerID") %></td></tr>                                                        
	                     <tr><th>Customer Name</th>
	                     <td><%= request.getAttribute("CustomerName") %></td></tr>
	                    <tr><th>Address</th>
	                     <td><%= request.getAttribute("CustomerAddress") %></td></tr>
					  <tr><th>Contact</th>
	                     <td><%= request.getAttribute("CustomerContact") %></td></tr>   </table>
	                                                                               
            </div>
          </div>
        </div>

      </div>
      
     
   <div class="row" >
        <div class="col s12 m16">
          <div class="card grey darken-1">
            <div class="card-content white-text">
              <span class="card-title"> Products Details </span>
                         <table border="1" align="center" class="order-list">
							 <tr><th>OrderID</th> <td><%= request.getAttribute("OrderID") %></td></tr> 
							 <tr><th>OrderDateTime</th><td><%= request.getAttribute("OrderDateTime") %></td></tr>
					         <tr><th>OrderType</th> <td><%= request.getAttribute("OrderType") %></td></tr>
						     <tr><th>OrderStatus</th> <td><%= request.getAttribute("OrderStatus") %></td></tr>
						   	 <tr><th>OrderAmount</th> <td><%= request.getAttribute("OrderAmount") %></td></tr>
						</table>
            </div>
          </div>
        </div>
      </div>

<ul class="pagination center">
    <li class="disabled"><a href="ViewOrderDetails.jsp"><i class="material-icons">chevron_left</i></a></li>
  </ul>
</div></div> </div></div>
  

</body>
</html>