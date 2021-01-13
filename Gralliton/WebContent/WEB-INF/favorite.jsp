<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Gralliton</title>
</head>
<body>
<body style= "background-color:#484d50; color:white">
<%@ include file="menu.jsp"%>
<c:forEach items="${favoriteRecipes}" var="favorite">
	<div style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
		<c:out escapeXml="false" value="<h1>${ favorite.name}</h1>"></c:out>
		<c:forEach items="${difficulties}" var="diff">
			<c:if test="${diff.id == favorite.difficulty}">
				<c:out value="${ diff.name}"></c:out>
			</c:if>
		</c:forEach>
		<c:forEach items="${recipeTypes}" var="rt">
			<c:if test="${rt.id == favorite.type}">
				<c:out value="${ rt.name}"></c:out>
			</c:if>
		</c:forEach>
		<c:forEach items="${accounts}" var="account">
			<c:if test="${account.id == favorite.account}">
				<c:out value="${ account.login}"></c:out>
			</c:if>
		</c:forEach>
		<c:out value="Temps de cuisine : ${recipe.cookingTime + recipe.preparationTime}"></c:out>
	</div>
</c:forEach>
</body>
</html>