<jsp:useBean id="weather" scope="request" type="by.matthewvirus.apiworking.data.WeatherBean"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Weather</title>
</head>
<body>
<h1>weather jsp</h1>
<p>${weather.cityName}, ${weather.averageTemperature} <sup>o</sup>C, ${weather.weatherType}</p>
<p>Feels like ${weather.feelsLikeTemperature}</p>
<p>Humidity: ${weather.humidity}%</p>
<p>Pressure: ${weather.pressure} N/m<sup>2</sup></p>
</body>
</html>
