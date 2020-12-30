package com.cs.assignment;

import com.cs.assignment.exception.InvalidOrderException;
import com.cs.assignment.model.CoffeeShopMenu;
import com.cs.assignment.service.OrderService;
import com.cs.assignment.service.OrderServiceImpl;
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
        String myOrder5 = "CHAI,-tea,-sugar,-milk,-water";

        OrderService orderService = new OrderServiceImpl();
        orderService.placeOrder(myOrder1);
    }
}
