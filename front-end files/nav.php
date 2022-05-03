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
            <a class="nav-link <?php if($_SERVER['SCRIPT_NAME']=="/final-proj/home.php") { ?>  active <?php } ?>" aria-current="page" href="home.php">Home</a>
            </li>
            <li class="nav-item">
            <a class="nav-link <?php if($_SERVER['SCRIPT_NAME']=="/final-proj/view.php") { ?>  active <?php } ?>" href="view.php">View</a>
            </li>
            <li class="nav-item">
            <a class="nav-link <?php if($_SERVER['SCRIPT_NAME']=="/final-proj/post.php") { ?>  active <?php } ?>" href="post.php">+ Add Workout</a>
            </li>
        </ul>
        <span class="navbar-text">
            <?php if(!isset($_SESSION["logged_in"]) || !$_SESSION["logged_in"]) :?>
                <a class="login-register" href="login.php">Login/Register</a>
            <?php else :?>
                <a class="p-2 hello-username"><span style="color:#FFFFFF">Hi <?php echo $_SESSION["username"]; ?>!</span></a>
                <a class="p-2 login-register" href="logout.php">Logout</a>
            <?php endif; ?>

        </span>
        </div>
    </div>
</nav>