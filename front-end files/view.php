<?php
  session_start(); 
  require 'config/config.php';

  // if user not logged in, redirect to login page
  if( !isset($_SESSION["logged_in"]) || !$_SESSION["logged_in"] )  {
    header("Location: login.php");
  }
  else{
    
  }
?>
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
  <?php include 'nav.php'; ?>
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