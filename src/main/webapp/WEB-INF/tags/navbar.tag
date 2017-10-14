<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="basic" required="true"%>

<div class="container">
    <nav class="navbar navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="glyphicon glyphicon-align-justify"></span>
                </button>
                <a class="navbar-brand" href="/index">TrackQ.com</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">

                    <li <c:if test="${basic eq login}">class="active"</c:if>>
                        <a href="/login"><span class="glyphicon glyphicon-log-in"></span>Signin</a></li>

                    <li <c:if test="${basic eq signup}">class="active"</c:if>>
                    <a href="/signup"> <span class="glyphicon glyphicon-ok"></span>Signup</a></li>

                    <li <c:if test="${basic eq logout}">class="active"</c:if>>
                        <a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>

                    <li <c:if test="${basic eq profile}">class="active"</c:if>>
                        <a href="/profile"><span class="glyphicon glyphicon-user"></span>My profile</a></li>

                    <li <c:if test="${basic eq projects}">class="active"</c:if>>
                        <a href="/projects"><span class="glyphicon glyphicon-list-alt"></span>My projects</a></li>

                </ul>
            </div>
        </div>
    </nav>
</div>