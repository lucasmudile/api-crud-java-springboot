package dev.mudile.desafio.desafio.service;

import dev.mudile.desafio.desafio.dto.ProductDto;
import dev.mudile.desafio.desafio.dto.ProductPageDto;
import dev.mudile.desafio.desafio.dto.ProductSaveDto;
import dev.mudile.desafio.desafio.entity.Product;
import dev.mudile.desafio.desafio.entity.ProductCategory;
import dev.mudile.desafio.desafio.mapper.ProductMapper;
import dev.mudile.desafio.desafio.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private  final ProductMapper productMapper;


    public ProductPageDto list(int page, int perPage, String search,String category ,String sort) {

        int safePage = Math.max(1, page);
        int safePerPage = Math.min(60, Math.max(1,perPage));

        ProductCategory cat = (category == null || category.isBlank() || "all".equalsIgnoreCase(category))
                ? null :
                ProductCategory.valueOf(category.toUpperCase());


        ProductSort sortEnum =  ProductSort.fromApi(sort);

        Sort springSort = switch (sortEnum){
            case NEWEST ->  Sort.by(Sort.Direction.ASC, "createdAt");
            case PRICE_ASC ->  Sort.by(Sort.Direction.ASC, "price");
            case PRICE_DESC ->  Sort.by(Sort.Direction.DESC, "price");
        };

        Pageable pageable = PageRequest.of(safePage - 1, safePerPage, springSort);

        Specification<Product> spec = Specification.where(ProductSpecs.nameContains(search))
                .and(ProductSpecs.categoryEquals(cat));

        Page<Product> result = productRepository.findAll(spec, pageable);

        return new ProductPageDto(
                result.getContent().stream().map(productMapper::toDto).toList(),
                result.getTotalElements()
        );

    }


    public ProductDto getById(UUID id) {

        Product product = productRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id.toString()));
        return productMapper.toDto(product);

    }

    public ProductDto save(ProductSaveDto productSaveDto) {


      var product =  Product.builder()
                .id(UUID.randomUUID())
                .name(productSaveDto.name())
                .description(productSaveDto.description())
                .imageUrl(productSaveDto.imageUrl())
                .category(ProductCategory.fromString(productSaveDto.category()))
                .priceInCents(productSaveDto.priceInCents())
                .createdAt(Instant.now())
                .build();

        return productMapper.toDto(productRepository.save(product));

    }

    public ProductDto update(ProductDto productSaveDto) {

        var proudct = productRepository.findById(productSaveDto.id()).orElseThrow();

        var product =  proudct.builder()
                .id(productSaveDto.id())
                .name(productSaveDto.name())
                .description(productSaveDto.description())
                .imageUrl(productSaveDto.imageUrl())
                .category(ProductCategory.fromString(productSaveDto.category()))
                .priceInCents(productSaveDto.priceInCents())
                .createdAt(Instant.now())
                .build();

        return productMapper.toDto(productRepository.save(product));

    }

    public void delete(UUID id) {
        var proudct = productRepository.findById(id).orElseThrow();
        productRepository.delete(proudct);
    }
}
