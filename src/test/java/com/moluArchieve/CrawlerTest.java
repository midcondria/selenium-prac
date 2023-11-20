package com.moluArchieve;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrawlerTest {

    @Autowired
    private Crawler crawler;

    @DisplayName("로그인 테스트")
    @Test
    void login() throws InterruptedException {
        // given
        crawler.login();
    }

    @DisplayName("짤 한장만")
    @Test
    void getSingleImage() throws InterruptedException {
        // given
        crawler.getSingleImage();
    }

    @DisplayName("짤 긁어오기")
    @Test
    void getImages() throws InterruptedException {
        // given
        crawler.getImages();
    }
}