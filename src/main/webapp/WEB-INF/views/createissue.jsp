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
    <h3 class="text-info text-center">Create Issue</h3>

    <form id="createIssue" class="form-horizontal" method="post" action="/create-issue">

        <label for="projectIssue">Select project to add issue</label>

        <div style="margin-bottom: 20px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
            <select id="projectIssue" name="project" class="form-control">
                <option value="1" selected="selected">one</option>
                <option value="2">two</option>
                <option value="3">three</option>
            </select>
        </div>

        <label for="issueType">Select issue type</label>

        <div style="margin-bottom: 20px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>
            <select id="issueType" name="issueType" class="form-control">
                <option value="1" selected="selected">they are dorks</option>
                <option value="2">they kick me =(</option>
                <option value="3">I like to fuck up</option>
            </select>
        </div>

        <label for="assignee">Select assignee</label>

        <div style="margin-bottom: 15px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <select id="assignee" name="assignee" class="form-control">
                <option value="1" selected="selected">John</option>
                <option value="2">Jack</option>
                <option value="3">July</option>
            </select>
        </div>

        <div class="col-sm-12 controls text-center">
            <button type="submit" id="createissue" class="btn btn-primary btn-md ">Invite</button>
        </div>
    </form>

</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>