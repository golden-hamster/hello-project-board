package com.hello.helloprojectboard.repository;

import com.hello.helloprojectboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
