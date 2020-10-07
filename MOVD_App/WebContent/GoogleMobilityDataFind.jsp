<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a Google Mobility Record</title>
</head>
<body>
	<form action="googlemobilitydatafind" method="post">
		<h1>Search for a Google Mobility Record by FipsCode</h1>
		<p>
			<label for="fipscode">JHCountyStat_FipsCode</label>
			<input id="fipscode" name="fipscode" value="${fn:escapeXml(param.FipsCode)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	<h1>Matching records</h1>
        <table border="1">
            <tr>
                <th>Synthetic_Mobility_PK</th>
                <th>Date</th>
                <th>Country</th>
                <th>Rec</th>
                <th>Grocery</th>
                <th>Parks</th>
                <th>Transit_Station</th>
                <th>Work</th>
                <th>Residential</th>
                <th>JHCountyStat_FipsCode</th>
            </tr>
            <c:forEach items="${FipsCode}" var="fipsCode" > 
                <tr>
      			    <td><c:out value="${fipsCode.getSyntheticMobilityPk()}" /></td>
      				<td><fmt:formatDate value="${fipsCode.getDate()}" pattern="yyyy-MM-dd"/></td>
                    <td><c:out value="${fipsCode.getCountry()}" /></td>
                    <td><c:out value="${fipsCode.getRec()}" /></td>
                    <td><c:out value="${fipsCode.getGrocery()}" /></td>
                    <td><c:out value="${fipsCode.getParks()}" /></td>
                    <td><c:out value="${fipsCode.getTransitStation()}" /></td>
                    <td><c:out value="${fipsCode.getWork()}" /></td>
                    <td><c:out value="${fipsCode.getResidential()}" /></td>
                    <td><c:out value="${fipsCode.getJhCountyStatFipsCode()}" /></td>
                </tr>
            </c:forEach>
       </table>
       <br></br>
       	 <table border="1">
	 	<tr>
	 		<th>Create Google Mobility Record</th>
        	<th>Update Google Mobility Record</th>
            <th>Delete Google Mobility Record</th>
            <th>Find Google Mobility Record</th>
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
        	<td><a href="googlemobilitydataupdate">Update</a></td>
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
