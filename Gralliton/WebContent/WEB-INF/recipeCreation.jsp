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
<form action="RecipeCreationServlet" method="post">
	<!-- �tapes -->
	<br><c:out escapeXml="false" value="<h2>�tapes de la recette</h2>"></c:out>
	<c:forEach var="i" begin="1" end="${stepsCount }">
		<p>
			<c:out escapeXml="false" value="<h3>�tape ${i}</h3>"/>
			<textarea class="form-control" placeholder="Description" id="step${i}" name="step${i}"></textarea>
		</p>
	</c:forEach>
	
	<!-- Ingr�dients -->
	<br><c:out escapeXml="false" value="<h2>Ingr�dients</h2>"></c:out>
	<c:forEach var="i" begin="1" end="${ingredientsCount}">
		<p>
			<c:out escapeXml="false" value="<h3>Ingr�dient ${i}</h3>"/>
			<input class="form-control" list="ingredientsList" id="ingredient${i}" name="ingredient${i}"/>
			
			<datalist id="ingredientsList">
				<option selected>Ingr�dient...</option>
				<c:forEach items="${ingredients}" var="ingredient">
					<option value="${ingredient.id}">${ingredient.name}</option>
				</c:forEach>
			</datalist>
			<input type="text" class="form-control" placeholder="Quantit�" id="ingredient${i}Qty" name="ingredient${i}Qty">	
		</p>
	</c:forEach>
	
	<!-- Ustensiles -->
	<br><c:out escapeXml="false" value="<h2>Ustensiles</h2>"></c:out>
	<c:forEach var="i" begin="1" end="${utensilsCount}">
		<p>
			<c:out escapeXml="false" value="<h3>Ustensile ${i}</h3>"/>
			<input class="form-control" list="ustensilesList" id="ustensil${i}" name="ustensil${i}"/>
			
			<datalist id="ustensilesList">
			<option selected>Ustensile...</option>
				<c:forEach items="${ustensils}" var="ustensil">
					<option value="${ustensil.id}">${ustensil.name}</option>
				</c:forEach>
			</datalist>
			<input type="text" class="form-control" placeholder="Quantit�" id="ustensil${i}Qty" name="ustensil${i}Qty">
		</p>
	</c:forEach>
	
	<!-- Tags -->
	<br><c:out escapeXml="false" value="<h2>Tags</h2>"></c:out>
	<c:forEach var="i" begin="1" end="${tagsCount}">
		<p>
			<c:out escapeXml="false" value="<h3>Tag ${i}</h3>"/>
			<input class="form-control" list="tagsList" id="tag${i}" name="tag${i}"/>
			
			<datalist id="tagsList">
			<option selected>Tag...</option>
				<c:forEach items="${tags}" var="tag">
					<option value="${tag.id}">${tag.name}</option>
				</c:forEach>
			</datalist>
		</p>
	</c:forEach>
	<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7">Cr�er</button>
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
	}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</body>
</html>