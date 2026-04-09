package dev.mudile.desafio.desafio.init;

import dev.mudile.desafio.desafio.entity.Product;
import dev.mudile.desafio.desafio.entity.ProductCategory;
import dev.mudile.desafio.desafio.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class DataSeeder {

    private final ProductRepository productRepository;

    @Bean
    CommandLineRunner init(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() > 0) return;

            var now = Instant.now();

            List<Product> products = List.of(
                    Product.builder()
                            .id(UUID.randomUUID())
                            .name("Caneca Java")
                            .description("Caneca clássica para dev Java.")
                            .imageUrl("https://imgs.extra.com.br/1561024386/2xg.jpg?imwidth=1000")
                            .category(ProductCategory.MUGS)
                            .priceInCents(4990)
                            .createdAt(now)
                            .build(),

                    Product.builder()
                            .id(UUID.randomUUID())
                            .name("Camisa Spring Boot")
                            .description("Caneca clássica para dev Java.")
                            .imageUrl("https://imgs.extra.com.br/1561024386/2xg.jpg?imwidth=1000")
                            .category(ProductCategory.T_SHIRTS)
                            .priceInCents(7998)
                            .createdAt(now)
                            .build()
            );

            productRepository.saveAll(products);
        };
    }


}
