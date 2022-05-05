<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calendar</title>
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
            <a class="nav-link active" href="view.php">View</a>
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
  <div class="search-div">
    <!-- created new div "face1-view1" to force display of image to display: inline -->
    <div id="face1-view1">
      <img id="face1-view" src="images/face1.png"/>
    </div>
    <form id="search-form" method="GET" action="">
      <label for="workouts-search"></label>
      <input type="text" id="workouts-search" name="workouts-search" placeholder="Search your past workouts"><br><br>
      <!-- How to make this not a button, so you can just press enter -->
      <!-- <input id="search-submit-btn" type="submit" value="Login">  -->
    </form>
  </div>
  <div class="container">
    <div class="row">
      <!-- <div class="column"> -->
      <div class="workout">
        <p class="title">Workout #1</p>
        <p class="extra-info">
          . <br/>
          . <br/>
          . <br/>
          . <br/>
        </p>
      </div>
      <div class="workout">
        <p class="title">Workout #2</p>
        <p class="extra-info">
          . <br/>
          . <br/>
          . <br/>
          . <br/>
        </p>
      </div>
      <!-- </div> -->
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  <script src="https://kit.fontawesome.com/1374c208f0.js" crossorigin="anonymous"></script>

  <script src="main.js"></script>
</body>
</html>