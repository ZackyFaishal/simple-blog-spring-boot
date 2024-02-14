package com.jakblog.simpleblog.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakblog.simpleblog.repository.PostRepository;
import com.jakblog.simpleblog.vo.Post;


@Service
public class PostService {
    
	private static List<Post> posts;
	
	@Autowired
	PostRepository postRepository;
	
    public Post getPost(Long id) {
        Post post = postRepository.findOne(id);
        return post;
    }
    
    public List<Post> getPosts() {
    	List<Post> postList = postRepository.findPost();		
		return postList;
    }
    
    public List<Post> searchPostByTitle(String query){
    	List<Post> posts = postRepository.findPostLikeTitle(query);
    	return posts;
    }
}
