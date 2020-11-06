<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</p>je suis dans la vue<p>

<!-- XSS Cross-site scripting   => faille de s�curit� -->
Expression Language<br>
Nom : ${nom} <!-- Pour utiliser le param�tre "nom" pass� dans l'url-->
<br>
<!-- param�tre escapeXml="false" pour ne pas �chapper les balises. c:out permet d'�crire des infos et n'est pas sujet � la faille XSS-->
<c:out value="<h1> Bonjour ${nom} </h1>"  ></c:out>
<c:set var="prenom" value="florian" scope="page"></c:set>
<br>
<c:out value="Ton pr�nom est ${prenom}"></c:out>
<!-- scope => port�e de la variable 
   -page, variable valable que dans la page
   -request, variable dispo dans toute la requete
   -session, variable dispo dans toute la session utilisateur
   -application, variable globale -->
<br>
<!-- D�claration de la variable x = 14 -->
<p>
<c:set var="x" value="14"></c:set> <!-- <c:set var="x">14</c:set>  -->
<c:out value="x = ${x}"></c:out>
</p>

<!-- Modifier variable -->
<p>
<c:set var="x">21</c:set>
<c:out value="La valeur de x apr�s modification = ${x}"></c:out>
</p>

<p> 
<c:remove var="x" scope="page"/>
</p>
<p> 
<c:out value="La valeur de x apr�s suppression = ${x}"></c:out>
</p>

<!-- Traitement d'un objet -->
<p> 
<c:out value="Nom �tudiant (objet) ${etudiant.nom}"/>
</p>

<!-- Modif attribut objet -->
<p> 
<c:set target="${etudiant}" property="nom" value="Florian2"/>
<c:out value="Apr�s modification du nom de l'objet ${etudiant.nom}"></c:out>
</p>

<!-- Faire la somme de 2 param�tres r�cup�r�s (a et b) dans une requ�te get -->
<c:out value="terme1 + terme2 = ${resultat}"></c:out>
<br>

<!-- Les test avec JSTL -->
<c:if test="${1==1}"><h1>Le test est v�rifi�</h1></c:if>
<br>

<!-- Choix multiple -->
<c:choose>
	<c:when test="${!(1==1)}">Test 1 = 1</c:when>
	<c:when test="${2==2}">Test 2 = 2</c:when>
	<c:when test="${3==3}">Test 3 = 3</c:when>
	<c:otherwise>Aucun test n'est v�rifi�</c:otherwise>
</c:choose>



</body>
</html>