<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create a JhCountyStat Entry</title>
</head>
<body>
<h1>Create County</h1>
<form action="jhcountystatcreate" method="post">
    <p>
        <label for="fipscode">FipsCode</label>
        <input id="fipscode" name="fipscode" value="">
    </p>
    <p>
        <label for="lastupdate">LastUpdate</label>
        <input id="lastupdate" name="lastupdate" value="">
    </p>
    <p>
        <label for="state">State</label>
        <input id="state" name="state" value="">
    </p>
    <p>
        <label for="countyname">CountyName</label>
        <input id="countyname" name="countyname" value="">
    </p>
    <p>
        <label for="countynamelong">CountyName(Long)</label>
        <input id="countynamelong" name="countynamelong" value="">
    </p>
    <p>
        <label for="latitude">Latitude</label>
        <input id="latitude" name="latitude" value="">
    </p>
    <p>
        <label for="longitude">Longitude</label>
        <input id="longitude" name="countyname" value="">
    </p>
    <p>
        <label for="nchsurbanization">NCHS Urbanization Class</label>
        <input id="nchsurbanization" name="nchsurbanization" value="">
    </p>
    <p>
        <label for="totalpopulation">Total Population</label>
        <input id="totalpopulation" name="totalpopulation" value="">
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
		 	    <th>Update County</th>
		 	    <th>Find County</th>
	            <th>Delete County</th>
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
	        	<td><a href="jhcountystatupdate">Update</a></td>
	        	<td><a href="jhcountystatread">Find</a></td>
	        	<td><a href="jhcountystatdelete">Delete</a></td>
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