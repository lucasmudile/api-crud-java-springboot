package dev.mudile.desafio.desafio.dto;


import lombok.Builder;

@Builder
public record ProductSaveDto(String name,
                             String description,
                             String imageUrl,
                             String category,
                             long priceInCents) {
}
