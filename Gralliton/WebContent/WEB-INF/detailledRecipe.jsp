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

<!-- Titre + petites infos-->
<c:if test="${!(empty recipe) }">
	<div class="rounded container mt-5 mx-auto" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
		<div class="row ml-1">
			<div class="col-sm">
				<c:out escapeXml="false" value="<h1>${recipe.name}</h1>"></c:out> <!-- BOOSTRAPPER -->
			</div>
			<div class="col-sm">
				<c:if test="${!(empty sessionScope.userLogin) }">
					<form action = "" method = "post">
						<input type="hidden" class="form-control" id="recipeId" name="recipeId" value = "${recipe.id}">	
						<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7" onclick="addNotification()"> + </button>
					</form>
					
				</c:if>
			</div>
		</div>
		
		<div class="row ml-1">
			<c:out value="Type : ${type.name}"></c:out>
		</div>
		<div class="row ml-1">
				<div class="col-sm">
					<c:forEach items="${tags}" var="tag"> <!-- tags de la recette -->
						<c:out escapeXml="false" value="${tag.name}&nbsp;&nbsp;&nbsp;"></c:out>
					</c:forEach>
				</div>
		</div>
		<div class="row ml-1">
			<div class="col-sm">
				<c:out value="Temps de préparation : ${recipe.preparationTime} min"></c:out>
			</div>
			<div class="col-sm">
				<c:out value="Temps de cuisson : ${recipe.cookingTime} min"></c:out>
			</div>
			<div class="col-sm">
				<c:out value="Difficulté : ${difficulty.name}"></c:out>
			</div>
		</div>		
		<div class="row ml-1">
			<div class="col-sm">
				<c:out value="Par ${account.login}"></c:out>
			</div>
		</div>			
	</div>
	
	<div class="container">
		<div class="row justify-content-md-left">
		 	<div class="col col-md-auto">
			<!-- Ingredients -->
			 	<table class="table rounded table-sm table-dark" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
			 		<thead>
				    	<tr>
					      <th scope="col"><h2>Ingredients</h2></th>
					    </tr>
				  	</thead>
			 		<tbody>
			 			<c:forEach items="${ingredients}" var="ingredient">
							<tr>
								<th>
									<c:out value="  ${ingredient.quantity} unit ${ingredient.name}"></c:out>
								</th>
							</tr>
						</c:forEach>
			 		</tbody>
			 	</table>
			 	<!-- Ustensiles -->
	 		 	<table class="table rounded table-sm table-dark" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
			 		<thead>
				    	<tr>
					      <th scope="col"><h2>Ustensiles</h2></th>
					    </tr>
				  	</thead>
			 		<tbody>
			 			<c:forEach items="${ustensils}" var="ustensil">
							<tr>
								<th>
									<c:out value="  ${ustensil.name}"></c:out>
								</th>
							</tr>
						</c:forEach>
			 		</tbody>
			 	</table>
			</div>
			
			<!-- Steps -->
			<div class="col col-lg-2">
				<c:forEach items="${steps}" var="step">
					<table class="table rounded table-sm table-dark" style="background: linear-gradient(#5F5F5F 0%, #404040 100%);">
				 		<thead>
					    	<tr>
						      <th scope="col"><h2><c:out value="Etape ${step.id} :"></c:out></h2></th>
						    </tr>
					  	</thead>
				 		<tbody>
				 			<tr>
							<tr>
								<th>
									<c:out value="${step.content}"></c:out>
								</th>
							</tr>
				 		</tbody>
				 	</table>
			 	</c:forEach>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${empty recipe}">
	<div class="d-flex align-items-center justify-content-center" style="height: 500px">
		<c:out escapeXml="false" value="<h1>Aucune recette sélectionnée</h1>"></c:out>
	</div>
</c:if>

<script type="text/javascript">
	function addNotification() {
		alert("Recette ajoutée à vos favoris !");
	}
</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>