<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a Legislator</title>
</head>
<body>
<h1>Update Legislator</h1>
	<form action="legislatorsupdate" method="post">
		<p>
			<label for="LegislatorsKey">Legislator Id</label>
			<input id="LegislatorsKey" name="LegislatorsKey" value="">
		</p>
		<p>
			<label for="FirstName">FirstName</label>
			<input id="FirstName" name="FirstName" value="">
		</p>
		<p>
			<label for="LastName">LastName</label>
			<input id="LastName" name="LastName" value="">
		</p>
		<p>
			<label for="MiddleName">MiddleName</label>
			<input id="MiddleName" name="MiddleName" value="">
		</p>
		<p>
			<label for="Suffix">Suffix</label>
			<input id="Suffix" name="Suffix" value="">
		</p>
		<p>
			<label for="NickName">NickName</label>
			<input id="NickName" name="NickName" value="">
		</p>
		<p>
			<label for="FullName">FullName</label>
			<input id="FullName" name="FullName" value="">
		</p>
		<p>
			<label for="Birthday">Birthday</label>
			<input id="Birthday" name="Birthday" value="">
		</p>
		<p>
			<label for="Gender">Gender</label>
			<input id="Gender" name="Gender" value="">
		</p>
		<p>
			<label for="Type">Type</label>
			<input id="Type" name="Type" value="">
		</p>
		<p>
			<label for="State">State</label>
			<input id="State" name="State" value="">
		</p>
		<p>
			<label for="District">District</label>
			<input id="District" name="District" value="">
		</p>
		<p>
			<label for="SenateClass">SenateClass</label>
			<input id="SenateClass" name="SenateClass" value="">
		</p>
		<p>
			<label for="Party">Party</label>
			<input id="Party" name="Party" value="">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
 <table border="1">
	 	<tr>
	 		<th>Create Legislator</th>
        	<th>Find Legislator</th>
        	<th>Delete Legislator</th>
            <th>Create Google Mobility Record</th>
            <th>Update Google Mobility Record</th>
            <th>Find Google Mobility Record</th>
            <th>Delete Google Mobility Record</th>
            <th>Create County</th>
            <th>Update County</th>
            <th>Find County</th>
            <th>Delete County</th>
            
        </tr>
        <tr>
        	<td><a href="legislatorscreate">Create</a></td>
        	<td><a href="legislatorsread">Find</a></td>
        	<td><a href="legislatorsdelete">Delete</a></td>
        	<td><a href="googlemobilitydatacreate">Create</a></td>
        	<td><a href="googlemobilitydataupdate">Update</a></td>
        	<td><a href="googlemobilitydatafind">Find</a></td>
        	<td><a href="googlemobilitydatadelete">Delete</a></td>
        	<td><a href="jhcountystatcreate">Create</a></td>
        	<td><a href="jhcountystatupdate">Update</a></td>
        	<td><a href="jhcountystatread">Find</a></td>
        	<td><a href="jhcountystatdelete">Delete</a></td>
        </tr>
     </table>

</body>
</html>