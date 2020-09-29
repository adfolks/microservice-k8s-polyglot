package in.zycon.demo.pa.controller;

import com.microsoft.applicationinsights.TelemetryClient;
import in.zycon.demo.pa.service.NewsService;
import in.zycon.demo.hawks.models.News;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsAPI {
    @Autowired
    NewsService newsService;

    @Autowired
    TelemetryClient telemetryClient;


    @GetMapping(value = {"/news", "/news/{id}"})
    @ApiOperation(value = "Get All News", response = News.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News Fetched successfully")
    })
    public ResponseEntity<?> getProduct(@PathVariable(required = false, name = "id") Integer id) {
        telemetryClient.trackEvent("news-service event");
        if (id != null) {
            return ResponseEntity.ok(newsService.getNewsById(id));
        } else {
            return ResponseEntity.ok(newsService.getAllNews());
        }
    }
}
