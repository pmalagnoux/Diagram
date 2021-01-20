<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:out value="Authentification :"></c:out>

<c:if test="${authentification.isConnexion()==true}">
<c:out value="Vous êtes authentifié !"></c:out>
</c:if>

<form  method="post" action="jstl">
<label for="login"> Login : </label>
<input type="text" id="log" name="log"/>
<label for="pass"> Mot de passe : </label>
<input type="password" id="pass" name="pass"/>


<input type="submit"/>  
</form>


</body>
</html>