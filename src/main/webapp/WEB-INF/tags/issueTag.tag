<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="issue" required="true" type="com.mate.trackq.model.Issue" %>

<div class="panel-body panel panel-info">
    <h4 class="text-info text-center"><span class="badge" STYLE="background: red">${issue.status}</span>
        issue number${issue.id}<span class="badge">${issue.assignee}</span></h4>

    <div style="margin-bottom: 15px">
        <textarea name="issueDescription" rows="4" class="form-control" content="issue_content"></textarea>
    </div>

</div>