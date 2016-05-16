<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<link href="<c:url value="/resources/css/LoggingMessage.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Global Vendor Dashboard</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
</head>
<body>
<div id="main">
		<div id="site_content">
	<h2>New Global Vendor Created Successfully:
		${gev.globalEnergyVendorName}</h2>

	<form name="Global" action="GlobalServices.htm">
		<button onClick="" id="GetGlobalServices" type="button">Get
			Global Services</button>
		<div id="GetServices"></div>
		Number of Services you want to add:<input type="text" name="txtNumb" id="txtNumb"></input>
		<button onClick="" id="AddNumberOfServices" type="button">Add
			Services</button>
		<br> <input type="hidden"
			value="${gev.globalVendorId}" name="globalId"
			id="globalId" />

		<div id="screens"></div>
	</form>
	<form name="Logout" action="Logout.htm">
		<input type="submit" value="Logout">
	</form>
	</div>
	</div>
</body>
<script>
function create() {
	var param = document.getElementById("txtNumb").value;
	var s = "";
	if (!isNaN(param)) {
		s = '<table border=1><tr><td>Service Name </td><td>Rate</td><td>Description</td></tr>';
		for (var i = 0; i < param; i++) {
			s += '<tr><td><input maxlength="20" type="text" name="gevServName' + i + '"></td>';
			s += '<td><input maxlength="5" type="text" name="rate' + i + '"></td>';
			s += '<td><textarea maxlength="100" rows="4" cols="50" name="gevServDesc' + i + '"></textarea></td>';
			document.getElementById("screens").innerHTML = s;
		}
		s += '</table>';
		s += '<button type="submit" name="action" value="Submit">Add Services</button>';
		document.getElementById("screens").innerHTML = s;
	} else {
		s += 'Please input number';
		document.getElementById("screens").innerHTML = s;
	}
}
$(document).ready(function(){
	
	$('#AddNumberOfServices').click(function() {
		create();
	    });
	var hv = $('#globalId').val();
	

	$('#GetGlobalServices').click(function() {
		var idd = $('#globalId').val();
		
		$('#GetServices').html("");
		
		
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		url : "GetGlobalNumberOfService.htm",
		data:hv,		
		complete : function(data) {		
			
			try
				{
				
			var dataJson = data.responseText;
			
			var jsonResponse = JSON.parse(dataJson);
				}catch(err){
					alert(err);
				}
			
			var x = document.createElement("TABLE");
			x.setAttribute("id", "myTable");
			document.getElementById("GetServices").appendChild(x);
			var y = document.createElement("TR");
			y.setAttribute("id", "myTr");
			document.getElementById("myTable").appendChild(y);
			var z = document.createElement("TH");
			var t = document.createTextNode("Select");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z = document.createElement("TH");
			var t = document.createTextNode("Delete");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z = document.createElement("TH");
			var t = document.createTextNode("GlobalEnergyServiceName");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z = document.createElement("TH");
			var t = document.createTextNode("Rate");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			
			var z = document.createElement("TH");
			var t = document.createTextNode("GlobalEnergyServiceDescription");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			
			$.each(jsonResponse.GlobalServices, function(index, element) {
				var y = document.createElement("TR");
                y.setAttribute("id", "myTr" + index);
                document.getElementById("myTable").appendChild(y);
               
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = index;
                inp.setAttribute("type", "button");
                var t = document.createTextNode("Save"); // Create a text node
                inp.appendChild(t);
                inp.setAttribute("id",element.id.globalServiceId); 
                inp.setAttribute("name", "btnSave");
                inp.setAttribute("value", "Save");
                inp.onclick = function () {
                	var id=$(this).parent().parent().find('input').eq(0).attr('id');
                	var name = $(this).parent().parent().find('input').eq(2).val();
                	var rate = $(this).parent().parent().find('input').eq(3).val();
                	var Desc = $(this).parent().parent().find('input').eq(4).val();
                	
                	
                	$.ajax({
                        url: 'UpdateGlobalRow.htm',
                        type: 'POST',
                        data: {'id':id,'name':name,'rate':rate,'Desc':Desc},
                        success: function () {
                    	alert("Record Updated");        
                        }

                    });
                }
                z.appendChild(inp);
                document.getElementById("myTr" + index).appendChild(z);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = index;
                inp.setAttribute("type", "button");
                var t = document.createTextNode("Delete"); // Create a text node
                inp.appendChild(t);
                inp.setAttribute("id",element.id.localServicesId); 
                inp.setAttribute("name", "btnDelete");
                inp.setAttribute("value", "Delete");
                inp.onclick = function () {
                	var id=$(this).parent().parent().find('input').eq(0).attr('id');
                 	
                	$.ajax({
                        url: 'DeleteGlobalRow.htm',
                        type: 'POST',
                        data: id,
                        complete: function (data) {
                    		var dataJson = data.responseText;
                			var jsonResponse = JSON.parse(dataJson);
           
                            if(jsonResponse.No=="No")
                            	{
                            	alert("Cannot delete the column as consumer is associated with the servcie");
                            	}
                            if(jsonResponse.Yes=="Yes")
                            	{
                            	alert("Record Deleted");
                            	}
                        }

                    });
                }
                z.appendChild(inp);
                document.getElementById("myTr" + index).appendChild(z);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = element.globalServiceName;
             
                inp.setAttribute("type", "text");
                inp.setAttribute("readOnly","true");
                z.appendChild(inp);
                document.getElementById("myTr" + index).appendChild(z);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = element.ratePerPower;
                inp.setAttribute("type", "text");
             
                z.appendChild(inp); 
                document.getElementById("myTr" + index).appendChild(z);
                
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = element.globalDescription;
                inp.setAttribute("type", "text");
             
                z.appendChild(inp); 
                document.getElementById("myTr" + index).appendChild(z);
			}
			)
			
		}				
	}
	)});
})
</script>
</html>