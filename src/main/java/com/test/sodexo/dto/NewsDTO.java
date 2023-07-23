package com.test.sodexo.dto;

import java.time.LocalDate;

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
public class NewsDTO {
    private Long id;
    private String title;
    private String url;
    @JsonProperty("image_url")
    private String imageUrl;
    private String summary;
    @JsonProperty("news_site")
    private String newsSite;
    @JsonProperty("published_at")
    private LocalDate publishedAt;
    @JsonProperty("formatted_published_at")
    private String formatedPublishedAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    private Boolean published;
}
