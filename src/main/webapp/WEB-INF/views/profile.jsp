<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <t:navbar basic="login"/>
</div>

<div style="margin-top:100px;"
     class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 panel-body panel panel-default">
    <div class="container-fluid text-center">
        <div class="row">
            <div class="user-image">
                <img src="http://www.gravatar.com/avatar/2ab7b2009d27ec37bffee791819a090c?s=100&d=mm&r=g"
                     class="img-circle">
            </div>
            <div class="user-info-block">
                <div class="user-heading">

                    <h3>${user.username}</h3>
                </div>
                <div class="row">
                    <a href="#" class="btn btn-info">Edit profile</a>

                    <a href="#" class="btn btn-info">Upload photo</a>

                    <a href="#" class="btn btn-info">Check my tasks</a>

                    <a href="#" class="btn btn-info">Check my projects</a>
                </div>

                <div style="margin-top: 20px">
                    <label for="userColor">Select your color</label> <input id="userColor" type="color" name="userColor">
                </div>
            </div>
        </div>
    </div>
</div>


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
