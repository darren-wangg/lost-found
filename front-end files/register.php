<?php

require 'config/config.php';

//double-check what register_form.php is giving us
// var_dump($_POST);

//Server-side validation even though client-side also validated JS (pretty easy to hack JS)
if ( isset($_POST['email-register']) && isset($_POST['username-register']) && isset($_POST['password-register'])) {
	if(empty($_POST['email-register']) || empty($_POST['username-register']) || empty($_POST['password-register'])){
        $error = "Please fill out all required fields.";
    }
    else {
        // connect to the database and insert this new user into the users table we just created
        $mysqli = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
    
        if($mysqli->connect_errno) {
            echo $mysqli->connecT_error;
            exit();
        }
    
        //check if this username or email address already exists in the users table
        // use SELECT statement to see if this username or email already exists in the table
        $statement_registered = $mysqli->prepare("SELECT * FROM users WHERE username = ? OR email = ?");
        $statement_registered->bind_param("ss", $_POST["username-register"], $_POST["email-register"]);
    
        $executed_registered = $statement_registered->execute();
        if(!$executed_registered) {
            echo $mysqli->error;
        }
        // With prepared statements, once you get results, we have to call store_results() method to get the results
        $statement_registered->store_result();
        //Then we can get the num rows we got back
        $numrows = $statement_registered->num_rows;
        $statement_registered->close();
    
        echo "<h4> Number of rows: </h4>" . $numrows;
    
        // If we get even 1 result, it means username, email, or both exist in the table/db
        if($numrows > 0) {
            $error = "Username or email address has already been taken. Please choose another one.";
        }
        else {
            // Run the password through sha256 hashing algorithm
            // 1st arg: the name of the algorithm
            // 2nd arg: the password user input
            $password = hash("sha256", $_POST["password-register"]);
    
            //Generate INSERT sql statement
            // Prepared statement (to prevent SQL injection)
            $statement = $mysqli->prepare("INSERT INTO users(username, email, password) VALUES(?,?,?)");
            $statement->bind_param("sss", $_POST["username-register"], $_POST["email-register"], $password);
            
            $executed = $statement->execute();
            if(!$executed) {
                echo $mysqli->error;
            }
            $statement->close();
    
            $mysqli->close();
            header('Location: login.php');
        }
    }
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
                <form method="POST" action="register.php">
                    <label for="email-register"></label>
                    <input type="text" id="email-register" name="email-register" placeholder="Email"><br><br>
                    <label for="username-register"></label>
                    <input type="text" id="username-register" name="username-register" placeholder="Username"><br><br>
                    <label for="password-register"></label>
                    <input type="text" id="password-register" name="password-register" placeholder="Password"><br><br>
                    <div class="font-italic text-danger">
                    <!-- Show errors here. -->
                    <?php
                      if ( isset($error) && !empty($error) ) {
                        echo $error . "<br><br>";
                      }
                    ?>
                    </div>
                    <input id="register-submit-btn" type="submit" value="Register">
                </form>
                <p class="login-prompt"><a href="login.php">Already have an account</a></p>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>