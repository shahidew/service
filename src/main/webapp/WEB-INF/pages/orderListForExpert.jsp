<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/19/2021
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order List</title>
</head>
<body>
<form:form action="/orders/showOrderListForExpert" method="post">
    <table>
        <tr>
            <th>Id</th>
            <th>Proposed Price</th>
            <th>Job Description</th>
            <th>Order Date</th>
            <th>Job Description</th>
            <th>Done Date</th>
            <th>Address</th>
            <th>UnderService</th>
            <th>Order State</th>
            <th>Offers</th>
            <th>Customer</th>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.proposedPrice}</td>
                <td>${order.jobDescription}</td>
                <td>${order.orderDate}</td>
                <td>${order.doneDate}</td>
                <td>${order.address}</td>
                <td>${order.subServiceDto}</td>
                <td>${order.orderState}</td>
                <td>${order.offerDtos}</td>
                <td>${order.customerDto}</td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>
