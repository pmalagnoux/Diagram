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


<div class="ml-5 d-flex align-items-center justify-content-center" style="height: 200px">
	<c:out escapeXml="false" value="<h1>Nouvelle recette</h1>"></c:out>
</div>
<div class="d-flex align-items-center justify-content-center" style="height: 200px">
	<form action="RecipeCreationServlet" method="post">
		<!-- Étapes -->
		<br><c:out escapeXml="false" value="<h2>Étapes de la recette</h2>"></c:out>
		<c:forEach var="i" begin="1" end="${stepsCount }">
			<p>
				<c:out escapeXml="false" value="<h3>Étape ${i}</h3>"/>
				<textarea class="form-control" placeholder="Description" id="step${i}" name="step${i}"></textarea>
			</p>
		</c:forEach>
		
		<!-- Ingrédients -->
		<br><c:out escapeXml="false" value="<h2>Ingrédients</h2>"></c:out>
		<c:forEach var="i" begin="1" end="${ingredientsCount}">
			<p>
				<c:out escapeXml="false" value="<h3>Ingrédient ${i}</h3>"/>
				<input class="form-control" list="ingredientsList" id="ingredient${i}" name="ingredient${i}"/>
				
				<datalist id="ingredientsList">
					<option selected>Ingrédient...</option>
					<c:forEach items="${ingredients}" var="ingredient">
						<option value="${ingredient.id}">${ingredient.name}</option>
					</c:forEach>
				</datalist>
				<input type="text" class="form-control" placeholder="Quantité" id="ingredient${i}Qty" name="ingredient${i}Qty">	
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
				<input type="text" class="form-control" placeholder="Quantité" id="ustensil${i}Qty" name="ustensil${i}Qty">
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
		<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style="background-color: #C7C7C7">Créer</button>
	</form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</body>
</html>