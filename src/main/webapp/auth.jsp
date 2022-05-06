<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta
	content="301645777112-2rlc9gth0f5d4reimjcm9bf0kj7ahec0.apps.googleusercontent.com"
	name="google-signin-client_id">
<title>Login / Register</title>
<link href="https://fonts.googleapis.com" rel="preconnect">
<link crossorigin href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css2?family=Lobster&family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/56a52ca247.js"
	crossorigin="anonymous"></script>
<script async defer src="https://apis.google.com/js/platform.js"></script>
<link href="auth.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" type="text/css">
<script src="https://apis.google.com/js/api:client.js"></script>
<meta name="google-signin-client_id"
	content="813187015477-cophm5q7js8otov2b6i2si9p7dd50mdq.apps.googleusercontent.com">

<script>
	var googleUser = {};
	var startApp = function() {
		gapi
			.load(
					'auth2',
					function() {
						// Retrieve the singleton for the GoogleAuth library and set up the client.
						auth2 = gapi.auth2
								.init({
									client_id : '813187015477-cophm5q7js8otov2b6i2si9p7dd50mdq.apps.googleusercontent.com',
									cookiepolicy : 'single_host_origin',
								// Request scopes in addition to 'profile' and 'email'
								//scope: 'additional_scope'
								});
						attachSignin(document.getElementById('customBtn'));
					});
	};

	function attachSignin(element) {
		console.log(element.id);
		auth2.attachClickHandler(element, {}, function(googleUser) {
			var profile = googleUser.getBasicProfile();
			console.log('Name: ' + googleUser.getBasicProfile().getName());
			console.log('Email: ' + googleUser.getBasicProfile().getEmail());
			window.location.href = "Google?name=" + googleUser.getBasicProfile().getName() + "&email=" + googleUser.getBasicProfile().getEmail();
		}, function(error) {
			console.log(JSON.stringify(error, undefined, 2));
		});
	}
	
	function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	  }

	var check = function() {
		if(document.getElementById('registerPassword').value)
			if (document.getElementById('registerPassword').value === document
					.getElementById('confirmPassword').value) {
				document.getElementById('message').style.color = 'green';
				document.getElementById('message').innerHTML = 'Matching';
				document.getElementById('registerAccount').disabled = false;
			} 
			else {
				document.getElementById('message').style.color = 'red';
				document.getElementById('message').innerHTML = 'Not Matching';
				document.getElementById('registerAccount').disabled = true;
			}
	}
	
	var checkSignInEmailNull = function() {
		var str = document.getElementById('loginEmail').value;
	    var patt = new RegExp("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	    var res = patt.test(str);

		if (document.getElementById('loginEmail').value === null || document.getElementById('loginEmail').value === "") {
			document.getElementById('missingLoginEmail').style.color = 'red';
			document.getElementById('missingLoginEmail').innerHTML = 'Email cannot be empty.';
			document.getElementById('signIn').disabled = true;
		} 
		else if (!res) {
			document.getElementById('missingLoginEmail').style.color = 'red';
			document.getElementById('missingLoginEmail').innerHTML = 'Invalid email format.';
			document.getElementById('signIn').disabled = true;
		}
		else {
			document.getElementById('signIn').disabled = false;
			document.getElementById('missingLoginEmail').innerHTML = '';
		}
	}
	
	var checkSignInPasswordNull = function() {
		if (document.getElementById('loginPassword').value === null || document.getElementById('loginPassword').value === "") {
			document.getElementById('missingLoginPassword').style.color = 'red';
			document.getElementById('missingLoginPassword').innerHTML = 'Password cannot be empty.';
			document.getElementById('signIn').disabled = true;
		} 
		else {
			document.getElementById('signIn').disabled = false;
			document.getElementById('missingLoginPassword').innerHTML = '';
		}
	}
	
	var checkRegisterEmailNull = function() {
		var str = document.getElementById('registerEmail').value;
	    var patt = new RegExp("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	    var res = patt.test(str);
	    
		if (document.getElementById('registerEmail').value === null || document.getElementById('registerEmail').value === "") {
			document.getElementById('missingRegisterEmail').style.color = 'red';
			document.getElementById('missingRegisterEmail').innerHTML = 'Email cannot be empty.';
			document.getElementById('registerAccount').disabled = true;
		} 
		else if (!res) {
			document.getElementById('missingRegisterEmail').style.color = 'red';
			document.getElementById('missingRegisterEmail').innerHTML = 'Invalid email format.';
			document.getElementById('registerAccount').disabled = true;
		}
		else {
			document.getElementById('registerAccount').disabled = false;
			document.getElementById('missingRegisterEmail').innerHTML = '';
		}
	}
	
	var checkRegisterNameNull = function() {
		var str = document.getElementById('registerName').value;
	    var patt = new RegExp("^[ A-Za-z]+$");
	    var res = patt.test(str);
		
		if (document.getElementById('registerName').value === null || document.getElementById('registerName').value === "") {
			document.getElementById('missingRegisterName').style.color = 'red';
			document.getElementById('missingRegisterName').innerHTML = 'Name cannot be empty.';
			document.getElementById('registerAccount').disabled = true;
		} 
		else if (!res) {
			document.getElementById('missingRegisterName').style.color = 'red';
			document.getElementById('missingRegisterName').innerHTML = 'Invalid name format.';
			document.getElementById('registerAccount').disabled = true;
		}
		else {
			document.getElementById('registerAccount').disabled = false;
			document.getElementById('missingRegisterName').innerHTML = '';
		}
	}
	
	var checkRegisterPasswordNull = function() {
		if (document.getElementById('registerPassword').value === null || document.getElementById('registerPassword').value === "") {
			document.getElementById('missingRegisterPassword').style.color = 'red';
			document.getElementById('missingRegisterPassword').innerHTML = 'Password cannot be empty.';
			document.getElementById('registerAccount').disabled = true;
		} 
		else {
			document.getElementById('registerAccount').disabled = false;
			document.getElementById('missingRegisterPassword').innerHTML = '';
		}
	}
	
	var checkRegisterUsernameNull = function() {
		if (document.getElementById('registerUsername').value === null || document.getElementById('registerUsername').value === "") {
			document.getElementById('missingRegisterUsername').style.color = 'red';
			document.getElementById('missingRegisterUsername').innerHTML = 'Username cannot be empty.';
			document.getElementById('registerAccount').disabled = true;
		} 
		else {
			document.getElementById('registerAccount').disabled = false;
			document.getElementById('missingRegisterUsername').innerHTML = '';
		}
	}
	
	var loginCheck = function() {
		var email_ = document.getElementById('loginEmail').value;
		var password_ = document.getElementById('loginPassword').value;
		if (email_ === null || email_ === "" || password_ === null || password_ === "") {
			alert("Please complete all fields.");
			return false;
		} 
	}
	
	var registerCheck = function() {
		var name_ = document.getElementById('registerName').value;
		var confirm_ = document.getElementById('confirmPassword').value;
		var email_ = document.getElementById('registerEmail').value;
		var username = document.getElementById('registerUsername').value;
		var password_ = document.getElementById('registerPassword').value;
		if (name_ === null || name_ === "" || confirm_ === null || confirm_ === "" || 
				email_ === null || email_ === "" || password_ === null || password_ === "") {
			alert("Please complete all fields.");
			return false;
		} 
	}
</script>

</head>

<body>
	<!-- TODO -->
	<%
	Cookie[] cookies = request.getCookies(); 
	String name_ = "";
	if(cookies != null) {
		for (Cookie aCookie : cookies) {
			if((aCookie.getName( )).equals("name")){
				name_ = aCookie.getValue();
			}
		}
	}
	name_ = name_.replaceAll("_", " ");
	%>

	<div class="header">
		<% if(request.getAttribute("error") != null) {%>
		<div id="error">
			Invalid email, username, or password. Or, bad Google login. Please try again. 
		</div>
		<%}%>
		<% if(request.getAttribute("userRegistered") != null) {%>
		<div id="error">
			User already registered. 
		</div>
		<%}%>
	</div>
	
	<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">lost-n-found</a>
				<%if (!name_.equals("")){%>
				<a>Hi, <%=name_%></a>
				<%}%>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
						</li>
						<li class="nav-item">
						<%if (name_.equals("")){%>
						<a class="nav-link" href="auth.jsp">Login/Register</a>
						<%}
						else if (!name_.equals("")){%>
							<a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
						<%}%>
						</li>
					</ul>
				</div>
			</div>
		</nav>

	<div class="fields">
		<form action="${pageContext.request.contextPath}/Login" method="get" id="login" onsubmit="return loginCheck()">
			<h2>Login</h2>
			<br> <label for="email">Email</label> <br>
			<input type="text" class="entry" id="loginEmail" name="email" onkeyup="checkSignInEmailNull()" style="width: 400px">
			<br> <span id='missingLoginEmail'></span> 
			<br> <label for="password">Password</label> <br>
			<input type="password" class="entry" id="loginPassword" name="password" onkeyup="checkSignInPasswordNull()" style="width: 400px">
			<br> <span id='missingLoginPassword'></span> <br>

			<p>
				<button type="submit" id="signIn" disabled="disabled">
					<i class="fa-solid fa-right-to-bracket"></i> Sign In
				</button>
<!-- 				</br>
				</br>
				<button type="button" id="customBtn">
					<i class="fa-brands fa-google"></i> Sign in with Google
				</button>
				<script>
					startApp();
				</script> -->
			</p>

		</form>


		<form action="Register" method="get" id="register" onsubmit="return registerCheck()">
			<h2>Register</h2>
			<br> <label for="email">Email</label> <br>
			<input type="email" class="entry" id="registerEmail" name="email" onkeyup="checkRegisterEmailNull()" style="width: 400px">
			<br> <span id='missingRegisterEmail'></span>
			<br> <label for="name">Name</label> <br>
			<input type="text" class="entry" id="registerName" name="name" onkeyup="checkRegisterNameNull()" style="width: 400px">
			<br> <span id='missingRegisterName'></span>
			<br> <label for="username">Username</label> <br>
			<input type="text" class="entry" id="registerUsername" name="username" onkeyup="checkRegisterUsernameNull()" style="width: 400px">
			<br> <span id='missingRegisterUsername'></span>
			<br> <label for="password">Password</label> <br>
			<input type="password" class="entry" id="registerPassword" name="password" onkeyup="checkRegisterPasswordNull(); check()" style="width: 400px" /> <br>
			<span id='missingRegisterPassword'></span>
			<br> <label for="confirmPassword">Confirm Password</label> <br>
			<input type="password" class="entry" id="confirmPassword" name="confirmPassword" onkeyup="check()" style="width: 400px" /> <br>
			<span id='message'></span>
			<br> <label class="checkBox">
			<input
				type="checkbox"
				onchange="this.setCustomValidity(validity.valueMissing ? 'Please indicate that you accept the Terms and Conditions' : '');"
				required name="terms"> I have read and agree to all terms
				and conditions of lost-n-found.</label><br><br>
			<p>
				<button type="submit" id="registerAccount" disabled="disabled">
					<i class="fa-solid fa-user-plus"></i> Create Account
				</button>
			</p>

		</form>
	</div>
</body>
</html>