package com.coffeeshop.assignment;

import com.coffeeshop.assignment.exception.InvalidOrderException;
import com.coffeeshop.assignment.model.CoffeeShopMenu;
import com.coffeeshop.assignment.service.OrderService;
import com.coffeeshop.assignment.service.OrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		String myOrder5 = "CHAI,-teaBag,-sugar,-milk,-water";
		String myOrder6 = "BEER";

		OrderService orderService = new OrderServiceImpl();
		orderService.placeOrder(myOrder6);
	}
}
