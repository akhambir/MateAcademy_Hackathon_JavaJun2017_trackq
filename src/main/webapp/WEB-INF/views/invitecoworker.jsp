<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create Issue</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <t:navbar basic="projects"/>
</div>

<div style="margin-top:150px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 panel-body panel panel-default">
    <h3 class="text-info text-center">Invite your colleague</h3>
    <form id="inviteCoworker" class="form-horizontal" method="post" action="/invite-coworker">

        <label for="projects">Select projects to add coworker</label>

        <div style="margin-bottom: 20px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
            <select id="projects" name="projects" class="form-control">
                <option value="1" selected="selected">one</option>
                <option value="2">two</option>
                <option value="3">three</option>
            </select>
        </div>

        <label for="searchFor">Enter coworker email</label>

        <div style="margin-bottom: 15px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="searchFor" type="text" name="searchFor" required
                   placeholder="coworker email" class="form-control">
        </div>

        <div class="col-sm-12 controls text-center">
            <button type="submit" class="btn btn-primary btn-md ">Invite</button>
        </div>
    </form>
</div>


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>