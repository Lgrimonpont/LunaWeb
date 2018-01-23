<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Body.css" type="text/css">
<html>
<head>
</head>
<body>
	<div class="bodyJsp">
		<s:form action="addUser">
			<s:textfield key="global.name" name="id" />
			<s:textfield key="global.name" name="login" />
			<s:password key="global.password" name="pass" />
			<s:textfield key="global.email" name="role" />
			<s:submit key="global.submit" name="submit" />
		</s:form>
		<s:if test="getModels()!=null">
			<table>
				<tr>
					<td width="10%">id</td>
					<td width="20%">login</td>
					<td width="20%">pass</td>
					<td width="20%">role</td>
				</tr>

				<s:iterator value="getModels()" status="modelsStatus">
					<tr
						class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td width="10%"><s:property value="id" /></td>
						<td width="20%"><s:property value="login" /></td>
						<td width="20%"><s:property value="pass" /></td>
						<td width="20%"><s:property value="role" /></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
	</div>
</body>
</html>