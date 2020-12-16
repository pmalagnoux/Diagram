<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
        <nav class="navbar navbar-expand-lg navbar-white bg-manavbar" style= "background-color: #343434" >
	<a class="navbar-brand" href="#" style= "color : #ffffff;"> 
	<img src="images/cat.svg" class="d-inline-block align-top" width="30" height="30" alt="">
		Gralliton
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<form class="form-inline mr-auto">
      <input class="form-control" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style= "background-color: #C7C7C7">Go</button>
    </form>
      <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" style= "background-color: #C7C7C7" aria-expanded="false" aria-label="Toggle navigation">
    collapse
  </button>
    <a class="navbar-brand" href="#" style= "color : #C7C7C7;">Sign in</a>
	<a class="navbar-brand" href="#" style= "color : #C7C7C7;">Register</a>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <br>
<h1 class="ml-1">Création étudiant</h1>
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
		<label id="prenomCreate"> Prénom </label>
		<input class="form-control mr-sm-2" name="prenomCreate" id="prenomCreate" type="text" placeholder="Prénom">
	</div>
	<div class="col-auto align-self-end">
		<button class="btn btn-outline-success my-2 my-sm-0" id="create" type="submit">Créer</button>
	</div>
</div>
</form>
  </div>
  
	</nav>
	
	
