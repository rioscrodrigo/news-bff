package com.test.sodexo.service;

import java.util.List;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.dto.UserDTO;

public interface UserService {
    List<UserDTO> getUsers();

    UserDTO getUserById(Long id);

    List<NewsDTO> findNewsFavorite(Long userId);

    void addNewsFavorite(Long userId, Long newsId);

    void deleteNewsFavorite(Long userId, Long newsId);
}
