package dev.mudile.desafio.desafio.dto;

import java.util.List;

public record ProductPageDto(
        List<ProductDto> items,
        Long total
) {
}
