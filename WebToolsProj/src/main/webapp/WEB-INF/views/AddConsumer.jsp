<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Consumer Form</title>
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
			<h2>Register a New Consumer</h2>

			<form:form name="AddConsumer" action="AddConsumer.htm"
				commandName="Consumer" method="post"
				onsubmit="return validateForm()">

				<table>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" maxlength="20" size="20" />
							<font color="red"><form:errors path="firstName" /></font></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" maxlength="20" size="20" />
							<font color="red"><form:errors path="lastName" /></font></td>
					</tr>
					<tr>
						<td>Address Line1:</td>
						<td><form:input path="addressLine1" maxlength="40" size="40" />
							<font color="red"><form:errors path="addressLine1" /></font></td>
					</tr>
					<tr>
						<td>Address Line2:</td>
						<td><form:input path="addressLine2" maxlength="40" size="40" />
							<font color="red"><form:errors path="addressLine2" /></font></td>
					</tr>
					<tr>
						<td>State</td>
						<td><form:input path="state" maxlength="20" size="20" /> <font
							color="red"><form:errors path="state" /></font></td>
					</tr>
					<tr>
						<td>City</td>
						<td><form:input path="city" size="20" maxlength="20" /> <font
							color="red"><form:errors path="city" /></font></td>
					</tr>
					<tr>
						<td>Zip</td>
						<td><form:input name="zip" id="zipId" path="zip" size="5"
								maxlength="5" /> <font color="red"><form:errors
									path="zip" /></font></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><form:input name="email" path="email" size="30"
								maxlength="30" /> <font color="red"><form:errors
									path="email" /></font></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Create User" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
<script>

function validateForm() {
   
  
    var zip=document.forms["AddConsumer"]["zip"].value;

  
        var isValid = /(^\d{5}$)|(^\d{5}-\d{4}$)/.test(zip);
        
        if (isValid)
           
        else {
            alert('Invalid ZipCode');
        }
    
    var x = document.forms["AddConsumer"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
  
}
</script>


</html>