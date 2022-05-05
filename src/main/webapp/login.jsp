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
  <nav class="navbar navbar-expand-md navbar-expand-lg navbar-light" style="background-color: #FF9736" >
    <div class="container-fluid">
        <a class="navbar-brand" href="home.php">
            <img src="images/logo-graphic.png" width="30" height="30" class="d-inline-block align-top" alt="">
            Stamina
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
            <a class="nav-link" aria-current="page" href="home.php">Home</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="view.php">View</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="post.php">+ Add Workout</a>
            </li>
        </ul>
        <span class="navbar-text">
                <a class="login-register" href="login.php">Login/Register</a>
                <a class="p-2 hello-username"><span style="color:#FFFFFF">Hi username!</span></a>
                <a class="p-2 login-register" href="logout.php">Logout</a>
        </span>
        </div>
    </div>
  </nav>
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
//                       if ( isset($error) && !empty($error) ) {
//                         echo $error . "<br><br>";
//                       }
//                     ?>
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
