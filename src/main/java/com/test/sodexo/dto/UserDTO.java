package com.test.sodexo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String password;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("creation_date")
    private LocalDate creationDate;
    @JsonProperty("birth_date")
    private LocalDate birthDate;
    @JsonProperty("favorite_news")
    private List<NewsDTO> favoriteNews;
}
