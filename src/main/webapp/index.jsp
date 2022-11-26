<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Weather.io</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header class="d-flex flex-wrap justify-content-center py-3 bg-dark">
    <jsp:include page="header.jsp"/>
</header>
<section style="background-color: #4B515D; height: 90%;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-8 col-lg-6 col-xl-4">
                <form method="post" action='<c:url value="weather"/>'>
                    <div class="form-group mb-3">
                        <label for="city" class="mb-1" style="color: white">City or country</label>
                        <input type="search" class="form-control" id="city" name="city" placeholder="Name">
                    </div>
                    <div class="form-group d-flex align-items-center justify-content-center">
                        <button type="submit" class="btn" style="background-color: black; color: white;">Search!</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>