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

                <%--@elvariable id="user" type="com.mate.trackq.model.User"--%>
                <spring:form id="signup" modelAttribute="user" method="post" action="/signup"
                             onsubmit="return validateForm()">

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <spring:input path="email" class="form-control"
                                      placeholder="username" type="email"/>
                    </div>

                    <div style="margin-bottom: 15px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <spring:input path="username" class="form-control"
                                      placeholder="username" id="login" type="text"/>
                    </div>

                    <div style="margin-bottom: 15px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <spring:input path="password" class="form-control" id="password1" type="password"/>
                    </div>

                    <div style="margin-bottom: 15px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input class="form-control" id="password2" type="password"/>
                    </div>

                    <div class="col-sm-12 controls text-center">
                        <button type="submit" class="btn btn-success btn-lg ">Login</button>
                    </div>

                    <input type="hidden" name="projectId" value="${projectId}"></p>
                </spring:form>

            </div>
        </div>

    </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script>
    function validateForm() {
        const email = document.forms["signup"]["email"].value;
        const login = document.forms["signup"]["login"].value;
        const password1 = document.forms["signup"]["password1"].value;
        const password2 = document.forms["signup"]["password2"].value;

        if (password1!==password2) {
            document.getElementById("password1").classList.add('alert-danger');
            document.getElementById("password2").classList.add('alert-danger');
            return false;
        }

        const string = "sample1";
        const emailRegex = new RegExp("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        const loginRegex = new RegExp("^[a-zA-Zа-яА-Я0-9@.ЇїІіґҐ_]{5,32}$");
        if (!emailRegex.test(email)) {
            document.getElementById("email").classList.add('alert-danger');
            return false;
        }
        if (!loginRegex.test(login)) {
            document.getElementById("login").classList.add('alert-danger');
            return false;
        }
    }
</script>
</body>
</html>
