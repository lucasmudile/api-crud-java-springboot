package dev.mudile.desafio.desafio.service;

import dev.mudile.desafio.desafio.entity.Product;
import dev.mudile.desafio.desafio.entity.ProductCategory;
import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecs {


    private ProductSpecs() {}

    /* Spect Neura: não filtra nada (WHERE 1=1 ) */
    public static Specification<Product> tudo() {
        return (((root, query, criteriaBuilder) -> criteriaBuilder.conjunction()));
    }

    private  static boolean blank(String s){
        return s == null || s.isBlank();
    }

    public  static Specification<Product> nameContains(String search){

        if(blank(search)){
            return tudo();
        }

        String like = "%"+search.trim().toLowerCase()+"%";
        return (((root, query, criteriaBuilder) -> criteriaBuilder.like( criteriaBuilder.lower(root.get("name"))  ,like)));
    }

    public  static Specification<Product> categoryEquals(ProductCategory category){

        if(category==null){
            return tudo();
        }
        return (((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category")  ,category)));
    }



}
