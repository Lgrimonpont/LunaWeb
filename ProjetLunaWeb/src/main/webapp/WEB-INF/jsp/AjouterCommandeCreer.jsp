<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<s:url value='/css/Body.css' />">
<meta name="viewport" content="width=device-width" />
</head>
<body>
	<div class="vertical-menu">
		<s:a action="ajouterCommandeCreerLink" class="a1">Ajouter</s:a>
		<s:a action="chercherCommandeCreerLink" class="a1">Rechercher</s:a>
		<s:a action="afficheCommandeCreer" class="a1">Retour</s:a>
	</div>
	<div class="bodyJsp">
		<s:if test="getAjouter_modifier()==true">
			<s:form action="ajouterCommandeCreer">
				<s:select label="Id Commande" name="idcommande" headerKey="1" headerValue="-- Please Select --" list="listIdCommande" />
				<s:select label="Id Article" name="idArticle" headerKey="1" headerValue="-- Please Select --" list="listIdArticle" />
				<s:textfield label="quantite" name="quantite" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>
		<s:if test="getAjouter_modifier()==false">
			<s:form action="modifierCommandeCreer">
				<s:hidden label="id" name="commandeCreer.id" />
				<s:hidden label="idcommande" name="commandeCreer.idcommande" />
				<s:hidden label="idarticle" name="commandeCreer.idArticle" />
				<s:textfield label="quantite" name="commandeCreer.quantite" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>

	</div>
</body>
</html>