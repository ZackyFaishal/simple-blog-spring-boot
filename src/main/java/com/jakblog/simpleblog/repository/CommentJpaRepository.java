package com.jakblog.simpleblog.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jakblog.simpleblog.vo.Comment;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comment, Serializable> {
	Comment findById(Long id);
	List<Comment> findByPostIdOrderByRegDateDesc(Long postId);
	List<Comment> findByPostIdAndCommentContainingOrderByRegDateDesc(Long postId, String query);
}
