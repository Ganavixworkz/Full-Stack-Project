<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LLR</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
 rel="stylesheet" 
 integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
  crossorigin="anonymous">
</head>
<body>
  <form action="userState" method="get">
 
				    <h1 class="text-center">LLR detail</h1>
		
		<table class="table table-bordered pd-5">
			
				<tr>
					<th>FirstName</th>
					<th>email</th>
					<th>state</th>
					<th>status</th>
					<th>applicationNumber</th>
					</tr>
					 	              										    	
					
				<c:forEach items="${udtos}" var="s">
 	              
   <tr>
		    	               <td>${s.firstName}</td>
		    			    	<td>${s.email}</td>
		    			    	<td>${s.state}</td>
		    			    	<td>${s.status}</td>
		    			    	<td>${s.applicationNumber}</td>
		    			    	<td><font color="blue">${s.status}</font></td>
		    			    	<td><a href=updateUserStatus?id=${s.id}>Approve</a></td>
		    			    	</tr>
    			    	</c:forEach>
     		 	    	</table>
		    
	</div>
		</form>
	
</body>
</html>