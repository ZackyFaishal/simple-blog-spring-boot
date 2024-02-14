package com.jakblog.simpleblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jakblog.simpleblog.service.CommentService;
import com.jakblog.simpleblog.vo.Comment;
import com.jakblog.simpleblog.vo.Post;
import com.jakblog.simpleblog.vo.Result;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/comment")
	public Object savePost(HttpServletResponse response, @RequestBody Comment commentParam) {
		Comment comment = new Comment(commentParam.getPostId(), commentParam.getUser(), commentParam.getComment());
		boolean isSuccess = commentService.saveComment(comment);
		
		if(isSuccess) {
			return new Result(200, "Success");
		} else {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return new Result(500, "Fail");
		}
	}
	
	@GetMapping("/comments")
	public List<Comment> getComments(@RequestParam("post_id") long postId){
		return commentService.getCommentList(postId);
	}
	
	@GetMapping("/comment")
	public Object getComment(@RequestParam("id") long id){
		return commentService.getComment(id);
	}
	
	@DeleteMapping("/comment")
	public Object deleteComment(HttpServletResponse response, @RequestParam("id") Long id) {
		boolean isSuccess = commentService.deleteComment(id);
		
		if(isSuccess) {
			return new Result(200, "Success");
		}
		else {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return new Result(500, "Fail");
		}
	}
	
	@GetMapping("/comments/search")
		public List<Comment> searchComments(@RequestParam("post_id") Long post_id,@RequestParam("query") String query){
		return commentService.searchComments(post_id, query);
	}
}
	
	