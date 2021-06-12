
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
       
</head>
<body>
     
         <!--Import jQuery before materialize.js-->
         <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
         <script type="text/javascript" src="js/materialize.min.js"></script>
      
  <nav>
         <div class="nav-wrapper">
         <a href="catalog.jsp" class="brand-logo left"><i class="material-icons">home</i></a>
         <a href="#" class="brand-logo center">Defect Management</a>
         <a href="Create.html" class="brand-logo right"><i class="material-icons">power_settings_new</i></a>

         </div>
  </nav>
  <br><br><br><br>

        <div class="row">
        <form class="col s8 offset-s2">
 <fieldset>
              <div class="row">
              <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">input</i>
              <input id="orderid" type="number" class="validate" length="11" maxlength="11" required>
              <label for="orderid" data-error="Please enter correct name.">OrderId</label>
              </div>
              </div>
          
              <div class="row">
              <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">input</i>
              <input id="name" type="text" class="validate" length="50" maxlength="50" required>
              <label for="name" data-error="Please enter correct name.">ProductCode</label>
              </div>
              </div>

      
              <div class="row">
              <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">mode_edit</i>
              <input id="description" type="text" class="validate" length="50" maxlength="50" required>
              <label for="description">Description</label>
              </div>
              </div>

       <br><br><br><br><br>
   <center>
               <button class="btn waves-effect waves-light" type="submit" name="action" HREF="/code-samples/basicpopup/" onClick="return popup(this, 'notes')">Submit
               <i class="material-icons right">send</i>
               </button>
     
               <button class="btn waves-effect waves-light" type="reset" name="action" >Reset
               <i class="material-icons left"></i>
               </button>
   </center>
</fieldset>
</form>
</body>
</html>


 