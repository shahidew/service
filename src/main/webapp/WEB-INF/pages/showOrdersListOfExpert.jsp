<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/26/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show OrderList Of Expert</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<style>
    #navbar .logo > a > span {
        text-decoration: none;
        color: rgb(116, 182, 144);
    }

    #navbar {
        position: sticky;
        top: 0px;
        display: flex;
        justify-content: space-between;
        align-items: baseline;
        padding: 0px 25px;
    }

    #navbar ul {
        text-decoration: none;
        display: flex;
        flex-direction: row-reverse;
    }

    #navbar ul a {
        text-decoration: none;
        padding: 1rem;
    }

    #navbar ul a:hover {
        text-decoration: none;
        background-color: rgb(56, 121, 83);
        border-radius: 5px;
    }

    .bg-dark {
        background-color: rgb(51, 51, 51);
    }

    .text-white {
        text-decoration: none;
        color: white;
    }

    body {
        background-image: linear-gradient(to left top, #17a2b8, #14abc4, #12b3d1, #11bcde, #12c5eb);
        height: 100vh;
    }

    #login .container #login-row #login-column .login-box {
        margin-top: 120px;
        max-width: 600px;
        height: 320px;
        border: 1px solid #9C9C9C;
        background-image: linear-gradient(to bottom, #aec1c3, #a9b5b7, #bcc5c6, #cfd5d5, #e3e5e5);
    }

    #login .container #login-row #login-column .login-box #login-form {
        padding: 20px;
    }

    #login .container #login-row #login-column .login-box #login-form #register-link {
        margin-top: -85px;
    }
</style>
<body>
<nav id="navbar" class="bg-dark">
    <h1 class="logo">
        <a class="text-white" href="<c:url value="/home/"/>">
            <span>HomeService</span>
        </a>
    </h1>

    <ul>
        <li><a href="<c:url value="/home/"/>" style="text-decoration: none;" class="text-white">Home</a></li>
        <li><a href="<c:url value="/expert/chooseService"/>" style="text-decoration: none;" class="text-white">Choose Service</a></li>
        <li><a href="<c:url value="/expert/showComment"/>" class="text-white">Show comment</a></li>
        <li><a href="<c:url value="/expert/showOrders"/>" class="text-white">Show Order</a></li>
    </ul>
</nav>

<%--<form:form action="addOffersToOrder" method="get">
    <input name="emailAddress" id="emailAddress" placeholder="Email Address">
    <button name="submit">Submit</button>
</form:form>--%>

<form:form cssClass="p-3 m-3" action="showOrders" method="post">
    <table class="table table-bordered table-striped text-info">
        <tr>
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
                <td>${orderDto.address}</td>
                <td>${orderDto.jobDescription}</td>
                <td>${orderDto.proposedPrice}</td>
                <td>${orderDto.subServiceDto}</td>
                <td>${orderDto.doneDate}</td>
                <td>${orderDto.orderDate}</td>
                <td>${orderDto.orderState}</td>
            </tr>
        </c:forEach>

        <tr>
            <td>
                <label>Order's Name:</label>
            </td>
            <td>
                <input path="orderName" id="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Base price : </label>
            </td>
            <td>
                <form:input name="basePrice" id="basePrice" path="basePrice"/>
                <form:errors path="basePrice" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Description :</label>
            </td>
            <td>
                <form:input name="description" id="description" path="description"/>
                <form:errors path="description" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td>
                <label>Super Service's Name :</label>
            </td>
            <td>
                <input name="superServiceName" id="superServiceName"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button name="submit">Submit</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
