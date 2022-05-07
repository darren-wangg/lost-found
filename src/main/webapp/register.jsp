<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lost n' Found</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="general.css">
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
                    <a class="p-2 login-register nav-link-custom" href="Logout">Logout</a>
            </span>
            </div>
        </div>
      </nav>
    <div class="container login-container">
        <div class="row h-100 inputs-div align-items-center">
            <div class="column my-auto">
                <img src="images/rose.png" width="40" height="40" class="d-inline-block align-top" alt=""> <br>
                <form method="POST" action="Register">
                    <label for="email-register"></label>
                    <input type="text" id="email-register" name="email-register" placeholder="Email">
                    <p id="password-error" class="email-error text-danger"></p>
                    <label for="username-register"></label>
                    <input type="text" id="username-register" name="username-register" placeholder="Username">
                    <p id="username-error" class="username-error text-danger"></p>
                    <label for="password-register"></label>
                    <input type="password" id="password-register" name="password-register" placeholder="Password">
                    <p id="password-error" class="password-error text-danger"></p>
                    <p id="password-error" class="invalid-feedback">Password is required.</p>
                    <div class="font-italic text-danger">
                    <!-- Show errors here. -->
				   			<!-- set er as whatever getAttribute returns from setAttribute("error", error)-->
				   			<!-- JSP tags connect page to Java backend aka servlet.java -->
				   			<% String er = (String) request.getAttribute("error");
							/* prints out the correct error from the servlet */
							if (er != null) out.println(er);%>
                    </div>
                    <input id="register-submit-btn" type="submit" value="Register">
                </form>
                <p class="login-prompt"><a href="login.jsp">Already have an account?</a></p>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script>
		document.querySelector('form').onsubmit = function(){
			
			function hasWhiteSpace(s) {
				  return s.indexOf(' ') >= 0;
			}
			function ValidateEmail(inputText)
			{
				var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
				var patt = new RegExp("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
			    var res = patt.test(inputText);
				/* @usc.edu is 8 characters */
				if(res && inputText.substring(inputText.length - 8, inputText.length) == "usc.edu")
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			if ( document.querySelector('#email-register').value.trim().length == 0 ) {
				document.querySelector('.email-error').innerHTML="Email is required";
			} 
			else if (ValidateEmail(document.querySelector('#email-register').value)) {
				console.log("HI");
			}
			else {
				document.querySelector('.email-error').innerHTML="";
			}

			if ( document.querySelector('#username-register').value.trim().length == 0 ) {
				document.querySelector('.username-error').innerHTML="Username is required";
			} 
			else if(hasWhiteSpace(document.querySelector('#username-register').value)){
				document.querySelector('.username-error').innerHTML="Username cannot have spaces";
			}
			else {
				document.querySelector('.username-error').innerHTML="";
			}
			
			if ( document.querySelector('#password-register').value.trim().length == 0 ) {
				document.querySelector('.password-error').innerHTML="Password is required";
			} else {
				document.querySelector('.password-error').innerHTML="";
			}
	
		}
		
	</script>
</body>
</html>