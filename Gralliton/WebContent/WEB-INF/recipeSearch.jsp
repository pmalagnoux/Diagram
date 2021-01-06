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

<c:forEach items="${recipes}" var="recipe">
	<div style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
		<c:out escapeXml="false" value="<h1>${ recipe.name}</h1>"></c:out>
		<c:forEach items="${difficulties}" var="diff">
			<c:if test="${diff.id == recipe.difficulty}">
				<c:out value="${ diff.name}"></c:out>
			</c:if>
		</c:forEach>
		<c:forEach items="${recipeTypes}" var="rt">
			<c:if test="${rt.id == recipe.type}">
				<c:out value="${ rt.name}"></c:out>
			</c:if>
		</c:forEach>
		<c:forEach items="${accounts}" var="account">
			<c:if test="${account.id == recipe.account}">
				<c:out value="${ account.login}"></c:out>
			</c:if>
		</c:forEach>
		<c:forEach items="${recipe.tags}" var="tag"> <!-- tags de la recette -->
			<c:out value="${tag.name}"></c:out>
		</c:forEach>
		<c:out value="Temps de cuisine : ${recipe.cookingTime + recipe.preparationTime}"></c:out>
	</div>
</c:forEach>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>