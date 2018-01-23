<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
</head>
<body>
	<h1>Bienvenue sur le projet LunaWeb test</h1>
	<s:form action="login">
		<s:textfield name="login" label="Nom d'utilisateur" />
		<s:textfield name="pass" label="Mot de passe" />
		<s:submit value="Se connecter" name="submit" />
	</s:form>
</body>
</html>