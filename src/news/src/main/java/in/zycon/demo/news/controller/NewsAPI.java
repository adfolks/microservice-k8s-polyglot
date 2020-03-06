package in.zycon.demo.news.controller;

import in.zycon.demo.news.properties.Partners;
import in.zycon.demo.news.service.NewsService;
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
    Partners partners;

    @GetMapping(value = {"/news", "/news/{id}"})
    public ResponseEntity<?> getProduct(@PathVariable(required = false, name = "id") Integer id) {
        if (id != null) {
            return ResponseEntity.ok(newsService.getProductById(id));
        } else {
            return ResponseEntity.ok(newsService.masterProducts());
        }
    }

    @GetMapping("/test")
    public ResponseEntity<?> testing() {
        return ResponseEntity.ok(partners.getNews().get(2).getUrl());
    }
}
