package in.zycon.demo.news.controller;

import in.zycon.demo.news.model.News;
import in.zycon.demo.news.partner.BBCWorld;
import in.zycon.demo.news.partner.TechRepublic;
import in.zycon.demo.news.partner.FoxSports;
import in.zycon.demo.news.properties.Partners;
import in.zycon.demo.news.service.NewsService;
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


    @GetMapping(value = {"/news", "/news/{id}"})
    @ApiOperation(value = "Get All News", response = News.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News Fetched successfully")
    })
    public ResponseEntity<?> getProduct(@PathVariable(required = false, name = "id") Integer id) {
        if (id != null) {
            return ResponseEntity.ok(newsService.getNewsById(id));
        } else {
            return ResponseEntity.ok(newsService.getAllNews());
        }
    }
}
