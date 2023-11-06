package guru.springfamework.api.v1.model;

import lombok.Data;

// Annotation @Data to setUp our CategoryDTO in compilation
@Data
public class CustomerDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String customerUrl;
}
