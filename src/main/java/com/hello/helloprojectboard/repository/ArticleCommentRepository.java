package com.hello.helloprojectboard.repository;

import com.hello.helloprojectboard.domain.ArticleComment;
import com.hello.helloprojectboard.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>
{
    List<ArticleComment> findByArticle_Id(Long articleId);

    void deleteByIdAndUserAccount_UserId(Long articleCommentId, String userId);

    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content, root.createdAt, root.createdBy);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // like '%${v}%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // like '%${v}%'
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase); // like '%${v}%'
    }
}
