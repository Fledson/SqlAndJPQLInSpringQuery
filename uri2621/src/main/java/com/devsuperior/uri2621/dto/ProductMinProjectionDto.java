package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductMinProjection;

public class ProductMinProjectionDto {

    private String name;

    public ProductMinProjectionDto() {
    }

    public ProductMinProjectionDto(String name) {
        this.name = name;
    }

    public ProductMinProjectionDto(ProductMinProjection entity) {
        name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductMinProjectionDto{" +
                "name='" + name + '\'' +
                '}';
    }

}
