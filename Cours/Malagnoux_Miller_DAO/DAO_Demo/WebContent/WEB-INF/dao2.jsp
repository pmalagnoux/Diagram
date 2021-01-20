<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>


<br>
<h1 class="ml-1">Cr�ation �tudiant</h1>
<form action="dao" method="post" class="ml-3">
<input type="hidden" name="form" value="create"/>
<div class="row">
    <div class="col-auto ">
		<label id="idCreate"> Identifiant </label>
		<input class="form-control mr-sm-2" name="idCreate" id="idCreate" type="text" placeholder="ID">
	</div>
	<div class="col-auto">
		<label id="nomCreate"> Nom </label>
		<input class="form-control mr-sm-2" name="nomCreate" id="nomCreate" type="text" placeholder="Nom">
	</div>
	<div class="col-auto">
		<label id="prenomCreate"> Pr�nom </label>
		<input class="form-control mr-sm-2" name="prenomCreate" id="prenomCreate" type="text" placeholder="Pr�nom">
	</div>
	<div class="col-auto align-self-end">
		<button class="btn btn-outline-success my-2 my-sm-0" id="create" type="submit">Cr�er</button>
	</div>
</div>
</form>

<br>
<h1 class="ml-1">Modification</h1>
<form action="dao" method="post" class="ml-3">
<input type="hidden" name="form" value="modif"/>
<div class="row">
    <div class="col-auto">
    <label for="modif">Etudiant � modifier :</label>
  	<select class="form-control" id="id" name="id">
    	<c:forEach items="${resultat}" var="etud">
    		<option value="${etud.id}">${etud.prenom} ${etud.nom}</option>
    	</c:forEach>
 </select>
</div>
</div>
 
 <br>
<div class="row">
    <div class="col-auto">
		<label id="nom"> Nom </label>
		<input class="form-control mr-sm-2" name="nom" id="nom" type="text" placeholder="Nom">
	</div>
	<div class="col-auto">
		<label id="prenom"> Pr�nom </label>
		<input class="form-control mr-sm-2" name="prenom" id="prenom" type="text" placeholder="Pr�nom">
	</div>
	<div class="col-auto align-self-end">
		<button class="btn btn-outline-success my-2 my-sm-0" id="modif" type="submit">Modifier</button>
	</div>
</div>
</form>


<br>
<h1 class="ml-1">Suppression</h1>
<form action="dao" method="post" class="ml-3">
<p>
<input type="hidden" name="form" value="delete"/>
<div class="row">
	<div class="col-auto">
		<label for="suppr" class="justify-content-start">Etudiant � supprimer :</label>
  		<select class="form-control" id="suppr" name="suppr">
	    	<c:forEach items="${resultat}" var="etud">
	    		<option value="${etud.id}">${etud.prenom} ${etud.nom}</option>
	    	</c:forEach>
  		</select>
  	</div>
  	<div class="col-auto align-self-end">
  		<button class="btn btn-outline-success my-2 my-sm-0" id="suppr" type="submit">Supprimer</button>
  	</div>
</div>
</form>
<br>


<br>
<h1 class="ml-1">Liste des �tudiants</h1>
<div class="row">
	<div class="col-auto">
		<form action="dao" method="post" class="ml-3">
		<input type="hidden" name="form" value="search"/>
		    <div class="row">
				<input class="form-control mr-sm-2" name="search" id="search" type="search" placeholder="Search">
			</div>
			<div class="row justify-content-center mt-2">
				<button class="btn btn-outline-success my-2 my-sm-0" id="search" name="search" type="submit">Rechercher</button>
			</div>
		</form>
	</div>
	<div class="col-auto">
	<c:forEach items="${searchEtu}" var="se">
		<div class="row-auto">
			<ul class="list-group">
				<li class="list-group-item">
					<c:out value="${se.nom} ${se.prenom}"></c:out>
				</li>
			</ul>
		</div>
	</c:forEach>
	</div>
</div>
</body>
</html>