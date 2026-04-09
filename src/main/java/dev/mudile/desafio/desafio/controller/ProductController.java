package dev.mudile.desafio.desafio.controller;

import dev.mudile.desafio.desafio.dto.ProductDto;
import dev.mudile.desafio.desafio.dto.ProductPageDto;
import dev.mudile.desafio.desafio.dto.ProductSaveDto;
import dev.mudile.desafio.desafio.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ProductPageDto list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "12") int perPage,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String sort
    ) {
        return productService.list(page, perPage, search, category, sort);
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable UUID id) {
        return productService.getById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductSaveDto productSaveDto) {
        return productService.save(productSaveDto);
    }

    @PutMapping("{id}")
    public ProductDto update(@PathVariable(name = "id") final UUID id,@RequestBody ProductDto productSaveDto) {
        return productService.update(productSaveDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable(name = "id") final UUID id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
