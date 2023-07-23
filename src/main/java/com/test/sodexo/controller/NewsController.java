package com.test.sodexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/")
    public ResponseEntity<List<NewsDTO>> getNews() {
        return new ResponseEntity<>(newsService.getNews(), HttpStatus.OK);
    }

    @GetMapping("/space-flight")
    public ResponseEntity<List<NewsDTO>> externalNews() {
        return new ResponseEntity<>(newsService.getSpaceFlightNews(), HttpStatus.OK);
    }

}
