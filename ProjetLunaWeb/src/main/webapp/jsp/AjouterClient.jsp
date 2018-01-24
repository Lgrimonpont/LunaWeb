<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<s:url value='/css/Body.css' />">
</head>
<body>
	<div class="vertical-menu">
		<s:a action="ajouterClientLink">Ajouter</s:a>
		<s:a action="accueilLink">Accueil</s:a>
		<s:a action="accueilLink">Rechercher</s:a>
	</div>
	<div class="bodyJsp">
		<s:if test="getAjouter_modifier()==true">
			<s:form action="ajouterClient">
				<s:textfield label="Crée Le" name="dateCreation" />
				<s:textfield label="Carte de fidélité" name="carteFidelite" />
				<s:textfield label="Prénom" name="prenom" />
				<s:textfield label="Nom" name="nom" />
				<s:textfield label="Adresse" name="adresse" />
				<s:textfield label="Code postal" name="codePostal" />
				<s:textfield label="Fixe" name="fixe" />
				<s:textfield label="Mobile" name="mobile" />
				<s:textfield label="Email" name="email" />
				<s:textfield label="remarques" name="remarques" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>
		<s:if test="getAjouter_modifier()==false">
			<s:form action="modifierClient">
				<s:textfield label="id" name="client.id" />
				<s:textfield label="Crée Le" name="client.dateCreation" />
				<s:textfield label="Carte de fidélité" name="client.carteFidelite" />
				<s:textfield label="Prénom" name="client.prenom" />
				<s:textfield label="Nom" name="client.nom" />
				<s:textfield label="Adresse" name="client.adresse" />
				<s:textfield label="Code postal" name="client.codePostal" />
				<s:textfield label="Fixe" name="client.fixe" />
				<s:textfield label="Mobile" name="client.mobile" />
				<s:textfield label="Email" name="client.email" />
				<s:textfield label="remarques" name="client.remarques" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>

	</div>
</body>
</html>