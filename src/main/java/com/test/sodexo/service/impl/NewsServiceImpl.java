package com.test.sodexo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.model.News;
import com.test.sodexo.repository.NewsRepository;
import com.test.sodexo.service.ClientService;
import com.test.sodexo.service.NewsService;
import com.test.sodexo.utils.DateUtil;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<NewsDTO> getNews() {
        return this.collectNewsDTO(newsRepository.findAll());
    }

    @Override
    public NewsDTO getNewsById(Long id) {
        return this.getSpaceFlightNews().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElse(new NewsDTO());
    }

    @Override
    public List<NewsDTO> getSpaceFlightNews() {
        return clientService.spaceFlightNewsApi();
    }

    @Override
    public NewsDTO getSpaceFlightNewsById(Long id) {
        return clientService.spaceFlightNewsApiById(id);
    }

    @Override
    public void addNews(NewsDTO newsDTO) {
        newsRepository.save(modelMapper.map(newsDTO, News.class));
    }

    private List<NewsDTO> collectNewsDTO(List<News> newsList) {
        List<NewsDTO> newsDTOList = new ArrayList<>();
        newsList.forEach(n -> newsDTOList.add(this.modelMapper.map(n, NewsDTO.class)));
        newsDTOList.forEach(n -> n.setFormatedPublishedAt(DateUtil.formatDate(n.getPublishedAt())));
        return newsDTOList;
    }

}
