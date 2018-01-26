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
		<s:a action="ajouterCommandeCreerLink" class="a1">Ajouter</s:a>
		<s:a action="chercherCommandeCreerLink" class="a1">Rechercher</s:a>
		<s:a action="afficheCommandeCreer" class="a1">Retour</s:a>
	</div>
	<div class="bodyJsp">
		<s:form action="chercherCommandeCreer">
			<s:textfield label="ID commande" name="idcommande" />
			<s:submit value="Rechercher" name="submit" />
		</s:form>
		<s:if test="getListCommandeCreer()!=null">
			<table>
				<tr>
					<td width="10%">id</td>
					<td width="25%">idcommande</td>
					<td width="10%">idarticle</td>
					<td width="25%">quantite</td>
					<td width="15%">supprimer</td>
					<td width="15%">modifier</td>
				</tr>

				<s:iterator value="getListCommandeCreer()" status="modelsStatus">
					<tr
						class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td width="10%"><s:property value="id" /></td>
						<td width="25%"><s:property value="idcommande" /></td>
						<td width="10%"><s:property value="idArticle" /></td>
						<td width="25%"><s:property value="quantite" /></td>
			
						<td width="15%"><s:property value="supprimer" /> <s:a
								action="supprimerCommandeCreer">
								<img alt="supprimer" src="./images/Garbage-Open-48.png"
									width="30px">
								<s:param name="idCommandeCreer">
									<s:property value="id" />
								</s:param>
							</s:a></td>
						<td width="15%"><s:property value="modifier" /> <s:a
								action="modifierCommandeCreerLink">
								<img alt="modifier" src="./images/Data-Edit-48.png" width="30px">
								<s:param name="idCommandeCreer">
									<s:property value="id" />
								</s:param>
							</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
	</div>
</body>
</html>