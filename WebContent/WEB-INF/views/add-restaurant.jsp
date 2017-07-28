<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<h1>Add new Restaurant!</h1>
<hr/>
<form:form modelAttribute="restaurant" servletRelativeAction="/add" method="POST">
    Name: <form:input path="name"/>
    <form:errors path="name"/><br/>
    Description: <form:input path="description"/>
    <form:errors path="description"/><br/>
    Price: <form:input path="price" type="number" step="0.01"/>
    <form:errors path="price"/><br/>
    Alelo: <form:checkbox path="aleloAccepted"/><br/>
    Location: <form:input path="location"/>
    <form:errors path="location"/><br/>
    Image: <form:input path="image"/>
    <form:errors path="image"/><br/>
    <form:button>Save</form:button>
</form:form>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>