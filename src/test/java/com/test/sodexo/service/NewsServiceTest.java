package com.test.sodexo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.sodexo.model.News;
import com.test.sodexo.repository.NewsRepository;

@SpringBootTest
@AutoConfigureMockMvc
class NewsServiceTest {

    @Mock
    NewsRepository newsRepository;

    @Test
    void getNewsTest() throws Exception {
        when(newsRepository.findAll()).thenReturn(new ArrayList<>());
        List<News> newsList = newsRepository.findAll();
        assertNotNull(newsList);
    }

    @Test
    void getNewsByIdTest() throws Exception {
        when(newsRepository.findAll()).thenReturn(new ArrayList<>());
        List<News> newsList = newsRepository.findAll();
        assertNotNull(newsList);
    }

}
