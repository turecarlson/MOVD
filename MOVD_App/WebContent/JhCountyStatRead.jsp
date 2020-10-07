<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a County</title>
        </head>
<body>
<form action="jhcountystatread" method="post">
    <h1>Search for County Records by State</h1>
    <p>
        <label for="State">State</label>
        <input id="State" name="State" value="${fn:escapeXml(param.State)}">
    </p>
    <p>
        <input type="submit">
        <br/><br/><br/>
        <span id="successMessage"><b>${messages.success}</b></span>
    </p>
</form>
<h1>Matching Legislators</h1>
<table border="1">
    <tr>
        <th>FipsCode</th>
        <th>LastUpdate</th>
        <th>State</th>
        <th>CountyName</th>
        <th>CountyNameLong</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>NCHSUrbanization</th>
        <th>TotalPopulation</th>
    </tr>
    <c:forEach items="${JhCountyStat}" var="jhCountyStat" >
        <tr>
            <td><c:out value="${jhCountyStat.getFipsCode()}" /></td>
            <td><c:out value="${jhCountyStat.getLastUpdate()}" /></td>
            <td><c:out value="${jhCountyStat.getState()}" /></td>
            <td><c:out value="${jhCountyStat.getCountyName()}" /></td>
            <td><c:out value="${jhCountyStat.getCountyNameLong()}" /></td>
            <td><c:out value="${jhCountyStat.getLatitude()}" /></td>
            <td><c:out value="${jhCountyStat.getLongitude()}" /></td>
            <td><c:out value="${jhCountyStat.getNchsUrbanization()}" /></td>
            <td><c:out value="${jhCountyStat.getTotalPopulation()}" /></td>
        </tr>
    </c:forEach>
</table>
<br/>
	<table border="1">
		 	<tr>
		 	    <th>Create County</th>
	            <th>Update County</th>
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
	        	<td><a href="jhcountystatcreate">Create</a></td>
	        	<td><a href="jhcountystatupdate">Update</a></td>
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
