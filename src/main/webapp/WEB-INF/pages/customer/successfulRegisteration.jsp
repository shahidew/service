<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahdavi
  Date: 8/2/2021
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
<h2>'A verification email has been sent to: ' + ${emailId}</h2>
<a href="<c:url value="/customer/welcomeCustomer"/>">Customer Page</a>
<a href="<c:url value="/home"/>">Go Home</a>
</body>
</html>
