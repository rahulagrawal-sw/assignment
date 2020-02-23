package com.coffeeshop.assignment;

import com.coffeeshop.assignment.exception.InvalidOrderException;
import com.coffeeshop.assignment.model.*;
import com.coffeeshop.assignment.service.OrderService;
import com.coffeeshop.assignment.service.OrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) throws InvalidOrderException {

		SpringApplication.run(AssignmentApplication.class, args);

		// Initialize & Seed data
		CoffeeShopMenu.seedData();

		//Place Order
		String myOrder1 = "[\"CHAI,-sugar\",\"COFFEE,-sugar,-milk\"]";
		String myOrder2 = "CHAI";
		String myOrder3 = "CHAI,-sugar";
		String myOrder4 = "";
		String myOrder5 = "CHAI,-tea,-sugar,-milk,-water";

		OrderService orderService = new OrderServiceImpl();
		orderService.placeOrder(myOrder1);
	}
}
