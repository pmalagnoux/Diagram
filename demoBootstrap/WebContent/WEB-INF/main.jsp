<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="jquery-3.5.1.min.js"></script>
<title>Cours Polytech</title>
</head>

<body style= "background-color:#484d50; color:white">
	<%@ include file="menu.jsp"%>
	<div class="container">


		<div id="carousel" class="carousel slide" data-ride="carousel" data-interval="2000">
			<!-- Indicateur-sélecteur-->
			<ol class="carousel-indicators">
				<li data-target=".carousel" data-slide-to="0" class="active"></li>
				<li data-target=".carousel" data-slide-to="1"></li>
				<li data-target=".carousel" data-slide-to="2"></li>
			</ol>

			<!-- Carrousel  -->
			<div class="carousel-inner">
				<div class="carousel-item active active">
					<img class="d-block w-100" src="image/etudiants1.jpg" alt="étudiants 1">
					<div class="carousel-caption d-none d-md-block">
        				<p class="h1" style="color:black">Un avenir radieux.</p>
      				</div>
				</div>

				<div class="carousel-item">
					<img class="d-block w-100" src="image/etudiants2.jpg" alt="étudiants 2">
					<div class="carousel-caption d-none d-md-block">
        				<p class="h1" style="color:black">Des cours de qualité.</p>
      				</div>
				</div>

				<div class="carousel-item">
					<img class="d-block w-100" src="image/etudiants3.jpg" alt="étudiants 3">
					<div class="carousel-caption d-none d-md-block">
        				<p class="h1" style="color:black">Un monde merveilleux.</p>
      				</div>
				</div>
			</div>

			<!-- Contrôles -->
			<a id="precedent" class="carousel-control-prev" href="#carousel" role="button" data-slide="prev"> 
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Précédent</span>
			</a> 
			<a id="suivant" class="carousel-control-next" href="#carousel" role="button" data-slide="next"> 
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Suivant</span>
			</a>
		</div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>
