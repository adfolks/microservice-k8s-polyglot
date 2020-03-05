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
        allNews.add(new News(1, "Rangers: What has happened to Steven Gerrard's side in 2020?", "Rangers returned from the winter break with their Scottish Premiership title hopes in their own hands. But just 49 days and 12 domestic duels later, they are 13 points behind city rivals Celtic and staring at another trophyless season.", 122, News.newsType.SPORTS));
        allNews.add(new News(2, "Italy's Corinaldo tragedy: Pepper spray stampede suspects face judge", "The stampede at the Lanterna Azzurra (Blue Lantern) club was a tragedy that traumatised Italy in December 2018, leaving five teenagers and a woman dead.", 20, News.newsType.WORLD));
        allNews.add(new News(3, "Apple reportedly warns stores about replacement iPhone shortage", "Try not to break your iPhone -- Apple might not be able to offer a replacement for a few weeks. Its retail employees were warned that replacements for badly damaged devices will be in short supply, Bloomberg reported Tuesday, in sign of the global coronavirus outbreak's impact on Apple's supply chain", 9, News.newsType.TECHNOLOGY));
        return allNews;
    }
}
