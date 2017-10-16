<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="issue" required="true" type="com.mate.trackq.model.Issue" %>

<div class="panel-body panel panel-info">

    <div class="panel-body panel panel-info">
        <h4 class="text-info text-center"><span class="badge" STYLE="background: red">${issue.status}</span>
            ${issue.issueName}<span class="badge">${issue.assignee}</span></h4>
        <br>
        <form action="\updateIssue" method="post">
            <input type="number" hidden value="${issue.id}" name="issueId">
            <div style="margin-bottom: 15px">
            <textarea id="issueDescription" name="issueDescription" rows="6" class="form-control text-center"
                      content="issue_content"></textarea>
            </div>
            <div class="form-inline">
                <select class="form-control bg-warning" name="status">
                    <c:forEach items="issueStatuses" var="status">
                        <option value="${status}" selected="selected">${status.name}</option>
                    </c:forEach>
                </select>
                <button type="submit" name="command" value="update" class="btn btn-info">
                    <span class="glyphicon glyphicon-refresh"></span></button>
            </div>
        </form>

    </div>

</div>