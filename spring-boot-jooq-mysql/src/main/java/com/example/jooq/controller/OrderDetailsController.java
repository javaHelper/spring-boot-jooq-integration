package com.example.jooq.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.jooq.dto.OrderDetailsProductDto;
import com.example.jooq.dto.OrderDto;
import com.example.jooq.dto.OrdersOrderDetailsProducts;
import com.example.jooq.service.OrderService;

@RestController
public class OrderDetailsController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order-details/{product-code}")
	public ResponseEntity<List<OrderDetailsProductDto>> findProgramById(@PathVariable("product-code") @NotBlank String productcode){
		List<OrderDetailsProductDto> response = orderService.findOrderDetailsAndProductByProdCode(productcode);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/orders")
	public ResponseEntity<List<OrderDto>> findOrders() {
		List<OrderDto> response = orderService.findOrder();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/orders-order-details-product")
	public ResponseEntity<List<OrdersOrderDetailsProducts>> findOrdersAndOrderDetailsAndProduct() {
		List<OrdersOrderDetailsProducts> response = orderService.findOrdersAndOrderDetailsAndProducts();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
