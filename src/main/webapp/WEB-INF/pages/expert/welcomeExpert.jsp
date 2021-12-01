<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 6/11/2021
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expert Page</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

   <%-- <link href="<c:url value ="/static/css/WelcomeExpertStyle.css"/>" rel="stylesheet"/>--%>
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
        <li><a href="<c:url value="/"/>" style="text-decoration: none;" class="text-white">Home</a></li>
        <li><a href="<c:url value="/expert/chooseService"/>" style="text-decoration: none;" class="text-white">Choose Service</a></li>
       <%-- <li><a href="<c:url value="/expert/showComment"/>" class="text-white">Show comment</a></li>
        <li><a href="<c:url value="/expert/showOrders"/>" class="text-white">Show Order</a></li>
        <li><a href="<c:url value="/expert/addOffer"/>" class="text-white">Add Offer To Order</a></li>--%>
    </ul>
</nav>



<div id="login">
    <h3 class="text-center text-white pt-5">${expertRegistered.emailAddress}</h3>
    <h3 class="text-center text-white pt-5">${expertRegistered.password}</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div class="login-box col-md-12">
                    <form:form method="post" action="changePass" modelAttribute="expert" id="login-form" class="form">
                        <h3 class="text-center text-info">Change Password</h3>
                        <div class="form-group">
                            <label for="password" class="text-info">new password:</label><br>
                            <input type="text" name="password" id="password" class="form-control">
                            <p class="text-danger">${password}</p>
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
