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
	<h1>Page Commande</h1>
	<div class="bodyJsp">
		<s:if test="getListCommande()!=null">
			<table>
				<tr>
					<td width="10%">id</td>
					<td width="30%">libelle</td>
					<td width="10%">idclient</td>
					<td width="30%">datecommande</td>
					<td width="10%">supprimer</td>
					<td width="10%">modifier</td>
				</tr>

				<s:iterator value="getListCommande()" status="modelsStatus">
					<tr
						class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td width="10%"><s:property value="id" /></td>
						<td width="30%"><s:property value="libelle" /></td>
						<td width="10%"><s:property value="idclient" /></td>
						<td width="30%"><s:property value="datecommande" /></td>
						<td width="10%"><s:property value="supprimer" />
							<s:a action="supprimerCommande">
								<img alt="supprimer" src="./images/Garbage-Open-48.png"
									width="30px">
								<s:param name="idCommande">
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