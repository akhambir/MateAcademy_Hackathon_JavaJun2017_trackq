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
<br>
<br>
<br>

<meta name="viewport" content="width=device-width, initial-scale=1">

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3 col-sm-4 visible-md visible-sm visible-lg">
            <img src="${pageContext.request.contextPath}/resources/img/analyze.png" height="250">
        </div>
        <div class="col-md-6 col-sm-5 col-xs-12 text-center">
            <h1 class="text-info">TrackQ</h1>
            <h3>Welcome to our project tracking system</h3>
            <h3>We wish you good luck whits this tool.</h3>
        </div>
        <div class="col-md-3 col-sm-3 visible-md visible-sm visible-lg">
            <img src="${pageContext.request.contextPath}/resources/img/Project%20Tracking.png" height="250">
        </div>
    </div>
</div>

<br>

<div class="container-fluid">
    <div class="row">
        <div class="bg-info col-xs-12 col-sm-3">
            <h4>Do something </h4>
            <button class="btn btn-primary">Some button</button>
            <button class="btn btn-primary">Some button</button>
            <h4>Do something else</h4>
            <button class="btn btn-primary">Some button</button>
            <button class="btn btn-primary">Some button</button>
        </div>
        <div class="col-xs-12 col-sm-9">
            <div class="row">
                <h2 class="text-danger">Some projects</h2>
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
