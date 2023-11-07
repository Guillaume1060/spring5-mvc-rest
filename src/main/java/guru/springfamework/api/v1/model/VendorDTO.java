package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// Annotation @Data to setUp our VendorDTO in compilation
@Data
public class VendorDTO {
    private Long id;
    private String name;
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
