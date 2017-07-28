<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="mainbody" fragment="true" %>
<%@attribute name="leftsidenav" fragment="true" %>
<%@attribute name="rightsidenav" fragment="true" %>
<html>
<body>

<div id="pageheader">
    <head>
        <title>Restaurant</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/general.css">
        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent">
                <div class="bg-inverse p-4">
                    <h4 class="text-white">Collapsed content</h4>
                    <span class="text-muted">Toggleable via the navbar brand.</span>
                </div>
            </div>
            <nav class="navbar navbar-inverse bg-inverse">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </nav>
        </div>
    </head>
    <jsp:invoke fragment="header"/>
</div>


<div id="body">
        <div class="container-fluid text-center">
            <div class="row content">
                <div class="col-sm-1 sidenav">
                    <jsp:invoke fragment="leftsidenav"/>
                </div>
                <div class="col-sm-1"></div>
                <div class="col-sm-8 text-left">
                    <jsp:invoke fragment="mainbody"/>
                </div>
                <div class="col-sm-1"></div>
                <div class="col-sm-1 sidenav">
                    <jsp:invoke fragment="rightsidenav"/>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/resources/jquery-3.2.1.slim.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/tether.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>
</div>


</body>
</html>