package in.zycon.demo.pa.service;

import in.zycon.demo.hawks.models.News;
import in.zycon.demo.pa.products.BBCWorld;
import in.zycon.demo.pa.products.FoxSports;
import in.zycon.demo.pa.products.TechRepublic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;


class NewsServiceTest {

    @InjectMocks
    FoxSports foxSports;
    @InjectMocks
    TechRepublic techRepublic;
    @InjectMocks
    BBCWorld bbcWorld;

    @Test
    void getTechNews() {
        Set<News> allNews = new HashSet<News>();
        AtomicInteger atomicInteger = new AtomicInteger();
        techRepublic.getResponse().getChannel().getItem().forEach(item -> {

            allNews.add(new News(atomicInteger.getAndIncrement(), item.getTitle(), item.getDescription(), "NA", item.getLink(), item.getPubDate(), News.newsType.TECHNOLOGY));
        });
        assertTrue(allNews.size() > 0);
    }
}