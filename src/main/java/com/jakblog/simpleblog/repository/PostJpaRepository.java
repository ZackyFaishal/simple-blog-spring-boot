package com.jakblog.simpleblog.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jakblog.simpleblog.vo.Post;

@Repository("PostJpaRepository")
public interface PostJpaRepository extends JpaRepository<Post, Serializable>{
	Post findOneById(Long id);
	List<Post> findAllByOrderByUpdtDateDesc();
	List<Post> findAllByOrderByUpdtDateAsc();
	List<Post> findByContentContainingOrderByUpdtDateDesc(String content);
	List<Post> findByTitleContainingOrderByUpdtDateDesc(String query);
}
