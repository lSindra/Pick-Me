<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elem" tagdir="/WEB-INF/tags/elements" %>

<link href="../../../resources/css/cards.css" rel="stylesheet">

<%--Restaurant Card Row--%>
<div class="row">

    <c:forEach var="restaurant" items="${restaurants}">

        <elem:card restaurant="${restaurant}"/>

    </c:forEach>

</div>

<%-- Modal --%>

<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content" style="min-height: 40%">
            <h1 style="margin-bottom: 10%; margin-top: 10%">Voters List</h1>
            <div id="voter-list">

            </div>
        </div>
    </div>
</div>

<script src="../../../resources/js/card.js"></script>
