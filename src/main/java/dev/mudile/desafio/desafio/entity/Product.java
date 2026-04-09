package dev.mudile.desafio.desafio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Product {
    @Id
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false, length = 160)
    private String name;

    @Column(nullable = false, length = 600)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  ProductCategory category;


    @Column(nullable = false)
    private long priceInCents;

    private Instant createdAt;

    void prePersist(){

        if(id == null) this.id = UUID.randomUUID();

        if(createdAt == null) this.createdAt = Instant.now();

    }



}
