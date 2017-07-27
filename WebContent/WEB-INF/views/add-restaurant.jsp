<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Add new Restaurant!</h1>
<hr/>
<form:form modelAttribute="restaurant" servletRelativeAction="/add" method="POST">
    Name: <form:input path="name"/>
    <form:errors path="name"/><br/>
    Price: <form:input path="price" type="number" step="0.01"/>
    <form:errors path="price"/><br/>
    Alelo: <form:checkbox path="aleloAccepted"/><br/>
    Location: <form:input path="location"/>
    <form:errors path="location"/><br/>
    Image: <form:input path="image"/>
    <form:errors path="image"/><br/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>