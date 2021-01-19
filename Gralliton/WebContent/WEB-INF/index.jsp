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
		
		
		<div class="d-flex align-items-center justify-content-center" style="height: 500px">
			<c:out escapeXml="false" value="<h1>Bienvenue sur Grailliton, la référence du graillon</h1>"></c:out>
		</div>
		<div class="d-flex align-items-center justify-content-center">
			<c:out escapeXml="false" value="<h1>Nos suggestions</h1>"></c:out>
		</div>
		
		<!-- Affichage suggestions -->
		<c:forEach items="${recipes}" var="recipe">
			<div class="rounded container mt-5 mx-auto position-relative" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
				<a href="detailledrecipe?recipeId=${recipe.id}" class="stretched-link"></a>
				<div class="row ml-1">
					<c:out escapeXml="false" value="<h1>${ recipe.name}</h1>"></c:out>
				</div>
				<div class="row ml-1">
					<c:forEach items="${recipeTypes}" var="rt">
						<c:if test="${rt.id == recipe.type}">
							<div class="col-sm">
								<c:out value="Type :  ${rt.name}"></c:out>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="row ml-1">
					<div class="col-sm">
						<c:forEach items="${recipe.tags}" var="tag"> <!-- tags de la recette -->
							<c:out escapeXml="false" value="${tag.name}&nbsp;&nbsp;&nbsp;"></c:out>
						</c:forEach>
					</div>
				</div>
				<div class="row ml-1">
					<div class="col-sm">
						<c:out value="Temps de cuisine : ${recipe.cookingTime + recipe.preparationTime} min"></c:out>
					</div>
					<div class="col-sm">
						<c:forEach items="${difficulties}" var="diff">
							<c:if test="${diff.id == recipe.difficulty}">
									<c:out value="Difficulté : ${diff.name}"></c:out>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:forEach>
		
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	</body>
</html>