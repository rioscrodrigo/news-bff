package com.test.sodexo.model;

import java.io.Serializable;
import java.util.List;

import com.test.sodexo.dto.NewsDTO;

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
public class Articles implements Serializable {
    private static final long serialVersionUID = 1L;
    private String count;
    private String next;
    private String previous;
    private List<NewsDTO> results;

}
