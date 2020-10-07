<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a Google Mobility Record</title>
</head>
<body>
	<h1>Update Record</h1>
	<form action="googlemobilitydataupdate" method="post">
		<p>
			<label for="PrimaryKey">PrimaryKey</label>
			<input id="PrimaryKey" name="PrimaryKey" value="">
		</p>
		<p>
			<label for="Date">Date</label>
			<input id="Date" name="Date" value="">
		</p>
		<p>
			<label for="Country">Country</label>
			<input id="Country" name="Country" value="">
		</p>
		<p>
			<label for="Rec">Rec</label>
			<input id="Rec" name="Rec" value="">
		</p>
		<p>
			<label for="Grocery">Grocery</label>
			<input id="Grocery" name="Grocery" value="">
		</p>
		<p>
			<label for="Parks">Parks</label>
			<input id="Parks" name="Parks" value="">
		</p>
		<p>
			<label for="Transit_Station">Transit_Station</label>
			<input id="Transit_Station" name="Transit_Station" value="">
		</p>
		<p>
			<label for="Work">Work</label>
			<input id="Work" name="Work" value="">
		</p>
		<p>
			<label for="Residential">Residential</label>
			<input id="Residential" name="Residential" value="">
		</p>
		<p>
			<label for="JHCountyStat_FipsCode">JHCountyStat_FipsCode</label>
			<input id="JHCountyStat_FipsCode" name="JHCountyStat_FipsCode" value="">
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
	 		<th>Create Google Mobility Record</th>
        	<th>Find Google Mobility Record</th>
            <th>Delete Google Mobility Record</th>
            <th>Create Legislator</th>
        	<th>Update Legislator</th>
        	<th>Find Legislator</th>
            <th>Delete Legislator</th>
            <th>Create County</th>
            <th>Update County</th>
            <th>Find County</th>
            <th>Delete County</th>
            
        </tr>
        <tr>
        	<td><a href="googlemobilitydatacreate">Create</a></td>
        	<td><a href="googlemobilitydatafind">Find</a></td>
        	<td><a href="googlemobilitydatadelete">Delete</a></td>
        	<td><a href="legislatorscreate">Create</a></td>
        	<td><a href="legislatorsupdate">Update</a></td>
        	<td><a href="legislatorsread">Find</a></td>
        	<td><a href="legislatorsdelete">Delete</a></td>
            <td><a href="jhcountystatcreate">Create</a></td>
        	<td><a href="jhcountystatupdate">Update</a></td>
        	<td><a href="jhcountystatread">Find</a></td>
        	<td><a href="jhcountystatdelete">Delete</a></td>
        	
        </tr>
     </table>
</body>
</html>