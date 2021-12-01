<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/26/2021
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Comments</title>
</head>
<body>
<form:form cssClass="m-5 p-5 text-center" cssStyle="width: 1200px" action="showComment" method="get">
    <table class="table table-striped table-success table-hover">
        <tr>
            <th>Score</th>
            <th>Text</th>
        </tr>
        <c:forEach items="${comments}" var="comment">
            <tr>
                <td>${comment.score}</td>
                <td>${comment.text}</td>
            </tr>
        </c:forEach>
    </table>
</form:form>


</body>
</html>
