<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add User Account Form</title>
</head>
<link href="<c:url value="/resources/css/jquery.datepick.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/LoggingMessage.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>
  
<body>
<div id="main">
		<div id="site_content">
	<h2>Register a New Consumer</h2>

	<form:form action="ConsumerDashBoard.htm" commandName="Useraccount"
		method="post">

		<table>
			<tr>
				<td>User Account:</td>
				<td><form:input path="username" size="20" /> <font
					color="red"><form:errors path="username" /></font></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" size="20" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
			 <tr>
    <td>Role Id:</td>
    <td><form:input path="role.roleId" size="30" /> <font color="red"><form:errors path="role.roleId"/></font></td>
</tr> 	
			<tr>
				<td colspan="2"><input type="submit" value="Create User Account" /></td>
			</tr>
		</table>
	</form:form>
	</div>
	</div>
</body>
</html>