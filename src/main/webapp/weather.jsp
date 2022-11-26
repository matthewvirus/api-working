<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<jsp:useBean id="weather" scope="request" type="by.matthewvirus.apiworking.data.WeatherBean"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Weather in ${weather.cityName}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header class="d-flex flex-wrap justify-content-center py-3 bg-dark">
    <jsp:include page="header.jsp"/>
</header>
<section class="vh-100" style="background-color: #4B515D;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-8 col-lg-6 col-xl-4">
                <div class="card" style="color: #4B515D; border-radius: 35px;">
                    <div class="card-body p-4">
                        <div class="d-flex">
                            <h6 class="flex-grow-1">${weather.cityName}</h6>
                            <h6><%=new SimpleDateFormat("HH:mm").format(new Date().getTime())%></h6>
                        </div>
                        <div class="d-flex flex-column text-center mt-5 mb-4">
                            <h6 class="display-4 mb-0 font-weight-bold" style="color: #1C2331;"> ${weather.averageTemperature}°C </h6>
                            <span class="small" style="color: #868B94">${weather.weatherType}</span>
                        </div>
                        <div class="d-flex align-items-center">
                            <div class="flex-grow-1" style="font-size: 1rem;">
                                <div>
                                    <i class="fas fa-feels-like fa-fw" style="color: #868B94;"></i>
                                    <span class="ms-1">Feels like ${weather.feelsLikeTemperature}°C</span>
                                </div>
                                <div>
                                    <i class="fas fa-humidity fa-fw" style="color: #868B94;"></i>
                                    <span class="ms-1">Humidity: ${weather.humidity}%</span>
                                </div>
                                <div>
                                    <i class="fas fa-pressure fa-fw" style="color: #868B94;"></i>
                                    <span class="ms-1">Pressure: ${weather.pressure}N/m<sup>2</sup></span>
                                </div>
                            </div>
                            <div>
                                <img src="https://openweathermap.org/img/wn/${weather.iconId}@4x.png" height="100px" width="100px" alt="weather type">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>