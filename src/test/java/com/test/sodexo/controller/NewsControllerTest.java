package com.test.sodexo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.service.NewsService;

@WebMvcTest
@ContextConfiguration(classes = NewsController.class)
class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsService newsService;

    @Test
    void getNewsTest() throws Exception {
        when(newsService.getNews()).thenReturn(new ArrayList<NewsDTO>());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/news/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getExternalNewsTest() throws Exception {
        NewsDTO newsDTOMock = NewsDTO.builder().id(1L).build();
        List<NewsDTO> newsList = new ArrayList<NewsDTO>();
        newsList.add(newsDTOMock);
        when(newsService.getSpaceFlightNews()).thenReturn(newsList);
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/news/space-flight")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
