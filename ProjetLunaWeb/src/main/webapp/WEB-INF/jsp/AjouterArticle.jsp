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
		<s:if test="getAjouter_modifier()==true">
			<s:form action="ajouterArticle">
				<s:textfield label="Code Catégorie" name="codeCategorie" />
				<s:textfield label="Catégorie" name="Categorie" />
				<s:textfield label="Désignation" name="designation" />
				<s:textfield label="Quantité Stock" name="quantitestock" />
				<s:textfield label="Prix Unitaire" name="prixUnitaire" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>
		<s:if test="getAjouter_modifier()==false">
			<s:form action="modifierArticle">
				<s:hidden label="id" name="article.id" />
				<s:textfield label="Code Catégorie" name="article.codeCategorie" />
				<s:textfield label="Catégorie" name="article.Categorie" />
				<s:textfield label="Désignation" name="article.designation" />
				<s:textfield label="Quantité Stock" name="article.quantitestock" />
				<s:textfield label="Prix Unitaire" name="article.prixUnitaire" />
				<s:submit key="global.submit" name="submit" />
			</s:form>
		</s:if>

	</div>
</body>
</html>