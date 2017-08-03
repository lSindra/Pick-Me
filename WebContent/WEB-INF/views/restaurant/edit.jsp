<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/elements" %>

<t:header>
        <jsp:attribute name="navButtons">
        </jsp:attribute>
</t:header>

<html>
<body>
<hr/>
<form:form modelAttribute="restaurant" servletRelativeAction="/restaurant/edit" method="POST">
    <form:input type="hidden" value="${restaurant.id}" path="id"/>
    Name: <form:input value="${restaurant.name}" path="name"/>
    <form:errors path="name"/><br/>
    Price: <form:input value="${restaurant.price}" path="price" step="0.01"/>
    <form:errors path="price"/><br/>
    Alelo: <form:checkbox path="aleloAccepted" value="${restaurant.aleloAccepted}"/>
    <form:errors path="aleloAccepted"/><br/>
    Location: <form:input path="location" value="${restaurant.location}"/>
    <form:errors path="location"/><br/>
    Image: <form:input path="image" value="${restaurant.image}"/>
    <form:errors path="image"/><br/>
    <form:button>Save</form:button>
</form:form>

<!-- Bootstrap core JavaScript -->
<script src="../../../resources/vendor/jquery/jquery.min.js"></script>
<script src="../../../resources/vendor/tether/tether.min.js"></script>
<script src="../../../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="../../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Google Maps API -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqAZ-i7xPeqanrDkGPNvaTAi9Lnvv2C2g&sensor=false"></script>

<!-- Custom scripts for this template -->
<script src="../../../resources/js/grayscale.min.js"></script>

</body>
</html>