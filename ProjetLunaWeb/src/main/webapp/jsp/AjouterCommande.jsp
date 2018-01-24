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
		<s:a action="ajouterCommandeLink">Ajouter</s:a>
		<s:a action="accueilLink">Accueil</s:a>
		<s:a action="accueilLink">Rechercher</s:a>
	</div>
	<div class="bodyJsp">
		<s:if test="getAjouter_modifier()==true">
			<s:form action="ajouterCommande">
				<s:textfield label="Crée Le" name="datecommande" />
				<s:textfield label="ID" name="id" />
				<s:textfield label="Libellé" name="libelle" />
				<s:textfield label="Numero client" name="idclient" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>
		<s:if test="getAjouter_modifier()==false">
			<s:form action="modifierCommande">
				<s:textfield label="Crée Le" name="commande.datecommande" />
				<s:textfield label="ID" name="commande.id" />
				<s:textfield label="Libellé" name="commande.libelle" />
				<s:textfield label="Numero Client" name="commande.idclient" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>

	</div>
</body>
</html>