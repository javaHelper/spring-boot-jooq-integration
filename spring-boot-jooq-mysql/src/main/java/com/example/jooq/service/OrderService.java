package com.example.jooq.service;

import static com.example.jooq.model.tables.Orderdetails.ORDERDETAILS;
import static com.example.jooq.model.tables.Orders.ORDERS;
import static com.example.jooq.model.tables.Products.PRODUCTS;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Record6;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jooq.dto.OrderDetailsProductDto;
import com.example.jooq.dto.OrderDto;
import com.example.jooq.dto.OrdersOrderDetailsProducts;
import com.example.jooq.model.tables.Orderdetails;
import com.example.jooq.model.tables.Orders;
import com.example.jooq.model.tables.Products;

@Service
public class OrderService {
	Products p = PRODUCTS.as("p");
	Orderdetails o = ORDERDETAILS.as("o");
	Orders or = ORDERS.as("or");

	@Autowired
	private DSLContext dsl;

	public List<OrdersOrderDetailsProducts> findOrdersAndOrderDetailsAndProducts() {
		Result<Record6<Integer, Date, Short, String, Integer, BigDecimal>> fetch = dsl
				.select(ORDERS.ORDERNUMBER, ORDERS.ORDERDATE, ORDERDETAILS.ORDERLINENUMBER, PRODUCTS.PRODUCTNAME,
						ORDERDETAILS.QUANTITYORDERED, ORDERDETAILS.PRICEEACH)
				.from(ORDERS)
				.innerJoin(ORDERDETAILS).using(ORDERS.ORDERNUMBER)
				.innerJoin(PRODUCTS).using(PRODUCTS.PRODUCTCODE)
				.orderBy(ORDERS.ORDERNUMBER, ORDERDETAILS.ORDERLINENUMBER)
				.fetch();

		List<OrdersOrderDetailsProducts> detailsProducts = new ArrayList<>();
		for (Record6<Integer, Date, Short, String, Integer, BigDecimal> r : fetch) {
			detailsProducts.add(OrdersOrderDetailsProducts.builder()
					.orderNumber(r.getValue(ORDERS.ORDERNUMBER, Integer.class))
					.orderDate(r.getValue(ORDERS.ORDERDATE, Date.class))
					.orderLineNumber(r.getValue(ORDERDETAILS.ORDERLINENUMBER, String.class))
					.productName(r.getValue(PRODUCTS.PRODUCTNAME, String.class))
					.quantityOrdered(r.getValue(ORDERDETAILS.QUANTITYORDERED, Integer.class))
					.priceEach(r.getValue(ORDERDETAILS.PRICEEACH, BigDecimal.class))
					.build());
		}
		return detailsProducts;
	}

	public List<OrderDto> findOrder() {
		Result<Record2<Integer, String>> fetch = dsl.select(ORDERS.ORDERNUMBER, ORDERS.STATUS).from(ORDERS)
				.innerJoin(ORDERDETAILS).on(ORDERS.ORDERNUMBER.eq(ORDERDETAILS.ORDERNUMBER)).groupBy(ORDERS.ORDERNUMBER)
				.fetch();

		List<OrderDto> orderDtos = new ArrayList<>();
		for (Record2<Integer, String> r : fetch) {
			orderDtos.add(OrderDto.builder().orderNumber(r.getValue(ORDERS.ORDERNUMBER, Integer.class))
					.status(r.getValue(ORDERS.STATUS, String.class)).build());
		}
		return orderDtos;
	}

	public List<OrderDetailsProductDto> findOrderDetailsAndProductByProdCode(String productCode) {

		Result<Record4<Integer, String, BigDecimal, BigDecimal>> fetch = dsl
				.select(ORDERDETAILS.ORDERNUMBER, PRODUCTS.PRODUCTNAME, PRODUCTS.MSRP, ORDERDETAILS.PRICEEACH).from(p)
				.innerJoin(o).on(p.PRODUCTCODE.eq(o.PRODUCTCODE)).and(p.MSRP.eq(o.PRICEEACH))
				.where(p.PRODUCTCODE.eq(productCode)).fetch();

		List<OrderDetailsProductDto> dto = new ArrayList<>();
		for (Record4<Integer, String, BigDecimal, BigDecimal> r : fetch) {
			dto.add(new OrderDetailsProductDto(r.getValue(ORDERS.ORDERNUMBER, Integer.class),
					r.getValue(PRODUCTS.PRODUCTNAME, String.class), r.getValue(PRODUCTS.MSRP, Double.class),
					r.getValue(ORDERDETAILS.PRICEEACH, Double.class)));
		}
		return dto;
	}
}
