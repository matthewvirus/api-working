package by.matthewvirus.apiworking;

import by.matthewvirus.apiworking.data.WeatherBean;
import by.matthewvirus.apiworking.exceptions.ResourceNotFoundException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

@WebServlet(name = "WeatherInfoServlet", value = "/weather")
public class WeatherInfoServlet extends HttpServlet {

    private String key;

    @Override
    public void init() {
        try (InputStream input = WeatherInfoServlet.class.getClassLoader().getResourceAsStream("dev.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            key = prop.getProperty("apiKey");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
    }

    @Override
    protected void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("weather", makeWeatherBeanObject(request.getParameter("city")));
            getServletContext().getRequestDispatcher("/weather.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/notfound?error=" + e.getMessage());
        }
    }

    private String getAPIInformation(@NotNull URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        StringBuilder information = new StringBuilder();
        connection.setRequestMethod("GET");
        connection.connect();
        if (connection.getResponseCode() != 200) {
            throw new ResourceNotFoundException("Resource not found");
        } else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                information.append(scanner.nextLine());
            }
            scanner.close();
        }
        return String.valueOf(information);
    }

    private JSONObject makeDataObject(String apiInformation) throws ParseException {
        return (JSONObject) new JSONParser().parse(apiInformation);
    }

    private JSONObject makeMainWeatherObject(@NotNull JSONObject dataObject) {
        return (JSONObject) dataObject.get("main");
    }

    private JSONObject makeAdditionalWeatherObject(@NotNull JSONObject dataObject) {
        JSONArray weatherArray = (JSONArray) dataObject.get("weather");
        return (JSONObject) weatherArray.get(0);
    }

    private @NotNull WeatherBean makeWeatherBeanObject(String city) throws IOException, ParseException {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" +
                city +
                "&units=metric&appid=" +
                key;
        URL url = new URL(urlString);
        JSONObject dataObject = makeDataObject(getAPIInformation(url));
        JSONObject mainWeatherObject = makeMainWeatherObject(dataObject);
        JSONObject additionalWeatherObject = makeAdditionalWeatherObject(dataObject);
        return new WeatherBean(
                (String) dataObject.get("name"),
                (Double) mainWeatherObject.get("temp"),
                (Double) mainWeatherObject.get("feels_like"),
                (Long) mainWeatherObject.get("humidity"),
                (Long) mainWeatherObject.get("pressure"),
                (String) additionalWeatherObject.get("main"),
                (String) additionalWeatherObject.get("icon")
        );
    }
}