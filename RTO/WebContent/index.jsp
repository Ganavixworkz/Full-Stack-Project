<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
 rel="stylesheet" 
 integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
  crossorigin="anonymous">
  <div style="text-align:center;">
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpUVMsDr8Xeql-D3ZuZ2wiKNbobvcge6-aGC7zh8Fc6Q&s"  class="me-2" height="70vh" width="70vh">
  <font color="RED" size=6><b>Transport Department</b></font>
  <h6> Government Of Karnataka</h6>
  </head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary navbar-light fw-bold d-flex justify-content-between align-items-center" data-bs-theme="dark">
<img src="https://t3.ftcdn.net/jpg/05/18/89/00/360_F_518890058_o7xox3YLS0e27k5kHWUTQXaw1yLAvM7p.jpg" alt="Bootstrap" width="60" height="45">

<div class="container-fluid">

<svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
  <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
</svg>

<!--     <a class="navbar-brand" href="index.jsp">Home</a>
 -->  
   <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="index.jsp">Home</a></li>
			</ul>
			
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="admin.jsp">Admin</a></li>
				</ul>
				
			<ul  class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="userapplication.jsp">User-Application</a></li>
			</ul>
			
			<ul  class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="userlogin.jsp">ApplicationStatus</a></li>
			</ul>
			
			<ul  class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="forgotpassword.jsp">ForgotPassword</a></li>
			</ul>
			
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
        
        </li>
        </ul>
        
        
      <form>
      <a class="btn btn-dark" href="signup.jsp" role="button">Sign Up</a>
            <a class="btn btn-dark" href="signin.jsp" role="button">Sign In</a>
                  <a class="btn btn-dark" href="findall.jsp" role="button">FindAll</a>
      
</form>
        </div>
        </div>
        </nav>
        
       <img src="https://kannada.oneindia.com/img/1200x60x675/2022/12/rto-1670832402.jpg" width="1423vh" height="418vh">
       <%@include file="footer.jsp" %>
       </body>
</html>