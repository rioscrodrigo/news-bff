package com.test.sodexo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.dto.UserDTO;
import com.test.sodexo.model.News;
import com.test.sodexo.model.User;
import com.test.sodexo.repository.UserRepository;
import com.test.sodexo.service.NewsService;
import com.test.sodexo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = Logger.getLogger("UserServiceImpl");

    @Autowired
    UserRepository userRepository;

    @Autowired
    NewsService newsService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDTO> getUsers() {
        return this.collectUserDTO(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        logger.log(Level.INFO, "Consulting for user ID: {0}", id);
        UserDTO userDTO = new UserDTO();
        Optional<User> opUser = userRepository.findById(id);
        if (opUser.isPresent()) {
            userDTO = this.modelMapper.map(opUser.get(), UserDTO.class);
        }
        return userDTO;
    }

    @Override
    public void addNewsFavorite(Long userId, Long newsId) {
        News news = modelMapper.map(newsService.getSpaceFlightNewsById(newsId), News.class);
        User user = modelMapper.map(this.getUserById(userId), User.class);
        List<News> newsList = user.getFavoriteNews();
        if (news.getId() != null && newsList.stream().noneMatch(i -> news.getId().equals(i.getId()))) {
            newsService.addNews(newsService.getSpaceFlightNewsById(newsId));
            newsList.add(news);
        }
        userRepository.save(user);
        logger.log(Level.INFO, "Added favorite for user: {0}", userId);
    }

    @Override
    public void deleteNewsFavorite(Long userId, Long newsId) {
        User user = modelMapper.map(this.getUserById(userId), User.class);
        List<News> newsList = user.getFavoriteNews();
        News newsToRemove = newsList.stream().filter(i -> newsId.equals(i.getId())).findAny().orElse(new News());
        newsList.remove(newsToRemove);
        userRepository.save(user);
        logger.log(Level.INFO, "Removed favorite for user: {0}", userId);
    }

    @Override
    public List<NewsDTO> findNewsFavorite(Long userId) {
        logger.log(Level.INFO, "Seaching favorites news for user: {0}", userId);
        return this.getUserById(userId).getFavoriteNews();
    }

    private List<UserDTO> collectUserDTO(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        userList.forEach(n -> userDTOList.add(this.modelMapper.map(n, UserDTO.class)));
        return userDTOList;
    }

}
