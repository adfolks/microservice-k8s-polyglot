package in.zycon.demo.gateway.services;

import in.zycon.demo.hawks.models.News;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NewsService {
    @Value("${news.host}")
    String host;
    @Value("${news.path}")
    String path;

    public Set<News> getAllNews(){

        RestTemplate restTemplate = new RestTemplate();
        return new HashSet<>(Arrays.asList(restTemplate.getForEntity(host+path,News[].class).getBody()));
    }



}
