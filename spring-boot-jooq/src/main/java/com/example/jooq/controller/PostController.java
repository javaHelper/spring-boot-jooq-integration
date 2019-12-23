package com.example.jooq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.jooq.model.Post;
import com.example.jooq.service.BlogService;

@RestController
public class PostController {

	@Autowired
	private BlogService blogService;
	
	@GetMapping(value = "/api/posts")
	public ResponseEntity<List<Post>> findPosts(){
		List<Post> posts = blogService.getAllPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/post/{post-id}")
	public ResponseEntity<Post> findByPostId(@PathVariable("post-id") Integer postId){
		Post post = blogService.getPost(postId);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}
