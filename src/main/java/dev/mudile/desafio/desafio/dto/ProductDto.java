package dev.mudile.desafio.desafio.dto;

import dev.mudile.desafio.desafio.entity.Product;
import lombok.Builder;

import java.util.UUID;


@Builder
public record ProductDto(
        UUID id,
        String name,
        String description,
        String imageUrl,
        String category,
        long priceInCents) {
}
