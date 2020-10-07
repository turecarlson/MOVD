<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Legislators</title>
</head>
<body>
	<form action="legislatorsread" method="post">
	<h1>Search for Legislators by State</h1>
		<p>
			<label for="State">State</label>
			<input id="State" name="State" value="${fn:escapeXml(param.state)}">
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
                <th>LastName</th>
                <th>FirstName</th>
                <th>MiddleName</th>
                <th>Suffix</th>
                <th>Nickname</th>
                <th>FullName</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Type</th>
                <th>State</th>
                <th>District</th>
                <th>SenateClass</th>
                <th>Party</th>
            </tr>
            <c:forEach items="${legislators}" var="legislators" >
                <tr>
                    <td><c:out value="${legislators.getLastName()}" /></td>
                    <td><c:out value="${legislators.getFirstName()}" /></td>
                    <td><c:out value="${legislators.getMiddleName()}" /></td>
                    <td><c:out value="${legislators.getSuffix()}" /></td>
                    <td><c:out value="${legislators.getNickname()}" /></td>
                    <td><c:out value="${legislators.getFullName()}" /></td>
                 	<td><fmt:formatDate value="${legislators.getBirthday()}" pattern="yyyy-MM-dd"/></td>
                    <td><c:out value="${legislators.getGender()}" /></td>
                    <td><c:out value="${legislators.getType()}" /></td>
                    <td><c:out value="${legislators.getState()}" /></td>
                    <td><c:out value="${legislators.getDistrict()}" /></td>
                    <td><c:out value="${legislators.getSenateClass()}" /></td>
                    <td><c:out value="${legislators.getParty()}" /></td>
                </tr>
            </c:forEach>
       </table>
       <br/>
     <table border="1">
	 	<tr>
	 		<th>Create Legislator</th>
        	<th>Update Legislator</th>
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
        	<td><a href="legislatorsupdate">Update</a></td>
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