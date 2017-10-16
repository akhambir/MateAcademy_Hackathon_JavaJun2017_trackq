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

<div style="margin-top:150px;">
    <h4 class="text-danger text-center">My projects</h4>
    <br>
    <div class="center-block">
        <table class="table-responsive container-fluid">
            <thead>
            <tr>
                <th class="text-center">Project name</th>
                <th class="text-center">Issues in total</th>
                <th class="text-center">My issues</th>
                <th class="text-center">status</th>
                <th class="text-center">actions</th>
            </tr>
            </thead>
            <tbody>
            <%--todo inject projects and user--%>
            <c:forEach items="projects" var="project">
            <tr>
                <td>
                    <input value="${project.getpName()}" readonly>
                </td>
                <td>
                    <input value="${project.getIssues().size()}" type="number" step="1"  readonly>
                </td>
                <td>
                    <input value="${project.getIssues().stream().filter(issue -> issue.getAssignee().equals(user)).count()}"
                           type="number" step="1" readonly>
                </td>
                <td>
                    <input value="${project.getStatus()}" readonly>
                </td>

                <td>
                    <form action="/project" method="post">
                        <input hidden value="${project.getId()}" name="projectId">
                    <button class="btn-link" value="checkout" name="command"><span
                            class="glyphicon glyphicon-refresh"></span>
                        checkout
                    </button>
                    </form>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
