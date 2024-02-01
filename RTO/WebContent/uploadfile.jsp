<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload File</title>
</head>
<body>
	<p>${message}</p>
	<form action="upload" method="post" enctype="multipart/form-data">

<div class="mb-3">
				<label class="form-label">Application Number</label> <input type="text"
					 name="applicationNumber" value="${appl}" class="form-control" required="required" >
			</div>
			

		<input type="file" name="file" /> <br>
		<input type="submit" value="Upload File">


	</form>


</body>
</html>