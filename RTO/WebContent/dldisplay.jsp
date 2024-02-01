<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DL Display</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

.card {
  box-shadow: 5px 5px 5px 5px rgba(2,2,2,2);
  width: 30%;
  margin:205px -350px 50px 50px ;
  display: flex;
  justify-content: flex-end;
  align-items: center;
   position: fixed;
  top: 10%;
  right: 10px;
  transform: translateX(-190%);
background-color:lightblue;
}

.container {
  padding: 2px 75px;
  margin:2px;
 
}
</style>
</head>
<body>



<div class="card">
<img src="download?fileName=${UserImage}" height="150" width="110" style="border-radius:3%"> 

  <div class="container">
  <h3>Name : ${dto.firstName} ${dto.middleName} ${dto.lastName} </h3> 
    <h3>Dob : ${dto.dob}</h3>
    <h3>DL No : ${dto.applicationNumber }</h3>
    <h3>Address : ${dto.permanentAddress }</h3>
  </div>
</div>

</body>
</html>

