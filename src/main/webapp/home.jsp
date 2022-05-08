<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Dao.*" %>
<%@ page import="Util.*" %>
<%@ page import = "java.util.ArrayList" %>
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
  	<%
    	Cookie[] cookies = request.getCookies(); 
    	String username_ = "";
    	if(cookies != null) {
    		for (Cookie aCookie : cookies) {
    			if((aCookie.getName( )).equals("username")){
    				username_ = aCookie.getValue();
    			}
    		}
    	}
	%>
  
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
            		<%if (username_.equals("")){%>
                    <a class="login-register nav-link-custom" href="login.jsp">Login/Register</a>
                    <%}
					else if (!username_.equals("")){%>
                    <a class="p-2 hello-username nav-link-custom"><span style="color:#efc9d2">Hi <%=username_%>!</span></a>
                    <a class="p-2 login-register nav-link-custom" href="Logout">Logout</a>
                    <%}%>
            </span>
            </div>
        </div>
      </nav>
    <div class="parent-container">
      <div id="header-container">
        <p id="motto">don't miss the luv of ur lyfe.</p>
        <h1 id="header-words">
          start connecting
          <div class="face3-home"><img src="images/rose.png"/></div>
        </h1>
      </div>
    </div>
    <div class="circles-div">
      <img class="circles" src="images/hearts.png" alt="Multiple circles" />
      <img
        class="add-button"
        src="images/add-btn.png"
      />
    </div>
     <br><br><br><br><br>
    
    <%	
    	ArrayList<Post> posts = PostDao.getPosts();
    	for(Post p: posts){
    		String href = "Like?id=" + p.getId();
    	%>
<div class="container">
	<div class="row">
	    <div class="col-md-8">
	        <div class="media g-mb-30 media-comment">
                <img src="images/rose.png" width="40" height="40" class="d-inline-block align-top" alt="" id ="Post<%=p.getId()%>"> <br>
	            <div class="media-body u-shadow-v18 g-bg-secondary g-pa-30">
	              <div class="g-mb-15">
	                <h5 class="h5 g-color-gray-dark-v1 mb-0">@<%=UserDao.getUsername(p.getProfileEmail())%></h5>
	                <span class="g-color-gray-dark-v4 g-font-size-12"><%= p.getCreatedDatetime()%></span>
	              </div>
	        
	              <p><%= p.getWrittenText()%></p>
	        
	              <ul class="list-inline d-sm-flex my-0">
	                <li class="list-inline-item g-mr-20">
	                  <a class="u-link-v5 g-color-gray-dark-v4 g-color-primary--hover" href=<%=href%>>
	                  <%if (username_.equals("")){%>
	                  <a onclick="return confirm('You must be logged in');" href="login.jsp" style="color: grey">
              			<i class="fa fa-thumbs-up g-pos-rel g-top-1 g-mr-3"></i>
            		  </a>
            		  <%}
            		  else {%>
            		  <i class="fa fa-thumbs-up g-pos-rel g-top-1 g-mr-3" style="color: grey"></i>
            		  <%} %>
            		  <%=LikeDao.getLikes(p)%>
	                  </a>
	                </li>
	              
	              </ul>
	            </div>
	        </div>
	    </div>
	</div>
</div>
		<%}%>
		

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
