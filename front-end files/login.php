<?php
    // Must call this function at the top of the file to use sessions in the file
    session_start();
    require 'config/config.php';

    // User will use GET request to simply visit the page. If user is trying to login but submtiting username and password, it will make a POST request

    // Giant if statement here. If user is NOT logged in, do the usual things. Else, redirect them out of this page.
    if( !isset($_SESSION["logged_in"]) || !$_SESSION["logged_in"] )  {
        // User will use GET request if simply trying to visit the page
        // check if username and password were submitted via POST method (they can get in via login link- GET-, or via the login page when they tried to submit the form and it redirected it to itself- POST-). If so, the user is attempting to login.
        if ( isset($_POST['username']) && isset($_POST['password']) ) {

            //Check if user has entered in both username AND password
            if ( empty($_POST['username']) || empty($_POST['password']) ) {

                $error = "Please enter username and password.";

            }
            //Check if user typed in correct credentials
            else {

                $mysqli = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

                if($mysqli->connect_errno) {
                    echo $mysqli->connect_error;
                    exit();
                }

                //How to check?
                //1. Get this user's record from DB
                //2. Compare the passwords to check if password is correct
                    // hash what the user gave us
                $passwordInput = hash("sha256", $_POST["password"]);

                // use prepared statement here instead
                $sql = "SELECT * FROM users
                            WHERE username = '" . $_POST['username'] . "' AND password = '" . $passwordInput . "';";

                // echo "<hr>" . $sql . "<hr>";
                
                $results = $mysqli->query($sql);

                if(!$results) {
                    echo $mysqli->error;
                    exit();
                }
                // if we return ONE result back, it means the username/pw combo is correct!
                if($results->num_rows == 1) {
                    // log user in, save their info
                    $_SESSION["logged_in"] = true;
                    $_SESSION["username"] = $_POST["username"];

                    //redirect the user to the home page
                    // header() makes a GET request
                    //pass in the path that we want to redirect the user to
                    // header("Location: https://www.google.com");
                    header("Location: home.php");

                }
                // if($results->num_rows > 0) {
                    
                
                // }
                else {
                    $error = "Invalid username or password.";
                }
            } 
        }
    }
    else {
        // Redirect the user out of this page
        header("Location: home.php");
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login/Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="general.css">
</head>
<body>
  <?php include 'nav.php'; ?>
  <div class="container login-container">
      <div class="row h-100 inputs-div align-items-center">
          <div class="column my-auto">
              <img id="face1-login" src="images/face1.png"/>
              <form method="POST" action="login.php">
                  <label for="username"></label>
                  <input type="text" id="username" name="username" placeholder="Username"><br><br>
                  <label for="password"></label>
                  <input type="password" id="password" name="password" placeholder="Password"><br><br>
                  <div class="font-italic text-danger">
                    <!-- Show errors here. -->
                    <?php
                      if ( isset($error) && !empty($error) ) {
                        echo $error . "<br><br>";
                      }
                    ?>
                  </div>
                  <input id="login-submit-btn" type="submit" value="Login">
              </form>
              <p class="reg-prompt">Not registered? <a href="register.php">Register here.</a></p>
          </div>
      </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
