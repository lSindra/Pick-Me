<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elem" tagdir="/WEB-INF/tags/elements" %>

<link href="../../../resources/css/cards.css" rel="stylesheet">

<%--Buttons--%>
<div class="row" style="margin-bottom: 10px">
    <div class="<col>">
        <a class="btn-default" href="#" data-toggle="modal" data-target="#restaurantAddModal">New Restaurant</a>
    </div>
    <div class="col">
        <a class="btn-default" role="button" onClick="initOrRefreshCards()">Sort</a>
    </div>
</div>
<div class="col-md-6 ml-auto" style="margin-bottom: 10px">
    <input type="text" id="id_search_list" oninput="search()" class="form-control input-sm" placeholder="Search box">
</div>

<%--Restaurant Card Row--%>
<div class="row">

    <c:forEach var="restaurant" items="${restaurants}">

        <elem:card restaurant="${restaurant}"/>

    </c:forEach>

</div>

<script src="../../../resources/js/card.js"></script>
<script src="../../../resources/js/search.js"></script>