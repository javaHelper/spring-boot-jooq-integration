package com.example.jooq.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersOrderDetailsProducts {
	private Integer orderNumber;
	private Date orderDate;
	private String orderLineNumber;
	private String productName;
	private Integer quantityOrdered;
	private BigDecimal priceEach;
}
