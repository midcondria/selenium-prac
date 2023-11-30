package com.moluArchieve;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CrawlerTest {

    @Autowired
    private Crawler crawler;

    @DisplayName("로그인 테스트")
    @Test
    void login() {
        // given
        crawler.login();
    }

    @DisplayName("짤 한장만")
    @Test
    void getSingleImage() {
        // given
        crawler.getSingleImage();
    }

    @DisplayName("짤 긁어오기")
    @Test
    void getImages() {
        // given
        List<String> result = crawler.getImages();

        assertThat(result.size()).isEqualTo(60);
    }

    @DisplayName("")
    @Test
    void downloadImages() {
        // given
        List<String> result = crawler.downloadImages();
        // expected
        assertThat(result.size()).isEqualTo(60);
    }
}