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

	<div class="rounded container mt-5 mx-auto" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
		<form action="" method="post">
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
			<div class="row ml-1">
				<c:forEach items="${accounts}" var="account">
					<c:if test="${account.id == recipe.account}">
						<div class="col-sm">
							<c:out value="Par ${account.login}"></c:out>
						</div>
					</c:if>
				</c:forEach>
			</div>
			
			<!--   Bouton D'ajout au Favoris
			<c:if test="${!(empty sessionScope.userLogin) }">
				<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7"> + </button>
				<input type="hidden" class="form-control" id="recipeId" name="recipeId" value = "${recipe.id}">
			</c:if>
			-->
		</form>
	</div>
</c:forEach>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>