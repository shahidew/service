<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/26/2021
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Comment</title>
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
        <li><a href="<c:url value="/order/record"/>" class="text-white">Record Order</a></li>
        <li><a href="<c:url value="/management/login"/>" class="text-white">Login Manager</a></li>
    </ul>
</nav>

<form:form cssClass="p-3 m-3" action="record" modelAttribute="comment" method="post">
    <table class="table table-bordered table-striped text-info">
        <tr>
            <td>
                <label>Your Email :</label>
            </td>
            <td>
                <input name="emailAddress" id="emailAddress"/>
            </td>
        </tr>

        <tr>
            <td>
                <label>Expert's Email :</label>
            </td>
            <td>
                <input name="expertEmail" id="expertEmail"/>
            </td>
        </tr>

        <tr>
            <td>
                <label>Score:</label>
            </td>
            <td>
                <form:input path="score" id="score"/>
                <form:errors path="score" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td>
                <label>Text : </label>
            </td>
            <td>
                <form:input name="text" id="text" path="text"/>
                <form:errors path="text" cssClass="error"/>
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
