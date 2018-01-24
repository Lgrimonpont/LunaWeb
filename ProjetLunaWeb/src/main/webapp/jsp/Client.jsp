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
		<s:if test="getListClient()!=null">
			<table>
				<tr>
					<td width="1%">id</td>
					<td width="5%">dateCreation</td>
					<td width="5%">carteFidelite</td>
					<td width="9%">prenom</td>
					<td width="9%">nom</td>
					<td width="13%">adresse</td>
					<td width="4%">codePostal</td>
					<td width="3%">fixe</td>
					<td width="3%">mobile</td>
					<td width="10%">email</td>
					<td width="20%">remarques</td>
					<td width="6%">supprimer</td>
					<td width="6%">modifier</td>
				</tr>

				<s:iterator value="getListClient()" status="modelsStatus">
					<tr
						class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td width="1%"><s:property value="id" /></td>
						<td width="5%"><s:property value="dateCreation" /></td>
						<td width="5%"><s:property value="carteFidelite" /></td>
						<td width="9%"><s:property value="prenom" /></td>
						<td width="9%"><s:property value="nom" /></td>
						<td width="13%"><s:property value="adresse" /></td>
						<td width="4%"><s:property value="codePostal" /></td>
						<td width="3%"><s:property value="fixe" /></td>
						<td width="3%"><s:property value="mobile" /></td>
						<td width="10%"><s:property value="email" /></td>
						<td width="20%"><s:property value="remarques" /></td>
						<td width="6%"><s:property value="supprimer" /> <s:a
								action="supprimerClient">
								<img alt="supprimer" src="./images/Garbage-Open-48.png"
									width="30px">
								<s:param name="idClient">
									<s:property value="id" />
								</s:param>
							</s:a></td>
						<td width="6%"><s:property value="modifier" /> <s:a
								action="modifierClientLink">
								<img alt="modifier" src="./images/Data-Edit-48.png" width="30px">
								<s:param name="idClient">
									<s:property value="id" />
								</s:param>
							</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
	</div>

	<a href="<s:url action="accueilLink"/>">Retour</a>
	<br>

</body>
</html>