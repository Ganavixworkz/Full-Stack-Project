<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
<form action="save" method="post">

<h1 style="text-align: center;">Rto Info</h1>
		<table class="table table-bordered"  align="center">
			<tr>

				
				<th>FirstName</th>
				<th>LastName</th>
				<th>Password</th>
				<th>ConfirmPassword</th>
				<th>Dob</th>
				<th>PhoneNumber</th>
				<th>Email</th>
				</tr>
			
			<tr>
		    	
		    <td>${Dto.firstName}</td>	
		    <td>${Dto.lastName}</td>	
		    <td>${Dto.password}</td>	
		    <td>${Dto.confirmPassword}</td>	
		    <td>${Dto.dob}</td>	
		    <td>${Dto.phoneNumber}</td>	
		    <td>${Dto.email}</td>
		    </tr>
		    
		</table>
		<div class="text-center">
		<a href="signup.jsp"> Back</a>
		</div>
	</form>	
</body>
</html>