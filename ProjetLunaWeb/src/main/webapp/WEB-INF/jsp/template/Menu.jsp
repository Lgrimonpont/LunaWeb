<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="<s:url value='/css/Menu.css' />">
<div class="menu">
	<ul>
		<li><s:a action="accueilLink"><span>Accueil</span></s:a>&nbsp;&nbsp;</li>
		<li><s:a action="afficheClient"><span>Client</span></s:a>&nbsp;&nbsp;</li>
		<li><s:a action="afficheArticle"><span>Article</span></s:a>&nbsp;&nbsp;</li>
		<li><s:a action="afficheCommande"><span>Commande</span></s:a>&nbsp;&nbsp;</li>
		<li><s:a action="afficheCommandeCreer"><span>CommandeCreer</span></s:a>&nbsp;&nbsp;</li>
		<li><s:a action="logout"><span>se Deconnecter</span></s:a>&nbsp;&nbsp;</li>
	</ul>
</div>
