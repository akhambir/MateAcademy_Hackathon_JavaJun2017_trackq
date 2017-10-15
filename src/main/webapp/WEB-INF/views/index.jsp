<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>welcome</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <t:navbar basic="index"/>
</div>
<div>
    <h1 class="text-info text-center" style="margin-bottom: 35px;margin-top: 35px">Welcome to TrackQ</h1>
</div>
<div class="container-fluid">

    <div class="col-md-4 text-center panel-body panel panel-success">
        <div><h2 class="text-success">Create your project</h2></div>
        <div><img src="${pageContext.request.contextPath}/resources/img/make-icon_398798.png" class="img-thumbnail" style="height: 150px"></div>
        <div style="margin-top: 10px"><a href="/createProject" class="btn btn-success">Create Project</a></div>
    </div>

    <div class="col-md-4 text-center panel-body panel panel-info">
        <h2 class="text-info">Check project progress</h2>
        <div><img src="${pageContext.request.contextPath}/resources/img/Custom-Icon-Design-Pretty-Office-9-Open-file.ico" class="img-thumbnail" style="height: 150px"></div>
        <div style="margin-top: 10px"><a href="/projects" class="btn btn-info">Check existing projects</a></div>
    </div>

    <div class="col-md-4 text-center panel-body panel panel-primary">
        <h2 class="text-primary">Inspect your tasks</h2>
        <div><img src="${pageContext.request.contextPath}/resources/img/canva-business-people-design-person-icon--MAB2sqFKHu0.webp" class="img-thumbnail" style="height: 150px"></div>
        <div style="margin-top: 10px"><a href="/profile" class="btn btn-primary">Check your issues</a></div>
    </div>

</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
