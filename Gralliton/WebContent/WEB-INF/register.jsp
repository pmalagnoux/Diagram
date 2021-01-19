<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.css">
		<script src="jquery-3.5.1.min.js"></script>
		<title>Grailliton</title>
		<link rel = "icon" href ="images/cat.png" type = "image/x-icon"> 
	</head>
	<body style= "background-color:#484d50; color:white">
		<%@ include file="menu.jsp"%>
		
		<div class="d-flex align-items-center justify-content-center" style="height: 600px">
			<form action="" method="post">
				<!-- Login -->
				<div class="form-group">
					<label>Login</label>
					<input type="text" class="form-control" placeholder="Login" id="login" name="login">
				</div>
				<!-- Adresse mail -->
				<div class="form-group">
					<label>Adresse mail</label>
					<input type="text" class="form-control" placeholder="Adresse mail" id="email" name="email">
				</div>
				<!-- Mot de passe -->	
				<div class="form-group">
					<label>Mot de passe</label>
					<input type="password" class="form-control" placeholder="Mot de passe"  id="password" name="password">
				</div>
				<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7">M'inscrire</button>
			</form>
		</div>
		<!-- Affichage des erreurs -->
		<c:if test="${emailNotAvailable}">
			<script type="text/javascript">
				alert("Adresse mail d�j� utilis�e !");
			</script>
		</c:if>
		<c:if test="${loginNotAvailable}">
			<script type="text/javascript">
				alert("Login d�j� utilis� !");
			</script>
		</c:if>
		<c:if test="${emailNotValid}">
			<script type="text/javascript">
				alert("Adresse mail non valide !");
			</script>
		</c:if>
	</body>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</html>