package com.jakblog.simpleblog.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;
import com.jakblog.simpleblog.service.PostService;
import com.jakblog.simpleblog.vo.Post;
import com.jakblog.simpleblog.vo.Result;


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
	
	@GetMapping("/posts/updtdate/asc")
	public List<Post> getPostsOrderByUpdtAsc(@RequestParam("query") String query){
		List<Post> posts = postService.getPostsOrderByUpdtAsc(query);
		return posts;
	}
	
	@GetMapping("/posts/regdate/desc")
	public List<Post> getPostsOrderByRegDesc(@RequestParam("query") String query){
		List<Post> posts = postService.getPostsOrderByRegDesc(query);
		return posts;
	}
	
	@PostMapping("/post")
	public Object savePost(HttpServletResponse response, @RequestBody Post postParam) {
		Post post = new Post(postParam.getUser(), postParam.getTitle(), postParam.getContent());
		boolean isSuccess = postService.savePost(post);
		
		if (isSuccess) {
            return new Result(200, "Success");
        } else {
        	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
	}
}