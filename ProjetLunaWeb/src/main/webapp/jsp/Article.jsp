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
	<h1>Page Article</h1>
	<div class="bodyJsp">
		<s:if test="getListArticle()!=null">
			<table>
				<tr>
					<td width="5%">id</td>
					<td width="5%">codeCategorie</td>
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
	
						<td width="10%"><s:property value="supprimer" />
							<s:a action="supprimerArticle">
								<img alt="supprimer" src="./images/Garbage-Open-48.png"
									width="30px">
								<s:param name="idArticle">
									<s:property value="id" />
								</s:param>
							</s:a></td>
						<td width="10%"><s:property value="modifier" />
							<!--<s:a action="modifierClient"><img alt="modifier" src="./images/Data-Edit-48.png" width="30px"><s:param name="idClient">id</s:param></s:a>--></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
	</div>

	<a href="<s:url action="accueilLink"/>">Retour</a>
	<br>

</body>
</html>