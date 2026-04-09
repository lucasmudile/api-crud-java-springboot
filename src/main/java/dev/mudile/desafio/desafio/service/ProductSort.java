package dev.mudile.desafio.desafio.service;

public enum ProductSort {
    NEWEST,
    PRICE_ASC,
    PRICE_DESC;

    public static  ProductSort fromApi(String value){

        if(value==null)return NEWEST;

        return switch (value){
            case "newest" -> NEWEST;
            case "price_asc" -> PRICE_ASC;
            case "price_desc" -> PRICE_DESC;
            default -> throw new IllegalArgumentException("Invalid sort:  "+value);
        };

    }

}
