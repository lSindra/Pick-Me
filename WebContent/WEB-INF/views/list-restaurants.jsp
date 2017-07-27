<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of restaurants</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Accepts ALELO</th>
        <th>Location</th>
    </tr>
    <c:forEach var="restaurant" items="${restaurants}">

        <tr>
            <td>${restaurant.name}</td>
            <td>${restaurant.price}</td>
            <td>${restaurant.aleloAccepted}</td>
            <td>${restaurant.location}</td>
            <td><input type="button" value="Remove" onclick="location.href='delete?id=${restaurant.id}'"></td>
            <td><input type="button" value="Edit" onclick="location.href='edit?id=${restaurant.id}'"></td>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add" onclick="location.href='add'">
</body>
</html>