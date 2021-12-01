<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/26/2021
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RecordSubService</title>
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
        <li><a href="<c:url value="/user/filter"/>" style="text-decoration: none;" class="text-white">Filter Users</a>
        </li>
        <li><a href="<c:url value="/superService/record"/>" class="text-white">Definition SuperService</a></li>
        <li><a href="<c:url value="/subService/record"/>" class="text-white">Definition SubService</a></li>
        <%--<li><a href="<c:url value="/subService/addExpert"/>" class="text-white">Specialist appointment to Service</a></li>--%>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/"/>"><span class="glyphicon glyphicon-log-in" style="text-decoration: none;"></span>
            Login Manger</a></li>
    </ul>
</nav>


<form:form cssClass="p-3 m-3" action="record" modelAttribute="subService" method="post">
    <table class="table table-bordered table-striped text-info">

        <tr>
            <th>Name</th>
            <th>SubServices</th>
        </tr>
        <c:forEach items="${superServices}" var="superService">
            <tr>
                <td>${superService.name}</td>
                <td>${superService.subServiceDtos}</td>
            </tr>
        </c:forEach>


        <tr>
            <td>
                <label>Name:</label>
            </td>
            <td>
                <form:input path="name" id="name"/>
                <form:errors path="name" cssClass="error"/>
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
      <%--  <tr>
            <td>
                <label>Super Service</label>
            </td>

            <td>
                <form:select path="superServiceDto" id="superServiceDto" name="superServiceDto" items="${superServices}"/>
            </td>
            <td>
                <form:errors path="superServiceDto" cssClass="error"/>
            </td>
        </tr>--%>
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
