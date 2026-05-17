package com.carlos.assettrack.assettrack.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Validación para el nombre
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    //Validación para la categoria
    @NotBlank(message = "La categoria es obligatoria")
    private String category;
    //Validación para la categoria
    @NotBlank(message = "El serial es obligatorio")
    private String serialNumber;
    //Validación para la categoria
    @NotBlank(message = "El status es obligatorio")
    private String status; //"Avalaible", "Assigned", "Mainteance"
    //Validación para la categoria
    @NotNull(message = "El valor de compra es obligatorio")
    @Positive(message = "El valor debe ser mayor a 0")
    private Double purchaseValue;


}
