package com.example.demo.controllers;

import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Product;

@Controller
public class ConfirmationBuyController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/confirmationbuy/{productID}")
    public String showConfirmationBuyPage(@PathVariable Long productID, Model model) {
        // Retrieve the product based on the provided productID
        Product product = productRepository.findById(productID).orElse(null);

        if (product == null) {
            // Handle the case where the product is not found
            // You can add appropriate error handling or redirect here
            return "errorPage"; // Create an error page template
        }

        // Add the product to the model to display in the confirmation page
        model.addAttribute("product", product);

        // You can add additional logic here to handle the purchase, update inventory, etc.

        return "confirmationbuy"; // This should match the name of your confirmationbuy.html template
    }
}
