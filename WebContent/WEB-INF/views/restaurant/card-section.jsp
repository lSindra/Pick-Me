<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elem" tagdir="/WEB-INF/tags/elements" %>

<%--Buttons--%>
<div class="row">
    <a class="nav-link" href="#" data-toggle="modal" data-target="#restaurantAddModal">New Restaurant</a>
    <a class="nav-link" role="button" onClick="window.location.reload()">Sort</a>
    <input type="text" id="id_search_list" class="form-control input-sm" placeholder="Search box">
</div>

<%--Restaurant Card Row--%>
<div class="row">

    <c:forEach var="restaurant" items="${restaurants}">

        <elem:card restaurant="${restaurant}"/>

    </c:forEach>

</div>
