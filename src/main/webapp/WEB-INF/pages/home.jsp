<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/11/2021
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
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
        <li><a href="<c:url value="/"/>" style="text-decoration: none;" class="text-white">Home</a></li>
        <li><a href="<c:url value="/customer/register"/>" class="text-white">Register as Customer</a></li>
        <li><a href="<c:url value="/customer/login"/>" class="text-white">Login as Customer</a></li>
        <li><a href="<c:url value="/expert/register"/>" class="text-white">Register as Expert</a></li>
        <li><a href="<c:url value="/expert/login"/>" class="text-white">Login as Expert</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/management/login"/>"><span class="glyphicon glyphicon-log-in" style="text-decoration: none;"></span>
            Login Manger</a></li>
    </ul>
</nav>

<div class="container">
    <h3>ABOUT WE</h3>
    <p>
        Our site is a group for you who want to use and enjoy
        the facilities and services of the home
        with the best quality and at the most economical price,
    </p>
    <p>
        and also for those of you who specialize in specialized services ,
        you can become one of us
    </p>
</div>

<div id="contact">
    <h5>Contact Us</h5>
    <div id="contacts">
        <a href="#"><img src="<c:url value="/resources/static/images/icons8-telegram-app-50.png"/>"  alt="Our Telegram"></a>
        <a href="#"><img src="<c:url value="/static/images/icons8-twitter-48.png"/>"  alt="Our Twitter"></a>
        <a href="#"><img src="<c:url value="/static/images/icons8-instagram-64.png"/>"  alt="Our Instagram"></a>
        <a href="#"><img src="<c:url value="/images/icons8-number-pad-50.png"/>"  alt="Our Number"></a>
    </div>
</div>
</body>
</html>
