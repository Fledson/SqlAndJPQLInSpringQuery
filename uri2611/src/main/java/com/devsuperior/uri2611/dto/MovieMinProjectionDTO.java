package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovieMinProjection;

public class MovieMinProjectionDTO {

    private Long id;
    private String name;

    public MovieMinProjectionDTO() {
    }

    public MovieMinProjectionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MovieMinProjectionDTO(MovieMinProjection entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovieMinProjectionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
