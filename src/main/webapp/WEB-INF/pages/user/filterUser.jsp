<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/25/2021
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter Users</title>
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
        background-color: #b1b1b1;
    }

    h5 {
        font-family: Serif, serif;
        font-size: x-large;
        letter-spacing: 1px;
        tab-size: 100px;
        text-align: center;
        color: #0cbaba;
    }

    .error {
        color: red;
        font-weight: bolder;
    }

</style>
<body>
<nav id="navbar" class="bg-dark">
    <h1 class="logo">
        <a class="text-white" href="<c:url value="/"/>">
            <span>HomeService</span>
        </a>
    </h1>

    <ul>
        <li><a href="<c:url value="/"/>" style="text-decoration: none;" class="text-white">Home</a></li>
        <li><a href="<c:url value="/management/managerPage"/>" class="text-white">Manager Page</a></li>
        <li><a href="<c:url value="/expert/register"/>" class="text-white">Register as Expert</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/management/login"/>"><span class="glyphicon glyphicon-log-in" style="text-decoration: none;"></span>
            Login Manger</a></li>
    </ul>
</nav>

<form:form cssClass="m-5 p-5 text-center" cssStyle="width:1200px" modelAttribute="fuDto" action="/user/filter" method="post">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>
                <label>
                    <form:input name="fullName" placeHolder="Full Name" path="fullName"/>
                </label>
            </td>
            <td>
                <label>
                    <form:input type="email" name="emailAddress" placeHolder="Email" path="emailAddress"/>
                </label>
            </td>
            <td>
                <label>
                    <form:input name="credit" placeHolder="Credit" path="credit"/>
                </label>
            </td>
            <td>
                <label for="userRole">select:</label>
                <form:select name="userRole" id="userRole" path="userRole">
                    <option value="Expert">Expert</option>
                    <option value="Customer">Customer</option>
                </form:select>

            </td>
            <td>
                <label>
                    <form:input name="subService" placeHolder="Filed:" path="subServiceDto"/>
                </label>
            </td>
            <td>
                <input type="submit" value="search">
            </td>
        </tr>
        <tr>
            <th>Id</th>
            <th>FullName</th>
            <th>EmailAddress</th>
            <th>Date</th>
            <th>Credit</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${userDtos}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.fullName}</td>
                <td>${user.emailAddress}</td>
                <td>${user.date}</td>
                <td>${user.credit}</td>
                <td>${user.userRole}</td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>
