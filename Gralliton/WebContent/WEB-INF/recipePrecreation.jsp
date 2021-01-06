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

<c:out escapeXml="false" value="<h1>Nouvelle recette</h1>"></c:out>
<form action="" method="post" onsubmit="return validateForm()">
	<div class="form-row">
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Titre" id="title" name="title">
		</div>
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Nombre d'ingrédients" id="ingredientsCount" name="ingredientsCount">
		</div>
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Nombre d'ustensiles" id="utensilsCount" name="utensilsCount">
		</div>
	</div>
	<div class="form-row">
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Temps de préparation" id="preparationTime" name="preparationTime">
		</div>
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Temps de cuisson" id="cookingTime" name="cookingTime">
		</div>
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Nombre de personnes" id="personCount" name="personCount">
		</div>
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Nombre tags" id="tagsCount" name="tagsCount">
		</div>
	</div>
	<div class="form-row">
		<div class="col-auto mt-3">
			<select class="form-control" id="difficulty" name="difficulty">
				<option selected>Difficulté...</option>
				<c:forEach items="${difficulties}" var="difficulty">
					<option value="${difficulty.id}">${difficulty.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-auto mt-3">
			<select class="form-control" id="recipeType" name="recipeType">
				
				<option selected>Type de recette...</option>
				<c:forEach items="${recipeTypes}" var="type">
					<option value="${type.id}">${type.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-auto mt-3">
			<input type="text" class="form-control" placeholder="Nombre d'étapes" id="stepsCount" name="stepsCount">
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

<script type="text/javascript">
	function validateForm(id) {
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
			alert("Le temps total de cuisine ne peux dépasser 5940 minutes (99h) !");
	    	return false;
		}
	}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</body>
</html>