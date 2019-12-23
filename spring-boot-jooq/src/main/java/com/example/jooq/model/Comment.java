package com.example.jooq.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private Integer id;
	private Post post;
	private String name;
	private String email;
	private String content;
	private Timestamp createdOn;
}