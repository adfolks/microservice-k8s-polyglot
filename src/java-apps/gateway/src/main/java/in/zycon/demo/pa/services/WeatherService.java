package in.zycon.demo.pa.services;

import in.zycon.demo.hawks.models.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {
    @Value("${weather.host}")
    String host;
    @Value("${weather.path}")
    String path;

    public Weather getAllWeather(String id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForEntity(host + path + id, Weather.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
