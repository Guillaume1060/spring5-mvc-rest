package guru.springfamework.api.v1.model;

import lombok.Data;

// Annotation @Data to setUp our CategoryDTO in compilation
@Data
public class CategoryDTO {
    private Long id;
    private String name;
}
