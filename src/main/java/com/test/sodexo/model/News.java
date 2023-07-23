package com.test.sodexo.model;

import java.time.LocalDate;

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
@Table(name = "news")
public class News {

    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "url")
    private String url;
    @Column(name = "image_url")
    @JsonProperty("image_url")
    private String imageUrl;
    @Column(name = "summary")
    private String summary;
    @Column(name = "news_site")
    @JsonProperty("news_site")
    private String newsSite;
    @Column(name = "publish_date")
    @JsonProperty("published_at")
    private LocalDate publishedAt;
    @Column(name = "updated_date")
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    @Column(name = "published")
    private Boolean published;

}
