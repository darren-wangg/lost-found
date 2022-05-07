<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="general.css" />
  </head>
  <body>
    <nav
      class="navbar navbar-expand-md navbar-expand-lg navbar-light"
      style="background-color: #4267b2"
    >
      <div class="container-fluid">
        <a class="navbar-brand" href="home.jsp"> 🥀 </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarText"
          aria-controls="navbarText"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="home.jsp"
                >Home</a
              >
            </li>
          </ul>
          <span class="navbar-text">
            <a class="login-register" href="login.jsp">Login/Register</a>
            <a class="p-2 hello-username" style="color: #ffffff"
              >Hi ${username}!</a
            >
            <a class="p-2 login-register" href="logout.jsp">Logout</a>
          </span>
        </div>
      </div>
    </nav>
    <div class="parent-container">
      <div id="header-container">
        <p id="motto">Lost connections motto here...</p>
        <h1 id="header-words">
          start connecting
          <div class="face3-home"><img src="images/face3.png" /></div>
        </h1>
      </div>
    </div>
    <div class="circles-div">
      <img class="circles" src="images/circles.png" alt="Multiple circles" />
      <i class="fa-solid fa-circle-plus add-button"></i>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/1374c208f0.js"
      crossorigin="anonymous"
    ></script>

    <script src="main.js"></script>
  </body>
</html>
