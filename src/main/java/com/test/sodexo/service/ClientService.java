package com.test.sodexo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.model.Articles;

@Service
public class ClientService {

    Logger logger = Logger.getLogger("ClientService");

    public List<NewsDTO> spaceFlightNewsApi() {
        List<NewsDTO> newsList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Articles> response = restTemplate.getForEntity(
                "https://api.spaceflightnewsapi.net/v4/articles/",
                Articles.class);
        if (response.getBody() != null) {
            newsList = response.getBody().getResults();
        }
        return newsList;
    }

    public NewsDTO spaceFlightNewsApiById(Long id) {
        NewsDTO news = new NewsDTO();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsDTO> response = restTemplate.getForEntity(
                "https://api.spaceflightnewsapi.net/v4/articles/" + id,
                NewsDTO.class);
        if (response.getBody() != null) {
            news = response.getBody();
        }
        return news;
    }

}
