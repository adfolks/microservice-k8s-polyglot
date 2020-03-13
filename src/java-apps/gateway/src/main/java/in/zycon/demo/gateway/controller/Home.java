package in.zycon.demo.gateway.controller;

import in.zycon.demo.gateway.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Home {
    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    public ResponseEntity<?> getAllNews() {
        return ResponseEntity.of(newsService.getAllNews());

    }
}
