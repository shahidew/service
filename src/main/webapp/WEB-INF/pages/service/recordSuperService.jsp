<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/26/2021
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">--%>

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
        <a class="text-white" href="<c:url value="/home/"/>">
            <span>HomeService</span>
        </a>
    </h1>

    <ul>
        <li><a href="<c:url value="/user/filter"/>" style="text-decoration: none;" class="text-white">Filter Users</a></li>
        <li><a href="<c:url value="/subService/record"/>" class="text-white">Definition SubService</a></li>
        <li><a href="<c:url value="/subService/addExpert"/>" class="text-white">Specialist appointment to Service</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/management/login"/>"><span class="glyphicon glyphicon-log-in" style="text-decoration: none;"></span>
            Login Manger</a></li>
    </ul>
</nav>
<%--<div id="fullscreen_bg" class="fullscreen_bg">
    <div id="regContainer" class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-login">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-6">
                                <a href="../customer/loginCustomer.jsp" class="active" id="login-form-link">Definition
                                    SuperService</a>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form:form id="login-form" role="form" style="display: block;" modelAttribute="superService" action="record" method="post">
                                    <div class="form-group">
                                        <label for="name">Name :</label>
                                        <form:input path="name" type="text" name="username" id="name" tabindex="1" class="form-control" placeholder="name"/>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6 col-sm-offset-3">
                                                <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                                       class="form-control btn btn-login" value="Submit">
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>--%>


<div id="login">
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div class="login-box col-md-12">
                    <form:form method="post" action="record" modelAttribute="superService" id="login-form" class="form">
                        <h3 class="text-center text-info">Record SuperService</h3>
                        <div class="form-group">
                            <label for="name" class="text-info">Name:</label><br>
                            <form:input type="text" name="name" id="name" class="form-control" path="name"/>
                        </div>
                        <div class="form-group">
                            <label for="remember-me" class="text-info"><span>Remember me</span> <span><input
                                    id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
