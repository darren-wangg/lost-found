<?php
    session_start(); 
    require 'config/config.php';

    if( !isset($_SESSION["logged_in"]) || !$_SESSION["logged_in"] )  {
        header("Location: login.php");
    }
    else {
        
        $statement = $mysqli->prepare("INSERT INTO workouts(name, exercise, muscles, sets, reps) VALUES(?,?,?,?,?)");
        $statement->bind_param("sssii", $_POST["name"], $_POST["exercise"], $_POST["muscles"], $_POST["sets"], $_POST["reps"]);
        
        $executed = $statement->execute();
        if(!$executed) {
            echo $mysqli->error;
        }
        $statement->close();

        $mysqli->close();
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add your workout!</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="general.css">
</head>
<body>
<?php include 'nav.php'; ?>
    <div class="container add-container">
        <div class="row h-100 inputs-div align-items-center">
            <div class="column my-auto">
                <img id="face1-login" src="images/face1.png"/>
                <form method="GET" action="">
                    <label for="name">Name this workout!</label><br/>
                    <input type="text" id="name" name="name" placeholder="Name (i.e. Leg Day, Arm Day)"><br><br>
                    <input id="next-btn" type="submit" value="Next">
                </form>
            </div>
        </div>
    </div>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>