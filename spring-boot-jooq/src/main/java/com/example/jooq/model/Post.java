package com.example.jooq.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	private Integer id;
	private String title;
	private String content;
	private Timestamp createdOn;
	private List<Comment> comments = new ArrayList<>();
}