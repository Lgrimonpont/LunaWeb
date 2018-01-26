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
		<s:a action="ajouterCommandeLink" class="a1">Ajouter</s:a>
		<s:a action="chercherCommandeLink" class="a1">Rechercher</s:a>
		<s:a action="afficheCommande" class="a1">Retour</s:a>
	</div>
	<div class="bodyJsp">
		<s:if test="getAjouter_modifier()==true">
			<s:form action="ajouterCommande">
				<s:textfield label="Crée Le" name="datecommande" />
				<s:textfield label="Libellé" name="libelle" />
				<s:select label="Id" name="idclient" headerKey="1"
					headerValue="-- Please Select --" list="listIdClient" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>
		<s:if test="getAjouter_modifier()==false">
			<s:form action="modifierCommande">
				<s:hidden label="id" name="commande.id" />
				<s:textfield label="Crée Le" name="commande.datecommande" />
				<s:textfield label="Libellé" name="commande.libelle" />
				<s:hidden label="idclient" name="commande.idclient" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>

	</div>
</body>
</html>