<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Global Vendor Form</title>
</head>
<link href="<c:url value="/resources/css/jquery.datepick.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/image_slide.js" />"></script>
<body>

<div id="main">
		<div id="site_content">
	<h2>Register a New Global Energy</h2>

	<form:form action="AddGlobalEnergy.htm" commandName="Globalenergyvendor"
		method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input maxlength="20" path="globalEnergyVendorName" size="20" /> <font
					color="red"><form:errors path="globalEnergyVendorName" /></font></td>
			</tr>
			<tr>
			<td>Description:</td>				
				<td><form:textarea path="GlobalEnergyVendorDescription" rows="5" cols="30" /> <font
					color="red"><form:errors path="GlobalEnergyVendorDescription" /></font></td>
			</tr>
			<tr>
				<td colspan="2"><input maxlength="100" type="submit" value="Create Global Energy Vendor" /></td>
			</tr>
		</table>
	</form:form>
	</div>
	</div>
</body>
</html>