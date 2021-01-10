package com.adfolks.modern.demo.pa;

import com.adfolks.modern.demo.pa.controller.NewsAPI;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsApplicationTest {

    @Autowired
    private NewsAPI newsAPI;

    @Test
    void contextLoads() {
        Assertions.assertThat(newsAPI).isNotNull();
    }

}