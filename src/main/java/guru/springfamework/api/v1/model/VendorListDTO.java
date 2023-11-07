package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor // génère automatiquement un constructeur avec des paramètres pour chaque champ de la classe.
public class VendorListDTO {
    List<VendorDTO> vendors;
}
