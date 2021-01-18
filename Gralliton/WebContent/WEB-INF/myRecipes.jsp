<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Gralliton</title>
</head>
<body style= "background-color:#484d50; color:white">
<%@ include file="menu.jsp"%>
<c:choose>
	<c:when test="${!(empty sessionScope.userLogin)}">
		<div class="ml-5 d-flex align-items-center justify-content-center" style="height: 200px">
			<c:out escapeXml="false" value="<h1>Mes Recettes</h1>"></c:out>
		</div>
		<c:forEach items="${myRecipes}" var="myRecipe">
			<div class="rounded container mb-5 mx-auto position-relative" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
				<a href="detailledrecipe?recipeId=${myRecipe.id}" class="stretched-link"></a>
				<div class="row ml-1">
					<c:out escapeXml="false" value="<h1>${myRecipe.name}</h1>"></c:out>
				</div>
				<div class="row ml-1">
					<c:forEach items="${difficulties}" var="diff">
						<c:if test="${diff.id == favoriteRecipe.difficulty}">
							<c:out value="Difficulté : ${diff.name}"></c:out>
						</c:if>
					</c:forEach>
				</div>
				<div class="row ml-1">
					<c:forEach items="${recipeTypes}" var="rt">
						<c:if test="${rt.id == favoriteRecipe.type}">
							<c:out value="Type : ${rt.name}"></c:out>
						</c:if>
					</c:forEach>
				</div>
				<div class="row ml-1">
					<c:out value="Temps de cuisine : ${myRecipe.cookingTime + myRecipe.preparationTime} min"></c:out>
				</div>
			</div>
		</c:forEach>
	</c:when>
	
	<c:otherwise>
		<div class="d-flex align-items-center justify-content-center" style="height: 200px">
				<c:out escapeXml="false" value="<h1>Accès refusé ! Vous devez être connecté !</h1>"></c:out>
		</div>
	</c:otherwise>	
</c:choose>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>