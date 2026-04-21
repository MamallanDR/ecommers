package com.example.ecommers.seeder;

import com.example.ecommers.entity.Product;
import com.example.ecommers.repository.ProductRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    public ProductSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String @NonNull ... args) {
        if (productRepository.count() == 0) {

            List<Product> demoProducts = List.of(


                    Product.builder()
                            .name("iPhone 15")
                            .description("Apple smartphone with A16 Bionic chip")
                            .price(1000)
                            .stock(100)
                            .category("Smartphones")
                            .seller("Amazon")
                            .build(),

                    Product.builder()
                            .name("Samsung Galaxy S24")
                            .description("Flagship Android smartphone with AMOLED display")
                            .price(900)
                            .stock(80)
                            .category("Smartphones")
                            .seller("Flipkart")
                            .build(),

                    Product.builder()
                            .name("MacBook Pro 14")
                            .description("Apple laptop with M3 Pro chip")
                            .price(2200)
                            .stock(25)
                            .category("Laptops")
                            .seller("Apple Store")
                            .build(),

                    Product.builder()
                            .name("Dell XPS 13")
                            .description("Lightweight ultrabook with Intel Core i7")
                            .price(1500)
                            .stock(40)
                            .category("Laptops")
                            .seller("Dell")
                            .build(),

                    Product.builder()
                            .name("Sony WH-1000XM5")
                            .description("Noise cancelling wireless headphones")
                            .price(350)
                            .stock(150)
                            .category("Accessories")
                            .seller("Sony")
                            .build(),

                    Product.builder()
                            .name("Apple Watch Series 9")
                            .description("Smartwatch with health & fitness tracking")
                            .price(500)
                            .stock(70)
                            .category("Wearables")
                            .seller("Amazon")
                            .build(),

                    Product.builder()
                            .name("Logitech MX Master 3S")
                            .description("Advanced wireless mouse for productivity")
                            .price(120)
                            .stock(200)
                            .category("Accessories")
                            .seller("Logitech")
                            .build(),

                    Product.builder()
                            .name("Samsung 55-inch QLED TV")
                            .description("4K Smart TV with Quantum Dot technology")
                            .price(1100)
                            .stock(30)
                            .category("Electronics")
                            .seller("Samsung")
                            .build()

            );

            productRepository.saveAll(demoProducts);
            System.out.println("✅ Demo products inserted into database");
        }else {
            System.out.println("Product already exist... Skipping seed ");
        }
    }
}