<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Download</title>
</head>
<body>
<form action="display">


<div class="mb-3">
				<label class="form-label">Application Number</label> <input type="text"
					 name="applicationNumber" value="${appl}" class="form-control" required="required" >
			</div>
			
<input type="submit" type="button" class="btn btn-success" value="Download">
</form>

</body>
</html>