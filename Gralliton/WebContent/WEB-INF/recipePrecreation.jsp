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
	
	<c:choose>
		<c:when test="${!(empty sessionScope.userLogin)}"> <!-- Interface membre -->
			<div class="d-flex align-items-center justify-content-center" style="height: 200px">
					<c:out escapeXml="false" value="<h1>Nouvelle recette</h1>"></c:out>
			</div>
			<div class="d-flex align-items-center justify-content-center" style="height: 200px">
				<form action="" method="post" onsubmit="return validateForm()">
					<div class="form-row">
						<!-- Titre -->
						<div class="col-auto mt-3">
							<input type="text" class="form-control" placeholder="Titre" id="title" name="title">
						</div>
						<div class="col-auto mt-3">
						<!-- Nombre d'ingr�dients -->
							<input type="text" class="form-control" placeholder="Nombre d'ingr�dients" id="ingredientsCount" name="ingredientsCount">
						</div>
						<!-- Nombre d'ustensiles -->
						<div class="col-auto mt-3">
							<input type="text" class="form-control" placeholder="Nombre d'ustensiles" id="utensilsCount" name="utensilsCount">
						</div>
					</div>
					<div class="form-row">
						<!-- Temps de pr�paration -->
						<div class="col-auto mt-3">
							<input type="text" class="form-control" placeholder="Temps de pr�paration" id="preparationTime" name="preparationTime">
						</div>
						<!-- Temps de cuisson -->
						<div class="col-auto mt-3">
							<input type="text" class="form-control" placeholder="Temps de cuisson" id="cookingTime" name="cookingTime">
						</div>
						<!-- Nombre de personnes -->
						<div class="col-auto mt-3">
							<input type="text" class="form-control" placeholder="Nombre de personnes" id="personCount" name="personCount">
						</div>
						<!-- Nombre de tags -->
						<div class="col-auto mt-3">
							<input type="text" class="form-control" placeholder="Nombre de tags" id="tagsCount" name="tagsCount">
						</div>
					</div>
					<div class="form-row">
						<!-- Difficult� -->
						<div class="col-auto mt-3">
							<select class="form-control" id="difficulty" name="difficulty">
								<option selected>Difficult�...</option>
								<c:forEach items="${difficulties}" var="difficulty">
									<option value="${difficulty.id}">${difficulty.name}</option>
								</c:forEach>
							</select>
						</div>
						<!-- Type de recette -->
						<div class="col-auto mt-3">
							<select class="form-control" id="recipeType" name="recipeType">
								<option selected>Type de recette...</option>
								<c:forEach items="${recipeTypes}" var="type">
									<option value="${type.id}">${type.name}</option>
								</c:forEach>
							</select>
						</div>
						<!-- Nombre d'�tapes -->
						<div class="col-auto mt-3">
							<input type="text" class="form-control" placeholder="Nombre d'�tapes" id="stepsCount" name="stepsCount">
						</div>
					</div>
							
					<div class="form-row">
						<div class="col-auto mt-3">
							<!-- Telecharger image -->
						</div>
						<div class="col-auto mt-3">
							<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7">Poursuivre</button>
						</div>
					</div>
				</form>
			</div>
		</c:when>
		<c:otherwise> <!-- Interface visiteur -->
			<div class="d-flex align-items-center justify-content-center" style="height: 200px">
					<c:out escapeXml="false" value="<h1>Acc�s refus� ! Vous devez �tre connect� !</h1>"></c:out>
			</div>
		</c:otherwise>	
	</c:choose>
	
	<!-- V�rification que des donn�es du formulaire -->
	<script type="text/javascript">
		function validateForm() {
			var title = document.getElementById("title").value;
			var ingredientsCount = document.getElementById("ingredientsCount").value;
			var utensilsCount = document.getElementById("utensilsCount").value;
			var preparationTime = document.getElementById("preparationTime").value;
			var cookingTime = document.getElementById("cookingTime").value;
			var personCount = document.getElementById("personCount").value;
			var tagsCount = document.getElementById("tagsCount").value;
			var difficulty = document.getElementById("difficulty").value;
			var recipeType = document.getElementById("recipeType").value;
			var stepsCount = document.getElementById("stepsCount").value;
			if (title == "" || ingredientsCount == "" || utensilsCount == "" || preparationTime == "" 
					|| cookingTime == "" || personCount == "" || tagsCount == "" || difficulty == "" 
					|| recipeType == "" || stepsCount == "") {
				alert("Veulliez remplir tous les champs !");
			    return false;
			}
			if (preparationTime + cookingTime >= "5940") {
				alert("Le temps total de cuisine ne peux d�passer 5940 minutes (99h) !");
		    	return false;
			}
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</body>
</html>