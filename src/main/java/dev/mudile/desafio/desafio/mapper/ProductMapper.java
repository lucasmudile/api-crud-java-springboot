package dev.mudile.desafio.desafio.mapper;

import dev.mudile.desafio.desafio.dto.ProductDto;
import dev.mudile.desafio.desafio.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        return  ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .priceInCents(product.getPriceInCents())
                .category(product.getCategory().toApi())
                .build();
    }

}
