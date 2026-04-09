package dev.mudile.desafio.desafio.entity;

public enum ProductCategory {
    MUGS,
    T_SHIRTS;


    public String toApi() {
        return this == MUGS?"mugs":"t-shirt";
    }

    public static ProductCategory fromString(String value){
        if(value == null) return null;

        return  switch (value){

            case "mugs" -> MUGS;
            case "t-shirts" -> T_SHIRTS;
            default -> throw new IllegalArgumentException("Invalid Category: "+value);
        };
    }

}
