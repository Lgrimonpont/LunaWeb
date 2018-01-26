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
		<s:a action="ajouterArticleLink" class="a1">Ajouter</s:a>
		<s:a action="chercherArticleLink" class="a1">Rechercher</s:a>
		<s:a action="afficheArticle" class="a1">Retour</s:a>
	</div>
	<div class="bodyJsp">
		<s:form action="chercherArticle">
			<s:textfield label="Désignation" name="designation" />
			<s:submit value="Rechercher" name="submit" />
		</s:form>
		<s:if test="getListArticle()!=null">
			<table>
				<tr>
					<td width="5%">id</td>
					<td width="5%">coteCategorie</td>
					<td width="25%">Categorie</td>
					<td width="25%">designation</td>
					<td width="10%">quantitestock</td>
					<td width="10%">prixUnitaire</td>
					<td width="10%">supprimer</td>
					<td width="10%">modifier</td>
				</tr>

				<s:iterator value="getListArticle()" status="modelsStatus">
					<tr
						class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td width="5%"><s:property value="id" /></td>
						<td width="5%"><s:property value="codeCategorie" /></td>
						<td width="25%"><s:property value="Categorie" /></td>
						<td width="25%"><s:property value="designation" /></td>
						<td width="10%"><s:property value="quantitestock" /></td>
						<td width="10%"><s:property value="prixUnitaire" /></td>
						<td width="10%"><s:property value="supprimer" /> <s:a
								action="supprimerArticle">
								<img alt="supprimer" src="./images/Garbage-Open-48.png"
									width="30px">
								<s:param name="idArticle">
									<s:property value="id" />
								</s:param>
							</s:a></td>
						<td width="10%"><s:property value="modifier" /> <s:a
								action="modifierArticleLink">
								<img alt="modifier" src="./images/Data-Edit-48.png" width="30px">
								<s:param name="idArticle">
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