package com.example.jooq.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsProductDto {
	private Integer orderNumber;
	private String productName;
	private Double msrp;
	private Double priceEach;
}
