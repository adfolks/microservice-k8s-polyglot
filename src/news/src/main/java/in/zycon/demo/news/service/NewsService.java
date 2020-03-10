package in.zycon.demo.news.service;

import in.zycon.demo.news.exception.NewsNotFound;
import in.zycon.demo.news.model.News;
import in.zycon.demo.news.partner.FoxSports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class NewsService {

    @Autowired
    FoxSports foxSports;

    public News getNewsById(Integer id) {
        Optional<News> productFound = getAllNews().stream().filter(news -> {
            return news.getId().equals(id);
        }).findFirst();

        if (productFound.isPresent()) {
            return productFound.get();
        } else {
            throw new NewsNotFound("News not found in repo");
        }
    }

    public Set<News> getAllNews() {
        Set<News> allNews = new HashSet<News>();
        return allNews;
    }
}
