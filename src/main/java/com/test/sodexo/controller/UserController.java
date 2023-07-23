package com.test.sodexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sodexo.dto.NewsDTO;
import com.test.sodexo.dto.UserDTO;
import com.test.sodexo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}/news-favorite")
    public ResponseEntity<List<NewsDTO>> findNewsFavorite(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.findNewsFavorite(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/news-favorite/{newsId}")
    public HttpStatus addNewsFavorite(@PathVariable Long userId, @PathVariable Long newsId) {
        userService.addNewsFavorite(userId, newsId);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{userId}/news-favorite/{newsId}")
    public HttpStatus deleteNewsFavorite(@PathVariable Long userId, @PathVariable Long newsId) {
        userService.deleteNewsFavorite(userId, newsId);
        return HttpStatus.OK;
    }
}
