package com.example.jooq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.jooq.model.Post;
import com.example.jooq.service.BlogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Post Management")
@RestController
@Validated
public class PostController {

	@Autowired
	private BlogService blogService;

	@ApiOperation(value = "Find Posts", nickname = "Find Posts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "/api/posts")
	public ResponseEntity<List<Post>> findPosts() {
		List<Post> posts = blogService.getAllPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@ApiOperation(value = "Find Post By PostId", nickname = "Find Post By PostId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "/api/post/{post-id}")
	public ResponseEntity<Post> findByPostId(@PathVariable("post-id") Integer postId) {
		Post post = blogService.getPost(postId);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}
