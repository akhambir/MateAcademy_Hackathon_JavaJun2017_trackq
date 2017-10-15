<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sign up</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <t:navbar basic="signup"/>
</div>


<div class="container">
    <div id="signupbox" style="margin-top:150px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title">Sign up on TrackQ.com</div>
            </div>
            <div class="panel-body">

                <form id="signup" method="post" action="/signup">
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input form="signup" class="form-control" placeholder="Email" id="email" type="email"/>
                    </div>

                    <div style="margin-bottom: 15px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input form="signup" class="form-control" placeholder="Username" id="login" type="text"/>
                    </div>

                    <div style="margin-bottom: 15px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input form="signup" class="form-control passwordCheck" placeholder="Password" id="password1" type="password"/>
                    </div>

                    <div style="margin-bottom: 15px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input form="signup" class="form-control passwordCheck" placeholder="Confirm password" id="password2" type="password"/>
                    </div>

                    <div class="col-sm-12 controls text-center">
                        <button form="signup" id="submitForm" type="submit" class="btn btn-success btn-lg">Login</button>
                    </div>
                </form>

            </div>
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/signup.js"></script>
</body>
</html>
