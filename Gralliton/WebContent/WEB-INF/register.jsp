<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="jquery-3.5.1.min.js"></script>
<title>Gralliton</title>

</head>
<body style= "background-color:#484d50; color:white">
<%@ include file="menu.jsp"%>


<body>

	<c:out escapeXml="false" value="<h1>Inscription</h1>"></c:out>
	<form action="" method="post">
		<input type="text" class="form-control" placeholder="Login" id="login" name="login">
		<input type="text" class="form-control" placeholder="Email" id="email" name="email">
		<input type="text" class="form-control" placeholder="Mot de passe"  id="password" name="password">
		<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7">M'inscrire</button>
	</form>

</body>
</html>