package com.jakblog.simpleblog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jakblog.simpleblog.service.PostService;
import com.jakblog.simpleblog.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/post")
	public Post getPost(@RequestParam("id")Long id) {
		Post post = postService.getPost(id);
	return post;
	}
	
	@GetMapping("/posts")
	public List<Post> getPosts() {
		List<Post> posts = postService.getPosts();
		return posts;
	}
	
	@GetMapping("/post/{id}")
	public Post getPostPathParam(@PathVariable("id")Long id) {
		Post post = postService.getPost(id);
		return post;
	}
	
	@GetMapping("/posts/search/title")
	public List<Post> searchByTitle(@RequestParam("query") String query){
		List<Post> posts = postService.searchPostByTitle(query);
		return posts;
	}
}