package com.example.jooq.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private Integer orderNumber;
	private String status;
	private String sum;
}
