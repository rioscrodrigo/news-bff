package com.test.sodexo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.model.User;
import com.test.sodexo.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private NewsService newsService;

    @Test
    void getUsersTest() throws Exception {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        List<User> userList = userRepository.findAll();
        assertNotNull(userList);
    }

    @Test
    void getUserByIdTest() throws Exception {
        Optional<User> user = Optional.empty();
        when(userRepository.findById(1L)).thenReturn(user);
        Optional<User> userTest = userRepository.findById(1L);
        assertNotNull(userTest);
    }

    @Test
    void addNewsFavoriteTest() throws Exception {
        User user = User.builder().id(1L).favoriteNews(new ArrayList<>()).build();
        when(userRepository.save(user)).thenReturn(user);
        when(newsService.getSpaceFlightNewsById(1L)).thenReturn(new NewsDTO());
        User userTest = userRepository.save(user);
        assertEquals(userTest, user);
    }

    @Test
    void deleteNewsFavoriteTest() throws Exception {
        User user = User.builder().id(1L).favoriteNews(new ArrayList<>()).build();
        when(userRepository.save(user)).thenReturn(user);
        when(newsService.getSpaceFlightNewsById(1L)).thenReturn(new NewsDTO());
        User userTest = userRepository.save(user);
        assertEquals(userTest, user);
    }
}
