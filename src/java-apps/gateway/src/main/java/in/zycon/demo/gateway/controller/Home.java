package in.zycon.demo.gateway.controller;

import in.zycon.demo.gateway.services.*;
import in.zycon.demo.hawks.constants.Errors;
import in.zycon.demo.hawks.models.Gateway;
import in.zycon.demo.hawks.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class Home {
    @Autowired
    NewsService newsService;
    @Autowired
    WeatherService weatherService;
    @Autowired
    AdService adService;

    @Autowired
    ProdAvail prodAvail;
    @Autowired
    ProductsOMS productsOMS;

    @GetMapping("/news")
    public ResponseEntity<?> getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());

    }

    @GetMapping("/ads")
    public ResponseEntity<?> getAllAds() {
        return ResponseEntity.ok(adService.getAllAds());

    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("test");

    }

    @GetMapping("/weather")
    public ResponseEntity<?> getWeather(@RequestParam("id") String id) {
        Weather weather = weatherService.getAllWeather(id);
        if (weather == null) {
            return ResponseEntity.badRequest().body(Errors.PARTNER_FAILED);
        }
        return ResponseEntity.ok(weatherService.getAllWeather(id));

    }

    @GetMapping("/status")
    public ResponseEntity<?> getStatus(@RequestParam("id") String id) {


        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(prodAvail.getProductStatus(id));

    }
    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(productsOMS.getProducts());

    }

    @GetMapping("/all")
    public ResponseEntity<?> getHomeApi(@RequestParam(value = "id", required = false) String id) {
        Gateway gateway = new Gateway();
        gateway.setAds(adService.getAllAds());
        gateway.setNews(newsService.getAllNews());
        if (id != null) {
            gateway.setWeather(weatherService.getAllWeather(id));
        }
        return ResponseEntity.ok(gateway);
    }
}
