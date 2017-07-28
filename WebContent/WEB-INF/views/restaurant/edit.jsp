<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Edit Trainings!</h1>
<hr/>
<form:form modelAttribute="restaurant" servletRelativeAction="/edit" method="POST">
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
</body>
</html>