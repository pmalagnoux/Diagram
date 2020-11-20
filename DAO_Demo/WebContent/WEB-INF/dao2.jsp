<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Création étudiant</h1>
<form action="dao" method="post">
<p>
<input type="hidden" name="form" value="create"/>

<label id="idCreate"> Identifiant </label>
<input type="text" id="idCreate" name="idCreate"/> 

<label id="nomCreate"> Nom </label>
<input type="text" id="nomCreate" name="nomCreate"/> 

<label id="prenomCreate"> Prénom </label>
<input type="text" id="prenomCreate" name="prenomCreate"/> 

<input type="submit"/>
</p>
</form>


<h1>Modification</h1>
<form action="dao" method="post">
<p>
<input type="hidden" name="form" value="modif"/>
<label for="modif">Etudiant à modifier :</label>
  <select id="id" name="id">
    <c:forEach items="${resultat}" var="etud">
    	<option value="${etud.id}">${etud.prenom} ${etud.nom}</option>
    </c:forEach>
 </select>
 <br>

<label id="nom"> Nom </label>
<input type="text" id="nom" name="nom"/> 

<label id="prenom"> Prénom </label>
<input type="text" id="prenom" name="prenom"/> 

<input type="submit"/>
</p>
</form>

<h1>Suppression</h1>
<form action="dao" method="post">
<p>
<input type="hidden" name="form" value="delete"/>
  <label for="suppr">Etudiant à supprimer :</label>
  <select id="suppr" name="suppr">
    <c:forEach items="${resultat}" var="etud">
    	<option value="${etud.id}">${etud.prenom} ${etud.nom}</option>
    </c:forEach>
  </select>
  <input type="submit"/>
  </p>
</form>
<br>

<h1>Liste des étudiants</h1>
<input>
<c:forEach items="${resultat}" var="etud">
<ul>
<li>
<c:out value="${etud.id}"></c:out>
<c:out value="${etud.nom}"></c:out>
<c:out value="${etud.prenom}"></c:out>
</li>
</ul>

</c:forEach>


</body>
</html>