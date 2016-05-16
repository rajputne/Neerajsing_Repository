<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
   
     
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Local Energy Dashboard</title>
</head>
<body>
<div id="main">
		<div id="site_content">
<h2>Welcome ${localenergyvendor.localEnergyVendorName}</h2>
<br>
<div id="GetServices"></div>
<form name="" action="AddServices.htm">
<input type="text" name="txtNumb" id="txtNumb"></input><button onClick="" id="AddNumberOfServices" type="button">Add Services</button><br>
<input type="hidden" value="${localenergyvendor.localEnergyVendorId}" name="localId" id="localId"/>
<button onClick="" id="GetLocalServices" type="button">Get Local Services</button>
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
		s = '<table border=1><tr><td>Service Name </td><td>Rate</td><td>Zip</td><td>Description</td><td>Battery</td></tr>';
		for (var i = 0; i < param; i++) {
			s += '<tr><td><input maxlength="20" type="text" name="levServName' + i + '"></td>';
			s += '<td><input maxlength="4"  type="text" name="rate' + i + '"></td>';
			s += '<td><input maxlenghth="5" type="text" name="zip' + i + '"></td>';
			s += '<td><textarea maxlenghth="100" rows="4" cols="50" name="levServDesc' + i + '"></textarea></td>';
			s += '<td><input maxlength="3" type="text" name="Nob' + i + '"></td>';
			document.getElementById("screens").innerHTML = s;
		}
		s += '</table>';
		s += '<button type="Submit" name="action" value="Submit">Add Your Services</button>';
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
	
	
	
	$('#GetLocalServices').click(function() {
		
	   
	var hv = $('#localId').val();
		
		
		$('#GetServices').html("");
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		url : "GetNumberOfService.htm",
		data:hv,		
		complete : function(data) {		
			var dataJson = data.responseText;
			var jsonResponse = JSON.parse(dataJson);
			var x = document.createElement("TABLE");
			x.setAttribute("id", "myTable");
			document.getElementById("GetServices").appendChild(x);
			var y = document.createElement("TR");
			y.setAttribute("id", "myTr");
			
			document.getElementById("myTable").appendChild(y);
			var z = document.createElement("TH");
			var t = document.createTextNode("Save");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z = document.createElement("TH");
			var t = document.createTextNode("Delete");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z = document.createElement("TH");
			var t = document.createTextNode("LocalEnergyServiceName");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z = document.createElement("TH");
			var t = document.createTextNode("Rate");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z = document.createElement("TH");
			var t = document.createTextNode("LocalEnergyServiceDescription");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			document.getElementById("myTr").appendChild(z);
			var z = document.createElement("TH");
			var t = document.createTextNode("Local Batteries");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			document.getElementById("myTr").appendChild(z);
			var z = document.createElement("TH");
			var t = document.createTextNode("Zip");
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			$.each(jsonResponse.LocalServices, function(index, element) {
				var y = document.createElement("TR");
                y.setAttribute("id", "myTr" + index);
                document.getElementById("myTable").appendChild(y);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = index;
                inp.setAttribute("type", "button");
                var t = document.createTextNode("Save"); // Create a text node
                inp.appendChild(t);
                inp.setAttribute("id",element.id.localServicesId); 
                inp.setAttribute("name", "btnSave");
                inp.setAttribute("value", "Save");
                inp.onclick = function () {
                	var id=$(this).parent().parent().find('input').eq(0).attr('id');
                	var name = $(this).parent().parent().find('input').eq(2).val();
                	var rate = $(this).parent().parent().find('input').eq(3).val();
                	var localDesc = $(this).parent().parent().find('input').eq(4).val();
                	var localBatteries = $(this).parent().parent().find('input').eq(5).val();
                	var zip = $(this).parent().parent().find('input').eq(6).val();
                	
                	$.ajax({
                        url: 'UpdateRow.htm',
                        type: 'POST',
                        data: {'id':id,'name':name,'rate':rate,'localDesc':localDesc,'localBatteries':localBatteries,'zip':zip},
                        success: function () {
                            alert("Record with "+name+" is updated");
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
                        url: 'DeleteLocalRow.htm',
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
                            	alert("Record Deleted please press Get Local Service to refresh the Table");
                            	}
                        }

                    });
                }
                z.appendChild(inp);
                document.getElementById("myTr" + index).appendChild(z);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = element.localEnergyServiceName;
             
                inp.setAttribute("type", "text");
                inp.setAttribute("readOnly","true");
                z.appendChild(inp);
                document.getElementById("myTr" + index).appendChild(z);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = element.rate;
                inp.setAttribute("type", "text");
             
                z.appendChild(inp); 
                document.getElementById("myTr" + index).appendChild(z);
                
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");
                inp.value = element.localEnergyServiceDescription;
                inp.setAttribute("type", "text");
             
                z.appendChild(inp); 
                document.getElementById("myTr" + index).appendChild(z);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");        
                inp.value = element.numberOfBatteriesInZip;
                inp.setAttribute("type", "text");
                
                z.appendChild(inp); 
                document.getElementById("myTr" + index).appendChild(z);
                
                var z = document.createElement("TD");
                var inp = document.createElement("INPUT");        
                inp.value = element.zip;
                inp.setAttribute("type", "text");
              
                z.appendChild(inp); 
                document.getElementById("myTr" + index).appendChild(z);
				
			}
			)
			
		}				
	}
	) });
})
</script>
</html>