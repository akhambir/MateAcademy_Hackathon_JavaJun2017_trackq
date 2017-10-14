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

<div class="container">
    <div id="loginbox" style="margin-top:150px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
                <div style="float:right; font-size: 80%; position: relative; top:-20px"><a
                        href="/forgot">Forgot password?</a></div>
            </div>

            <div style="padding-top:30px" class="panel-body">

                <%--@elvariable id="user" type="com.mate.trackq.model.User"--%>
                <form name="login" action="<c:url value="/login"/>" id="loginform" method="post" >

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="username" class="form-control"
                                      placeholder="username" id="login-username" type="text"/>
                    </div>

                    <div style="margin-bottom: 5px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" name="password" class="form-control" id="login-password"/>
                    </div>

                    <div class="col-sm-12 controls text-center">
                        <button type="submit" id="btn-login" class="btn btn-success btn-lg ">Login</button>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>

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
