<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="general.css">
    <style>
    	.error{
    		color: red;
			font-style: italic;
			margin-left: 10px;
			visibility: hidden;
    	}
    </style>
</head>
<body>
    <nav class="navbar navbar-custom navbar-expand-md navbar-expand-lg navbar-light" style="background-color: #B24256" >
        <div class="container-fluid">
            <a class="navbar-brand navbar-brand-custom" href="home.jsp">
                <img src="images/rose.png" width="30" height="30" class="d-inline-block align-top" alt="">
                <span style="color: #efc9d2">Lost n' Found Connections</span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                <a class="nav-link nav-link-custom" aria-current="page" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                <a class="nav-link nav-link-custom" href="createPost.jsp">+ Create Post</a>
                </li>
            </ul>
            <span class="navbar-text">
                    <a class="login-register nav-link-custom" href="login.jsp">Login/Register</a>
                    <a class="p-2 hello-username nav-link-custom"><span style="color:#efc9d2">Hi username!</span></a>
                    <a class="p-2 login-register nav-link-custom" href="logout.jsp">Logout</a>
            </span>
            </div>
        </div>
      </nav>
    <div class="container post-container">
        <div class="row h-100 inputs-div align-items-center">
            <div class="column my-auto">
                <img id="face1-login" src="images/rose.png"/>
                <form id="form" method="POST" action="createPost.jsp">
                	<label for="post"></label>
                	<textarea id="post-text" name = "post-text" rows="10" cols = "70" placeholder="Write post here. . ."></textarea>
                	<br><br>
                	<input type="submit" value="Post">
                	<div class="error">Error message</div>
                    
                    <div class="font-italic text-danger">
                    <!-- Show errors here. -->
                    </div>
                </form>
                <p class="login-prompt"><a href="login.php">Don't have an account?</a></p>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    	document.querySelector("#form").onsubmit = function(){
    		event.preventDefault();
    		
    		let postText = document.querySelector('#post-text').value().trim();
    		if(postText.length <= 0){
    			/* console.log("Post must include text!"); */
				document.querySelector("#post-text").nextElementSibling.innerHTML = "Post must include text";
				document.querySelector("#post-text").nextElementSibling.style.visibility = "visible";
			}
			else{
				document.querySelector("#post-text").nextElementSibling.style.visibility = "hidden";
    		}
    	}
    
    </script>
</body>
</html>