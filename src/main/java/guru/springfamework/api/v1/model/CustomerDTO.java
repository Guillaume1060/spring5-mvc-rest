package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

// Annotation @Data to setUp our CategoryDTO in compilation
@Data
public class CustomerDTO {
    private Long id;
    @Schema(description = "The customer's first name", defaultValue = "Bloggs", required = true)
    private String firstname;
    private String lastname;
    @JsonProperty("customer_url")
    private String customerUrl;
}
