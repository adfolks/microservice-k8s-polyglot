package in.zycon.demo.news.service;

import in.zycon.demo.news.exception.NewsNotFound;
import in.zycon.demo.news.model.News;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class NewsService {

    public News getProductById(Integer id) {
        Optional<News> productFound = masterProducts().stream().filter(news -> {
            return news.getId().equals(id);
        }).findFirst();

        if (productFound.isPresent()) {
            return productFound.get();
        } else {
            throw new NewsNotFound("News not found in repo");
        }
    }

    public Set<News> masterProducts() {
        Set<News> allNews = new HashSet<News>();
        return allNews;
    }
}
