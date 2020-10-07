<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Delete a County</title>
</head>
<body>
<h1>${messages.title}</h1>
<form action="jhcountystatdelete" method="post">
    <p>
    <div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
        <label for="fipscode">FipsCode</label>
        <input id="fipscode" name="fipscode" value="${fn:escapeXml(param.fipscode)}">
    </div>
    </p>
    <p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<input type="submit">
			</span>
    </p>
</form>
<br/><br/>
<table border="1">
		 	<tr>
		 	    <th>Create County</th>
	            <th>Update County</th>
	            <th>Find County</th>
	        	<th>Create Google Mobility Record</th>	           
	            <th>Update Google Mobility Record</th>
	            <th>Find Google Mobility Record</th>
	            <th>Delete Google Mobility Record</th>
	            <th>Create Legislator</th>
	        	<th>Update Legislator</th>
	        	<th>Find Legislator</th>
	            <th>Delete Legislator</th>
	        </tr>
	        <tr>
	        	<td><a href="jhcountystatcreate">Create</a></td>
	        	<td><a href="jhcountystatupdate">Update</a></td>
	        	<td><a href="jhcountystatread">Find</a></td>
	        	<td><a href="googlemobilitydatacreate">Create</a></td>
	        	<td><a href="googlemobilitydataupdate">Update</a></td>
	        	<td><a href="googlemobilitydatafind">Find</a></td>
	        	<td><a href="googlemobilitydatadelete">Delete</a></td>
	        	<td><a href="legislatorscreate">Create</a></td>
	        	<td><a href="legislatorsupdate">Update</a></td>
	        	<td><a href="legislatorsread">Find</a></td>
	        	<td><a href="legislatorsdelete">Delete</a></td>
	        </tr>
       </table>

</body>
</html>