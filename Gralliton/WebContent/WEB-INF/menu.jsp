<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Navbar -->	
<nav class="navbar navbar-expand-lg navbar-white bg-manavbar" style= "background-color: #343434" >
	<a class="navbar-brand" href="accueil" style= "color : #ffffff;"> 
		<img src="images/cat.svg" class="d-inline-block align-top" width="30" height="30" alt="">
		Gralliton
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<form action="rechercheRecette" method="post" class="form-inline mr-auto">
    	<input class="form-control" type="text" placeholder="Search" aria-label="Search" id="keyWord" name="keyWord">
      	<button class="btn btn-rounded ml-sm-2" type="submit" style= "background-color: #C7C7C7">Go</button>
    </form>
    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" style= "background-color: #C7C7C7" aria-expanded="false" aria-label="Toggle navigation">Recherche avancée</button>

  
  	<c:choose>
		<c:when test="${empty sessionScope.userLogin }">
		<!-- Liens visiteur -->
			<a class="navbar-brand" href="logging" style="color : #C7C7C7;">Sign in</a>
			<a class="navbar-brand" href="register" style="color : #C7C7C7;">Register</a>
		</c:when>
		<c:otherwise>
		<!-- Dropdown (interface membre)-->
			<div class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style= "color : #C7C7C7;">
		         Mon Compte
		        </a>
		        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink" style= "background-color: #C7C7C7">
		          <a class="dropdown-item" href="#"><c:out value="${sessionScope.userLogin}"></c:out></a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="#">Mon Garde-Manger</a>
		          <a class="dropdown-item" href="#">Mes Recettes</a>
		          <a class="dropdown-item" href="creation-recette">Nouvelle Recette</a>
		          <a class="dropdown-item" href="favorite">Mes Favoris</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="disconnection">Déconnexion</a>
		        </div>
		  	</div>
		</c:otherwise>
	</c:choose>
</nav>
	
<!-- Contenu caché -->
<div class="collapse navbar-collapse pt-3 pb-3" id="navbarSupportedContent" style= "background-color: #999999">
	<h2 class="ml-3">Recherche avancée</h2>
	<form action="rechercheRecette" method="post" class="ml-4">
		<div class="form-row">
			<div class="col-auto mt-3">
	     		<input class="form-control" type="text" placeholder="risotto, cèpes, ..." aria-label="Search" id="keyWord" name="keyWord">
	     	</div>
	  	</div>
      	<div class="form-row">
			<div class="col-auto mt-3">
		  		<select class="form-control" id="recipeType" name="recipeType">
			    	<option value="0" selected>Type de recette...</option>
			    	<c:forEach items="${recipeTypes}" var="rt">
			    		<option value="${rt.id}">${rt.name} </option>
			    	</c:forEach>
		  		</select>
		  	</div>
		  	<div class="col-auto mt-3">
		  		<select class="form-control" id="difficulty" name="difficulty">
		  			<option value="0" selected>Difficulté max...</option>
			    	<c:forEach items="${difficulties}" var="diff">
			    		<option value="${diff.id}">${diff.name}</option>
			    	</c:forEach>
		  		</select>
		  	</div>
		  	<div class="col-auto mt-3">
		  		<select class="form-control" id="cookingTime" name="cookingTime">
				    <option value="0" selected>Temps de cuisine...</option>
				    <option value="10">moins de 10 min</option>
				    <option value="30">moins de 30 min</option>
				    <option value="60">moins de 60 min</option>
				    <option value="5940">plus de 60 min</option>
		  		</select>
	  		</div>
  	  	</div>
      	<div class="form-row mt-3">
		  	<button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style= "background-color: #C7C7C7">Rechercher</button>
	  	</div>
    </form>
</div>
