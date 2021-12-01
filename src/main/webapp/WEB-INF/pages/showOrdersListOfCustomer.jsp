<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/26/2021
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show OrderList Of Expert</title>
</head>
<body>
<form:form action="showOrders" method="get">
    <table>
        <tr>
            <th>Id</th>
            <th>Address</th>
            <th>Job Description</th>
            <th>Proposed Price</th>
            <th>SubService</th>
            <th>Done Date</th>
            <th>Order Date</th>
            <th>Order Status</th>

        </tr>
        <c:forEach items="${orders}" var="orderDto">
            <tr>
                <td>${orderDto.id}</td>
                <td>${orderDto.address}</td>
                <td>${orderDto.jobDescription}</td>
                <td>${orderDto.proposedPrice}</td>
                <td>${orderDto.subServiceDto}</td>
                <td>${orderDto.doneDate}</td>
                <td>${orderDto.orderDate}</td>
                <td>${orderDto.orderState}</td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>
