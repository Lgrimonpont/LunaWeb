<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<style type="text/css">
.odd {
	background-color: silver;
}

.even {
	background-color: white;
}
</style>

<head>
<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.errors li {
	list-style: none;
}
</style>
</head>
<body>
	<s:form action="addUser">
		<s:textfield key="global.name" name="name" />
		<s:password key="global.password" name="password" />
		<s:textfield key="global.email" name="email" />
		<s:submit key="global.submit" name="submit" />
	</s:form>
	<s:if test="getModels()!=null">
		<table>
			<tr>
				<td width="10%">Id</td>
				<td width="20%">Name</td>
				<td width="20%">Email</td>
				<td width="20%">Password</td>
			</tr>

			<s:iterator value="getModels()" status="modelsStatus">
				<tr
					class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td width="10%"><s:property value="id" /></td>
					<td width="20%"><s:property value="name" /></td>
					<td width="20%"><s:property value="email" /></td>
					<td width="20%"><s:property value="password" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

</body>
</html>