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
Je suis dans la jsp2
<c:out value="J'arrive à reconnaitre le JSTL et prêt à être utilisée"></c:out>

<p>
<c:forEach items="${etudiants}" var="etudiant">
<ul>
<li>
<c:out value="${etudiant.nom }">
</c:out>
</li>
</ul>

</c:forEach>

</p>

<form action="dao" method="post">
<p>
<label id="id"> Identifiant </label>
<input type="text" id="id" name="id"/> 

<label id="nim"> Nom </label>
<input type="text" id="nom" name="nom"/> 

<label id="prenom"> Prénom </label>
<input type="text" id="prenom" name="prenom"/> 

<input type="submit"/>
</p>
</form>

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