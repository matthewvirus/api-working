<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Try to find the weather</h1>
<form method="post" action='<c:url value="weather"/>'>
    <label>
        City
        <input type="search" placeholder="City" name="city">
    </label><br>
    <input type="submit" value="Search!">
</form>
</body>
</html>