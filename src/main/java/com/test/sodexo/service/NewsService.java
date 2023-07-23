package com.test.sodexo.service;

import java.util.List;

import com.test.sodexo.dto.NewsDTO;

public interface NewsService {
    List<NewsDTO> getNews();

    void addNews(NewsDTO newsDTO);

    NewsDTO getNewsById(Long id);

    List<NewsDTO> getSpaceFlightNews();

    NewsDTO getSpaceFlightNewsById(Long id);

}
