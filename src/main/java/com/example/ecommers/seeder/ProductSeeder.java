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
                                    .name("Google Pixel 8")
                                    .description("Pure Android experience with advanced AI camera")
                                    .price(850)
                                    .stock(60)
                                    .category("Smartphones")
                                    .seller("Google Store")
                                    .build(),

                            Product.builder()
                                    .name("OnePlus 12 Pro")
                                    .description("High-performance smartphone with fast charging")
                                    .price(780)
                                    .stock(90)
                                    .category("Smartphones")
                                    .seller("OnePlus")
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
                                    .name("HP Spectre x360")
                                    .description("Convertible laptop with OLED display")
                                    .price(1400)
                                    .stock(35)
                                    .category("Laptops")
                                    .seller("HP")
                                    .build(),

                            Product.builder()
                                    .name("Lenovo ThinkPad X1 Carbon")
                                    .description("Business laptop with enterprise-grade security")
                                    .price(1600)
                                    .stock(30)
                                    .category("Laptops")
                                    .seller("Lenovo")
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
                                    .name("Bose QuietComfort Ultra")
                                    .description("Premium noise cancelling headphones")
                                    .price(380)
                                    .stock(120)
                                    .category("Accessories")
                                    .seller("Bose")
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
                                    .name("Apple Magic Keyboard")
                                    .description("Wireless keyboard with Touch ID")
                                    .price(180)
                                    .stock(90)
                                    .category("Accessories")
                                    .seller("Apple Store")
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
                                    .name("Samsung Galaxy Watch 6")
                                    .description("Smartwatch with advanced health sensors")
                                    .price(420)
                                    .stock(65)
                                    .category("Wearables")
                                    .seller("Samsung")
                                    .build(),

                            Product.builder()
                                    .name("Fitbit Charge 6")
                                    .description("Fitness tracker with GPS support")
                                    .price(180)
                                    .stock(140)
                                    .category("Wearables")
                                    .seller("Fitbit")
                                    .build(),

                            Product.builder()
                                    .name("Samsung 55-inch QLED TV")
                                    .description("4K Smart TV with Quantum Dot technology")
                                    .price(1100)
                                    .stock(30)
                                    .category("Electronics")
                                    .seller("Samsung")
                                    .build(),

                            Product.builder()
                                    .name("LG OLED C3 65-inch TV")
                                    .description("OLED TV with perfect blacks and Dolby Vision")
                                    .price(1800)
                                    .stock(20)
                                    .category("Electronics")
                                    .seller("LG")
                                    .build(),

                            Product.builder()
                                    .name("Sony Bravia XR 65-inch")
                                    .description("Smart TV with XR Cognitive Processor")
                                    .price(1700)
                                    .stock(25)
                                    .category("Electronics")
                                    .seller("Sony")
                                    .build(),

                            Product.builder()
                                    .name("iPad Pro 12.9")
                                    .description("Tablet with M2 chip and Liquid Retina display")
                                    .price(1300)
                                    .stock(50)
                                    .category("Electronics")
                                    .seller("Apple Store")
                                    .build(),

                            Product.builder()
                                    .name("Amazon Echo Studio")
                                    .description("Smart speaker with immersive sound")
                                    .price(200)
                                    .stock(140)
                                    .category("Electronics")
                                    .seller("Amazon")
                                    .build(),

                            Product.builder()
                                    .name("JBL Flip 6")
                                    .description("Portable Bluetooth speaker with deep bass")
                                    .price(150)
                                    .stock(180)
                                    .category("Accessories")
                                    .seller("JBL")
                                    .build(),

                            Product.builder()
                                    .name("Anker PowerCore 20000")
                                    .description("High-capacity portable power bank")
                                    .price(80)
                                    .stock(250)
                                    .category("Accessories")
                                    .seller("Anker")
                                    .build(),

                            Product.builder()
                                    .name("PlayStation 5")
                                    .description("Next-gen gaming console from Sony")
                                    .price(550)
                                    .stock(45)
                                    .category("Electronics")
                                    .seller("Sony")
                                    .build()
                    );



            productRepository.saveAll(demoProducts);
            System.out.println("✅ Demo products inserted into database");
        }else {
            System.out.println("Product already exist... Skipping seed ");
        }
    }
}