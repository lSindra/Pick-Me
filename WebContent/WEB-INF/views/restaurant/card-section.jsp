<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elem" tagdir="/WEB-INF/tags/elements" %>

<link href="../../../resources/css/cards.css" rel="stylesheet">

<%--Restaurant Card Row--%>
<div class="row">

    <c:forEach var="restaurant" items="${restaurants}">

        <elem:card restaurant="${restaurant}"/>

    </c:forEach>

</div>

<script src="../../../resources/js/card.js"></script>
