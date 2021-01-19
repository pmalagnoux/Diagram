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
		
		
		<c:if test="${!(empty recipe) }">
			<div class="rounded container mt-5 mx-auto" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
				<div class="row ml-1">
					<!-- Titre recette -->
					<div class="col-sm">
						<c:out escapeXml="false" value="<h1>${recipe.name}</h1>"></c:out>
					</div>
					<div class="col-sm mt-1">
						<!-- Ajout aux favoris -->
						<c:if test="${!(empty sessionScope.userLogin) && !isFavorite}">
							<form action = "" method = "post">
								<input type="hidden" class="form-control" id="recipeIdAdd" name="recipeIdAdd" value = "${recipe.id}">	
								<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7" onclick="addNotification()"> Add </button>
							</form>
						</c:if>
						<!-- Suppression des favoris -->
						<c:if test="${!(empty sessionScope.userLogin) && isFavorite}"> 
							<form action = "" method = "post">
								<input type="hidden" class="form-control" id="recipeIdDel" name="recipeIdDel" value = "${recipe.id}">	
								<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7" onclick="delNotification()"> Del </button>
							</form>
							
						</c:if>
					</div>
				</div>
				
				<!-- Type -->
				<div class="row ml-1">
					<div class="col-sm">
						<c:out value="Type : ${type.name}"></c:out>
					</div>
				</div>
				<!-- Tags -->
				<div class="row ml-1">
						<div class="col-sm">
							<c:forEach items="${tags}" var="tag"> 
								<c:out escapeXml="false" value="${tag.name}&nbsp;&nbsp;&nbsp;"></c:out>
							</c:forEach>
						</div>
				</div>
				
				<div class="row ml-1">
					<!-- Temps de préparation -->
					<div class="col-sm">
						<c:out value="Temps de préparation : ${recipe.preparationTime} min"></c:out>
					</div>
					<!-- Temps de cuisson -->
					<div class="col-sm">
						<c:out value="Temps de cuisson : ${recipe.cookingTime} min"></c:out>
					</div>
					<!-- Difficulté -->
					<div class="col-sm">
						<c:out value="Difficulté : ${difficulty.name}"></c:out>
					</div>
				</div>		
				<!-- Auteur -->
				<div class="row ml-1">
					<div class="col-sm">
						<c:out value="Par ${account.login}"></c:out>
					</div>
				</div>			
			</div>
			
			<div class="container">
				<div class="row">
				 	<div class="col-sm-4">
						<!-- Ingrédients -->
						<div class="row">
						 	<div class="rounded container mt-3" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
						 		<c:out escapeXml="false" value="<h2>Ingredients</h2>"></c:out>
								<c:forEach items="${ingredients}" var="ingredient">
									<div class="ml-1 row">
										<c:out value="${ingredient.quantity} unit ${ingredient.name}"></c:out>
									</div>
								</c:forEach>
						 	</div>
						 </div>	
						 <!-- Ustensiles -->
						 <div class="row">
				 		 	<div class="rounded container mt-3" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
								<c:out escapeXml="false" value="<h2>Ustensiles</h2>"></c:out>
						 		<c:forEach items="${ustensils}" var="ustensil">
					 			<div class="ml-1 row">
										<c:out value="${ustensil.name}"></c:out>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					
					<!-- Étapes -->
					<div class="col-sm-8">
						<c:forEach items="${steps}" var="step">
							<div class="rounded container mt-3" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
						 		<c:out escapeXml="false" value="<h2>Etape ${step.id} :</h2>"></c:out>
						 		<c:out value="${step.content}"></c:out><br>
							</div>			
					 	</c:forEach>
					</div>
				</div>
			</div>
		</c:if>
		
		<!-- Si aucune recette n'est sélectionnée -->
		<c:if test="${empty recipe}">
			<div class="d-flex align-items-center justify-content-center" style="height: 500px">
				<c:out escapeXml="false" value="<h1>Aucune recette sélectionnée</h1>"></c:out>
			</div>
		</c:if>
		
		<script type="text/javascript">
			function addNotification() {
				alert("Recette ajoutée à vos favoris !");
			}
			function delNotification() {
				alert("Recette supprimée des favoris !");
			}
		</script>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	</body>
</html>