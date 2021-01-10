package com.adfolks.modern.demo.pa.service;

import com.adfolks.modern.demo.pa.products.FoxSports;
import com.adfolks.modern.demo.pa.products.TechRepublic;
import com.adfolks.modern.demo.pa.exception.NewsNotFound;
import com.adfolks.modern.demo.pa.exception.PartnerDataException;
import com.adfolks.modern.demo.pa.products.BBCWorld;
import in.zycon.demo.hawks.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NewsService {
    @Autowired
    FoxSports foxSports;
    @Autowired
    TechRepublic techRepublic;
    @Autowired
    BBCWorld bbcWorld;

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

        try {
            AtomicInteger atomicInteger = new AtomicInteger();
            techRepublic.getResponse().getChannel().getItem().forEach(item -> {

                allNews.add(new News(atomicInteger.getAndIncrement(), item.getTitle(), item.getDescription(), "NA", item.getLink(), item.getPubDate(), News.newsType.TECHNOLOGY));
            });
            foxSports.getResponse().getChannel().
                    getItem().forEach(item -> {
                allNews.add(new News(atomicInteger.getAndIncrement(), item.getTitle(), item.getDescription(), item.getEnclosure() != null ? item.getEnclosure().getUrl() : "NA", item.getLink(), item.getPubDate(), News.newsType.SPORTS));
            });
            bbcWorld.getResponse().getChannel().getItem().forEach(item -> {
                allNews.add(new News(atomicInteger.getAndIncrement(), item.getTitle(), item.getDescription(), "NA", item.getLink(), item.getPubDate(), News.newsType.WORLD));
            });
        } catch (PartnerDataException e) {
            e.printStackTrace();
        }
        return allNews;
    }
}
