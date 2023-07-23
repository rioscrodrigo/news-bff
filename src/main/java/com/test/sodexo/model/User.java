package com.test.sodexo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

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
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "is_active")
    @JsonProperty("is_active")
    private Boolean isActive;
    @Column(name = "creation_date")
    @JsonProperty("creation_date")
    private LocalDate creationDate;
    @Column(name = "birth_date")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
    @JsonProperty("favorite_news")
    @ElementCollection 
    private List<News> favoriteNews;
}
