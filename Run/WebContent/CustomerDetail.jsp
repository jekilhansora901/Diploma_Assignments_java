<!DOCTYPE html>
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
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
  

  <div class="row">
    <form class="col s8 offset-s2">
      <fieldset>
          <div class="row">
            <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">account_circle</i>
              <input id="name" type="text" class="validate" length="50" maxlength="50" required>
              <label for="name" data-error="Please enter correct name.">Name</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">email</i>
              <input id="email" type="email" class="validate" length="50" maxlength="50" required>
              <label for="email" data-error="Please enter correct email.">Email</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">room</i>
              <input id="address" type="text" class="validate" length="50" maxlength="50" required>
              <label for="address">Address</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">phone</i>
              <input id="phone" type="tel" class="validate" length="11" maxlength="11" required>
              <label for="phone">Telephone</label>
            </div>
          </div>
 </div>
    </fieldset>
    <p>
    <footer>
<br><br><br>
    <div class="row">
      <div class="col s4 offset-s3">
        <button class="btn waves-effect waves-light" type="submit" name="action">Submit
        <i class="material-icons right">send</i>
        </button>
      </div>
      
       <div class="col s4 offset-s13">
        <button class="btn waves-effect waves-light" type="reset" name="action" >Reset
        <i class="material-icons left"></i>
        </button>
      </div>
    </div>
        
    </footer>
    </p>
    </form>
  </div>
<script type="text/javascript" src="js/myscript.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
</body>

</html> 