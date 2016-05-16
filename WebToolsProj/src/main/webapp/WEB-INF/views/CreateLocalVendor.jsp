<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Local Vendor Form</title>
</head>
<link href="<c:url value="/resources/css/jquery.datepick.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/LoggingMessage.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>
  
<body>
<div id="main">
		<div id="site_content">
	<h2>Register a New Local Vendor</h2>

	<form:form action="CreateLocalVendor.htm" commandName="Localenergyvendor"
		method="post">

		<table>
			<tr>
				<td>Local Vendor Name:</td>
				<td><form:input maxlength="20" path="localEnergyVendorName" size="20" /> <font
					color="red"><form:errors path="localEnergyVendorName" /></font></td>
			</tr>
			<tr>
				<td>Local Description:</td>

				<td><form:textarea maxlength="200" path="localEnergyVendorDescription" rows="5" cols="30" /> <font color="red"><form:errors
							path="localEnergyVendorDescription" /></font></td>
			</tr>
		
			<tr>
				<td colspan="2"><input type="submit" value="Create Vendor" /></td>
			</tr>
		</table>
	</form:form>
	</div>
	</div>
</body>
</html>