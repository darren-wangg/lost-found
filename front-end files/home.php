<?php
session_start(); 
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="general.css">
</head>
<body>
  <?php include 'nav.php'; ?>
  <div class="parent-container">
      <div id="header-container">
          <p id="motto">Track your workouts. Build a habit. Increase your <strong>stamina</strong> to tackle life.</p>
          <h1 id="header-words">Start tracking<div class="face3-home"><img src="images/face3.png"/></div></h1>
          <!-- <span style="color:#D5ECE0"> :-)</span> -->
      </div>
  </div>
  <div class="circles-div">
          <img class="circles" src="images/circles.png" alt="Multiple circles"/>
          <img class="add-button" src="images/add-button.png" alt="Add workout button"/>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  <script src="https://kit.fontawesome.com/1374c208f0.js" crossorigin="anonymous"></script>
  
  <script src="main.js"></script>
</body>
</html>