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
    
    public List<Post> getPostsOrderByUpdtAsc(String query){
    	List<Post> postsList = postRepository.findPostOrderByUpdtDateAsc();
    	return posts;
    }
    
    public List<Post> getPostsOrderByRegDesc(String query){
    	List<Post> postsList = postRepository.findPostOrderByUpdtRegDesc();
    	return posts;
    }
    
    public List<Post> searchPostByTitle(String query){
    	List<Post> posts = postRepository.findPostLikeTitle(query);
    	return posts;
    }
    
	public boolean savePost(Post post) {
		int result = postRepository.savePost(post);
		boolean isSuccess = true;
		
		if(result == 0) {
			isSuccess = false;
		}
		
		return isSuccess;
	}
}
