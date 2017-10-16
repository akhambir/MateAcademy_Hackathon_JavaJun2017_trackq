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
<%--todo inject project entity--%>
<div style="margin-top:100px;">
    <div class="row container-fluid">

        <div class="col-lg-3 col-sm-6 text-center panel-body panel"><h3 class="text-warning">New</h3>
            <c:forEach items="${project.getIssues().stream()
            .filter(issue -> issue.getStatus().getName().equals('new'))}" var="issue">
                <t:issueTag issue="issue"/>
            </c:forEach>
        </div>

        <div class="col-lg-3 col-sm-6 text-center panel-body panel"><h3 class="text-primary">To check</h3>
            <c:forEach items="${project.getIssues().stream()
            .filter(issue -> issue.getStatus().getName().equals('to check'))}" var="issue">
                <t:issueTag issue="issue"/>
            </c:forEach>
        </div>

        <div class="col-lg-3 col-sm-6 text-center panel-body panel"><h3 class="text-info">In Development</h3>
            <c:forEach items="${project.getIssues().stream()
            .filter(issue -> issue.getStatus().getName().equals('in development'))}" var="issue">
                <t:issueTag issue="issue"/>
            </c:forEach>
        </div>

        <div class="col-lg-3 col-sm-6 text-center panel-body panel"><h3 class="text-success">Done</h3>
            <c:forEach items="${project.getIssues().stream()
            .filter(issue -> issue.getStatus().getName().equals('done'))}" var="issue">
                <t:issueTag issue="issue"/>
            </c:forEach>
        </div>

    </div>
</div>


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
