package com.example.jooq.resource;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.jooq.constant.ResourceSize;
import com.example.jooq.model.Comment;

public class PostModel {
	private Integer id;

	@NotBlank(message = "{validation.post.title}")
	@Size(max = ResourceSize.MAX_ID, min = ResourceSize.MIN_ID, message = "{length.validation.title}")
	private String title;
	
	private String content;
	private Timestamp createdOn;
	private List<Comment> comments = new ArrayList<>();

	public PostModel() {
	}

	public PostModel(Integer postId) {
		this.id = postId;
	}

	public PostModel(Integer id, String title, String content, Timestamp createdOn) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", createdOn=" + createdOn + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
