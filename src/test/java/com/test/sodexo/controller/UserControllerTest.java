package com.test.sodexo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

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

import com.test.sodexo.dto.UserDTO;
import com.test.sodexo.service.UserService;

@WebMvcTest
@ContextConfiguration(classes = UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUserTest() throws Exception {
        when(userService.getUserById(1L)).thenReturn(new UserDTO());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/users/{id}", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findNewsFavoriteTest() throws Exception {
        when(userService.findNewsFavorite(1L)).thenReturn(new ArrayList<>());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/users/{userId}/news-favorite", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addNewsFavoriteTest() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/users/{userId}/news-favorite/{newsId}", "1", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteNewsFavoriteTest() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/users/{userId}/news-favorite/{newsId}", "1", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
