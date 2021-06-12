
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
      <script>
      
      $(document).ready(function() {
    	    Materialize.updateTextFields();
    	  });
    	      
      </script>
      
      
      
      
      
      
      <SCRIPT TYPE="text/javascript">
  function popup(mylink, windowname) { 
    if (! window.focus)return true;
    var href;
    if (typeof(mylink) == 'string') href=mylink;
    else href=mylink.href; 
    window.open(href, windowname, 'width=400,height=200,scrollbars=yes'); 
    return false; 
  }
</SCRIPT>


      
      
      
      
      
      
      
      
      
      
    </head>

    <body>
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      
      
      
       <nav>
    <div class="nav-wrapper">
      
        <a href="Create.html" class="brand-logo left"><i class="material-icons">home</i></a>
         <a href="#" class="brand-logo center">Defect Management</a>
        <a href="Create.html" class="brand-logo right"><i class="material-icons">power_settings_new</i></a>

</div>
</nav><br><br><br><br>

    <div class="row">
    <div class="input-field col s6">
      <input value="" id="order-id" type="text" class="validate">
      <label class="active" for="order-id"><h6>OrderId</h6></label>
    </div>
  </div>
    
  <div class="row">
    <div class="input-field col s6">
      <input value="" id="product-code" type="text" class="validate">
      <label class="active" for="product-code"><h6>ProductCode</h6></label>
    </div>
  </div>
        
         <div class="row">
    <div class="input-field col s6">
      <input value="" id="description" type="text" class="validate">
      <label class="active" for="description"><h6>Description</h6></label>
    </div>
  </div>
        
<br><br><br><br><br>

  <button class="btn waves-effect waves-light" type="submit" name="action" HREF="/code-samples/basicpopup/" onClick="return popup(this, 'notes')">Submit
    <i class="material-icons right">send</i>
    
  </button>
  
<a class="waves-effect waves-light btn right" >Cancel</a>
</body>
</html>




