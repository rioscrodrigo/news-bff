package com.test.sodexo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sodexo.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
