<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/26/2021
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <link href="<c:url value ="/static/css/managerPageStyle.css"/>" rel="stylesheet"/>
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

    #contact {
        position: absolute;
        top: 750px;
        right: 70px;
        height: 300px;
        width: 550px;
        border: hidden;
    }

    #contacts {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-between;
        align-items: flex-end;
        align-content: center;
    }

    h5 {
        font-family: Serif, serif;
        font-size: x-large;
        letter-spacing: 1px;
        tab-size: 100px;
        text-align: center;
        color: #0cbaba;
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
      <%--  <li><a href="<c:url value="/subService/addExpert"/>" class="text-white">Specialist appointment to Service</a></li>--%>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/"/>"><span class="glyphicon glyphicon-log-in" style="text-decoration: none;"></span>
            Login Manger</a></li>
    </ul>
</nav>


<img src="<c:url value="images/download.png"/>" alt="homeservice"/>
</body>
</html>
