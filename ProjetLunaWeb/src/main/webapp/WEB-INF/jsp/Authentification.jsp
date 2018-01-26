<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width" />
<title>Authentification</title>
</head>
<body>
	<s:if test="getError()==true">
		<div style="color: red">login ou mot de passe invalide</div>
	</s:if>
	<s:form action="login">
		<s:textfield name="login" label="Nom d'utilisateur" />
		<s:password name="pass" label="Mot de passe" />
		<s:submit value="Se connecter" name="submit" />
	</s:form>
</body>
</html>