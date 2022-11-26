package by.matthewvirus.apiworking.data;

import java.beans.JavaBean;
import java.io.Serializable;
import java.util.Objects;

@JavaBean
public class WeatherBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cityName;
    private double averageTemperature;
    private double feelsLikeTemperature;
    private long humidity;
    private long pressure;
    private String weatherType;
    private String iconId;

    public WeatherBean() {
        this.cityName = "";
        this.averageTemperature = 0f;
        this.feelsLikeTemperature = 0f;
        this.humidity = 0L;
        this.pressure = 0L;
        this.weatherType = "";
        this.iconId = "";
    }

    public WeatherBean(
            String cityName,
            double averageTemperature,
            double feelsLikeTemperature,
            long humidity,
            long pressure,
            String weatherType,
            String iconId
    ) {
        this.cityName = cityName;
        this.averageTemperature = averageTemperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.weatherType = weatherType;
        this.iconId = iconId;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherBean that = (WeatherBean) o;
        return Double.compare(that.averageTemperature, averageTemperature) == 0 && Double.compare(that.feelsLikeTemperature, feelsLikeTemperature) == 0 && humidity == that.humidity && pressure == that.pressure && Objects.equals(cityName, that.cityName) && Objects.equals(weatherType, that.weatherType) && Objects.equals(iconId, that.iconId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, averageTemperature, feelsLikeTemperature, humidity, pressure, weatherType, iconId);
    }
}